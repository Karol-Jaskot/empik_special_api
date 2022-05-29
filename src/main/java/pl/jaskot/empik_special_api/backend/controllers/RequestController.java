package pl.jaskot.empik_special_api.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.jaskot.empik_special_api.backend.entity.GithubData;
import pl.jaskot.empik_special_api.backend.entity.LoginActivity;
import pl.jaskot.empik_special_api.backend.entity.UserResponse;
import pl.jaskot.empik_special_api.backend.services.GithubApiService;
import pl.jaskot.empik_special_api.backend.services.LoginActivityService;
import pl.jaskot.empik_special_api.backend.services.UserResponseService;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private GithubApiService githubApiService;

    @Autowired
    private LoginActivityService loginActivityService;

    @Autowired
    private UserResponseService userResponseService;

    @GetMapping("/users/{login}")
    UserResponse getUserInfo(@PathVariable String login) {
        GithubData githubData = githubApiService.getGithubData(login);
        loginActivityService.incrementLogin(login);
        if (githubData == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return userResponseService.parseGithubData(githubData);
    }

    @GetMapping("/users/all")
    List<LoginActivity> getAllLoginActivity() {
        return loginActivityService.getAllLoginActivity();
    }
}
