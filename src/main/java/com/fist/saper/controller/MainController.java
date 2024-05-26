package com.fist.saper.controller;

import com.fist.saper.controller.dto.*;
import com.fist.saper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/checkName")
    public CheckNameResponse checkNameAndCreateIfNeedIt(@RequestBody CheckNameRequest request) {
        System.out.println("Пришел запрос на проверку имени!");
        var isNameFree = userService.checkName(request.getName());
        var checkNameResponse = new CheckNameResponse(isNameFree);
        return checkNameResponse;
    }

    @PostMapping("/score")
    public CurrentScoreResponse getScoreByName(@RequestBody CurrentScoreRequest request) {
        var score = userService.getScoreByName(request.getName());
        var response = new CurrentScoreResponse(score);
        return response;
    }

    @PostMapping("/shareScore")
    public void shareScore(@RequestBody ShareScoreRequest request) {
        userService.shareScore(request.getName(), request.getScore());
    }

    @GetMapping("/topPlayer")
    public TopPlayerResponse getTopPlayer() {
        List<PlayerInfo> playerInfoList = userService.getAll().stream().map(user ->
                new PlayerInfo(user.getName(), user.getPoints())).toList();
        return new TopPlayerResponse(playerInfoList);
    }
}
