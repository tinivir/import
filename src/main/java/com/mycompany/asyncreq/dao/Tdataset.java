/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asyncreq.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author tiniv_000
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tdataset implements java.io.Serializable
    {
    @JsonProperty("NetWeight")
     private Long NetWeight;
    @JsonProperty("TradeValue")
     private Long TradeValue;
    @JsonProperty("pfCode")
    private String pfCode; 
    @JsonProperty("yr")
        private Integer yr ;
    @JsonProperty("period")
        private String period ;
    @JsonProperty("periodDesc")
        private String periodDesc ;
    @JsonProperty("aggrLevel")
        private Integer aggrLevel ;
    @JsonProperty("IsLeaf")
        private Integer IsLeaf ;
    @JsonProperty("rgCode")
        private Integer rgCode ;
    @JsonProperty("rgDesc")
        private String rgDesc ;
    @JsonProperty("rtCode")
        private Integer rtCode ;
    @JsonProperty("rtTitle")
        private String rtTitle ;
    @JsonProperty("rt3ISO")
        private String rt3ISO ;
    @JsonProperty("ptCode")
        private Integer ptCode ;
    @JsonProperty("ptTitle")
        private String ptTitle ;
    @JsonProperty("pt3ISO")
        private String pt3ISO ;
    @JsonProperty("cmdCode")
        private String cmdCode ;
    @JsonProperty("cmdDescE")
        private String cmdDescE ;
    @JsonProperty("qtCode")
        private Integer qtCode ;
    @JsonProperty("qtDesc")
        private String qtDesc ;
    @JsonProperty("TradeQuantity")
        private Integer TradeQuantity ;
    @JsonProperty("estCode")
         private Integer estCode ;
    
        
public Tdataset(){
}
//public Tdataset( Integer NetWeight, Long TradeValue,Integer TradeQuantity,String qtDesc,Integer qtCode,String cmdDescE,
//                String cmdCode,String pt3ISO,String ptTitle,Integer ptCode,String rt3ISO,String rtTitle,
//                Integer rtCode,String rgDesc,Integer rgCode,Integer IsLeaf ,Integer aggrLevel,String periodDesc,String period,String pfCode, Integer yr,Integer estCode) {
//
//       this.NetWeight = NetWeight;
//       this.TradeValue = TradeValue;
//       this.pfCode=pfCode;
//       this.TradeQuantity=TradeQuantity;
//       this.qtDesc=qtDesc;
//       this.qtCode=qtCode;
//       this.cmdDescE=cmdDescE;
//       this.cmdCode=cmdCode;
//       this.pt3ISO=pt3ISO;
//       this.ptTitle=ptTitle;
//       this.ptCode=ptCode;
//       this.rt3ISO=rt3ISO;
//       this.rtTitle=rtTitle;
//       this.rtCode=rtCode;
//       this.rgDesc=rgDesc;
//       this.rgCode=rgCode;
//       this.IsLeaf=IsLeaf;
//       this.aggrLevel=aggrLevel;
//       this.periodDesc=periodDesc;
//       this.period=period;
//       this.yr=yr;
//       this.estCode=estCode;
//    }
//    
   public String getpfCode() {
        return this.pfCode;
    }
    
    public void setpfCode(String pfCode) {
        this.pfCode = pfCode;
    }
    
    public Integer getTradeQuantity() {
        return this.TradeQuantity;
    }
    
    public void setTradeQuantity(Integer TradeQuantity) {
        this.TradeQuantity = TradeQuantity;
    }
    
    public Integer getestCode() {
        return this.estCode;
    }
    
    public void setestCode(Integer estCode) {
        this.estCode = estCode;
    }
    
    public String getqtDesc() {
        return this.qtDesc;
    }
    
    public void setqtDesc(String qtDesc) {
        this.qtDesc = qtDesc;
    }
    
    public Integer getqtCode() {
        return this.qtCode;
    }
    
    public void setqtCode(Integer qtCode) {
        this.qtCode = qtCode;
    }
    
    public String getcmdDescE() {
        return this.cmdDescE;
    }
    
    public void setcmdDescE(String cmdDescE) {
        this.cmdDescE = cmdDescE;
    }
    
    public String getcmdCode() {
        return this.cmdCode;
    }
    
    public void setcmdCode(String cmdCode) {
        this.cmdCode = cmdCode;
    }
    
    public String getpt3ISO() {
        return this.pt3ISO;
    }
    
    public void setpt3ISO(String pt3ISO) {
        this.pt3ISO = pt3ISO;
    }
        
    public String getptTitle() {
        return this.ptTitle;
    }
    
    public void setptTitle(String ptTitle) {
        this.ptTitle = ptTitle;
    }
        
    public Integer getptCode() {
        return this.ptCode;
    }
    
    public void setptCode(Integer ptCode) {
        this.ptCode = ptCode;
    }    
        
                  
    public String getrt3ISO() {
        return this.rt3ISO;
    }
    
    public void setrt3ISO(String rt3ISO) {
        this.rt3ISO = rt3ISO;
    }
    
            
    public String getrtTitle() {
        return this.rtTitle;
    }
    
    public void setrtTitle(String rtTitle) {
        this.rtTitle = rtTitle;
    }
            
    public Integer getrtCode() {
        return this.rtCode;
    }
    
    public void setrtCode(Integer rtCode) {
        this.rtCode = rtCode;
    }  
    
    public String getrgDesc() {
        return this.rgDesc;
    }
    
    public void setrgDesc(String rgDesc) {
        this.rgDesc = rgDesc;
    }
        
    public Integer getrgCode() {
        return this.rgCode;
    }
    
    public void setrgCode(Integer rgCode) {
        this.rgCode = rgCode;
    }
    
    
    public Integer getIsLeaf() {
        return this.IsLeaf;
    }
    
    public void setIsLeaf(Integer IsLeaf) {
        this.IsLeaf = IsLeaf;
    }  
    
    public Integer getaggrLevel() {
        return this.aggrLevel;
    }
    
    public void setaggrLevel(Integer aggrLevel) {
        this.aggrLevel = aggrLevel;
    } 
    
    public String getperiod() {
        return this.period;
    }
    
    public void setperiod(String period) {
        this.period = period;
    }
    
    public String getperiodDesc() {
        return this.periodDesc;
    }
    
    public void setperiodDesc(String periodDesc) {
        this.periodDesc = periodDesc;
    }
        
    public Integer getyr() {
        return this.yr;
    }
    
    public void setyr(Integer yr) {
        this.yr = yr;
    }
 
    public Long getNetWeight() {
        return this.NetWeight;
    }
    public void setNetWeight(Long netWeight) {
        this.NetWeight = netWeight;
    }

    

    public Long getTradeValue() {
        return this.TradeValue;
    }
    
    public void setTradeValue(Long tradeValue) {
        this.TradeValue = tradeValue;
    }
    

    }
