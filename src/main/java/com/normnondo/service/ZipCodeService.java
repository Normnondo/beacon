package com.normnondo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.normnondo.controller.ZipCodeResults;
import com.normnondo.entity.ZipCodeItem;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ZipCodeService {

    private Properties properties;

    public ZipCodeService() {
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


    public List<ZipCodeItem> zipCodeAPI(String zipCode) throws Exception {
        Client client = ClientBuilder.newClient();
        /* URL should come from a properties file, parameter from a, well, a parameter */
        WebTarget target =
                client.target(properties.getProperty("apiKey") + zipCode + properties.getProperty("apiRadius"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ZipCodeResults results = mapper.readValue(response, ZipCodeResults.class);
        List<ZipCodeItem> item = results.getZipCodes();
        return item;

    }

}
