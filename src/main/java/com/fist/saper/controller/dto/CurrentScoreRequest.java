package com.fist.saper.controller.dto;

public class CurrentScoreRequest {
    public CurrentScoreRequest(){

    }
    private String name;

    public CurrentScoreRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
