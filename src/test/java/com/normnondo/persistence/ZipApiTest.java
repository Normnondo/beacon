package com.normnondo.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.normnondo.controller.ZipCodeResults;
import com.normnondo.entity.ZipCodeItem;
import org.junit.jupiter.api.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipApiTest {

    private Properties properties;

    public ZipApiTest() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/zipcode.properties"));
        } catch (IOException ioe) {
            System.out.println("ZipCodeService.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("ZipCodeService.loadProperties()..." + e);
            e.printStackTrace();
        }
    }

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        /* URL should come from a properties file, parameter from a, well, a parameter */
        WebTarget target =
                client.target(properties.getProperty("apiKey") + "53718" + properties.getProperty("apiRadius"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ZipCodeResults results = mapper.readValue(response, ZipCodeResults.class);
        ZipCodeItem item = results.getZipCodes().get(0);

        assertEquals("53558", item.getZipCode());
    }
}