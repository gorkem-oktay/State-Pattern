package com.zafiru.services;

public class JsonParser implements IParser {

    @Override
    public String parse(String response) {
        System.out.println("Parsing Json...");
        return response.replace("{", "").replace("}", "").trim();
    }
}
