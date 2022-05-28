package pl.jaskot.empik_special_api.backend.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jaskot.empik_special_api.backend.entity.LoginActivity;
import pl.jaskot.empik_special_api.backend.repository.LoginActivityRepo;

import java.util.List;
import java.util.Optional;

@Service
public class LoginActivityService {

    private static Logger log = LogManager.getLogger(LoginActivityService.class);
    @Autowired
    LoginActivityRepo repo;

    public void incrementLogin(String login){
        LoginActivity loginActivity = getLoginActivity(login);
        loginActivity.setRequest_count(loginActivity.getRequest_count() + 1);
        repo.save(loginActivity);
    }

    public LoginActivity getLoginActivity(String login){
        LoginActivity loginActivity;
        Optional<LoginActivity> data = repo.findByLogin(login);
        if (data.isPresent() == true) {
            loginActivity = data.get();
        } else {
            loginActivity = LoginActivity.builder()
                    .login(login)
                    .build();
        }
        return loginActivity;
    }

    public List<LoginActivity> getAllLoginActivity(){
        return (List<LoginActivity>) repo.findAll();
    }

}
