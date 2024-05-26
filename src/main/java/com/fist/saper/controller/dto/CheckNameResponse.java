package com.fist.saper.controller.dto;

public class CheckNameResponse {
    public CheckNameResponse (){

    }
    private boolean isNameFree;

    public boolean isNameFree() {
        return isNameFree;
    }

    public void setNameFree(boolean nameFree) {
        isNameFree = nameFree;
    }

    public CheckNameResponse(boolean isNameFree) {
        this.isNameFree = isNameFree;
    }
}
