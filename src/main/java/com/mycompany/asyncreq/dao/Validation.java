/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq.dao;
// Generated Apr 28, 2015 1:27:36 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author tiniv_000
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Validation
    {
    @JsonProperty("count")
    public Count count;
    public Validation() {
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

        //public Datasettimer datasetTimer { get; set; }
    }
