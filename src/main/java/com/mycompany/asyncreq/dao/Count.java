/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author tiniv_000
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Count {
        @JsonProperty("value")
    public Integer value;
    public Count(){}
    public Integer getvalue() {
        return value;
    }

    public void setvalue(Integer value) {
        this.value = value;
    }
}
