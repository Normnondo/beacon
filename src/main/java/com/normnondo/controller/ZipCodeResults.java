package com.normnondo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import com.normnondo.entity.ZipCodeItem;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class ZipCodeResults{

    @JsonProperty("zip_codes")
    private List<ZipCodeItem> zipCodes;

    public void setZipCodes(List<ZipCodeItem> zipCodes){
        this.zipCodes = zipCodes;
    }

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

