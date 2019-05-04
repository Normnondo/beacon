package com.normnondo.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.normnondo.controller.ZipCodeResults;
import com.normnondo.entity.ZipCodeItem;
import org.junit.jupiter.api.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipApiTest {

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        /* URL should come from a properties file, parameter from a, well, a parameter */
        WebTarget target =
                client.target("http://www.zipcodeapi.com/rest/RkHTdaAywKYLymkAkFjsrxlra7SSk6gzyVKW39GispOVdLhQjusWmjSmade3Yrgs/radius.json/53718/10/miles");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ZipCodeResults results = mapper.readValue(response, ZipCodeResults.class);
        ZipCodeItem item = results.getZipCodes().get(0);

        assertEquals("53558", item.getZipCode());
    }
}