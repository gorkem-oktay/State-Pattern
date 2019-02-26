package com.zafiru.services;

public class DatabaseService implements IService {

    @Override
    public void sendRequest() {
        System.out.println("Request is sent to Database Service");
    }

    @Override
    public String getResponse() {
        // I know it is not a XML
        return "< code: 200, data: Got your request >";
    }
}
