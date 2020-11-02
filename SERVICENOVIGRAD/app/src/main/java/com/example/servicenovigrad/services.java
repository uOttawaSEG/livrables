package com.example.servicenovigrad;

public class services {
    String serviceName;
    String serviceid;
    String datecreation;

    public services(){

    }

    public services( String serviceid, String serviceName,String datecreation) {
        this.serviceName = serviceName;
        this.serviceid = serviceid;
        this.datecreation = datecreation;
    }

    public String getDatecreation() {
        return datecreation;
    }


    public String getServiceid() {
        return serviceid;
    }
    public String getServiceName() {
        return serviceName;
    }
}
