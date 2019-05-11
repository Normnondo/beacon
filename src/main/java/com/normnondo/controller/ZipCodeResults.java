package com.normnondo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import com.normnondo.entity.ZipCodeItem;
import java.util.List;

/**
 * Bean to provide variables to get the results from the zip code api
 */
@Generated("com.robohorse.robopojogenerator")
public class ZipCodeResults{

    @JsonProperty("zip_codes")
    private List<ZipCodeItem> zipCodes;

    /**
     * Set zip codes.
     *
     * @param zipCodes the zip codes
     */
    public void setZipCodes(List<ZipCodeItem> zipCodes){
        this.zipCodes = zipCodes;
    }

    /**
     * Get zip codes list.
     *
     * @return the list
     */
    public List<ZipCodeItem> getZipCodes(){
        return zipCodes;
    }

    @Override
    public String toString(){
        return
                "Results{" +
                        "zip_codes = '" + zipCodes + '\'' +
                        "}";
    }
}

