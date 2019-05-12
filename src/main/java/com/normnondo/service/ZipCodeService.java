package com.normnondo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.normnondo.entity.ZipCodeResults;
import com.normnondo.entity.ZipCodeItem;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * The type Zip code service.
 */
public class ZipCodeService {

    private Properties properties;

    /**
     * Instantiates a new Zip code service.
     */
    public ZipCodeService() {
        loadProperties();
    }

    /**
     * Loads the properties from the zipcode.properties file
     */
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

    /**
     * Zip code api list.
     *
     * @param zipCode the zip code
     * @return the list
     * @throws Exception the exception
     */
    public List<ZipCodeItem> zipCodeAPI(String zipCode) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(properties.getProperty("apiKey") + zipCode + properties.getProperty("apiRadius"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ZipCodeResults results = mapper.readValue(response, ZipCodeResults.class);
        List<ZipCodeItem> item = results.getZipCodes();
        return item;

    }

}
