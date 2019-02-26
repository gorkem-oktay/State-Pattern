package com.zafiru.services;

public class ServiceAdapter implements IService {

    private IService service;
    private IParser parser;

    public ServiceAdapter(IService service) {
        this.service = service;

        if(service instanceof GameService){
            parser = new JsonParser();
        } else if (service instanceof DatabaseService) {
            parser = new XMLParser();
        }
    }

    @Override
    public void sendRequest() {
        service.sendRequest();
    }

    @Override
    public String getResponse() {
        String actualResponse = service.getResponse();
        System.out.println(actualResponse);
        return parser.parse(actualResponse);
    }
}
