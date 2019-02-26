package com.zafiru.services;

public class GameService implements IService {

    @Override
    public void sendRequest() {
        System.out.println("Request is sent to Game Service");
    }

    @Override
    public String getResponse() {
        // I know it is not a Json
        return "{ code: 200, data: Got your request }";
    }
}
