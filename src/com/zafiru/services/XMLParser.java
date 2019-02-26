package com.zafiru.services;

public class XMLParser implements IParser {

    @Override
    public String parse(String response) {
        System.out.println("Parsing XML...");
        return response.replace("<", "").replace(">", "").trim();
    }
}
