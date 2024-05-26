package com.fist.saper.controller.dto;

public class CurrentScoreResponse {
    public CurrentScoreResponse(){

    }
    private Long score;

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public CurrentScoreResponse(Long score) {
        this.score = score;
    }
}
