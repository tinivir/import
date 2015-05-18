/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq.dao;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author tiniv_000
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
        @JsonProperty("validation")
    public Validation validation;
    public List<Tdataset> dataset;
    public String addr;

    public Root() {
    }

    public List<Tdataset> getTdataset() {
        return dataset;
    }

    public void setTdataset(List<Tdataset> dataset) {
        this.dataset = dataset;
    }
    
}
