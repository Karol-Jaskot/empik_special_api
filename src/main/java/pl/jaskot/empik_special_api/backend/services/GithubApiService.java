package pl.jaskot.empik_special_api.backend.services;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.jaskot.empik_special_api.backend.entity.GithubData;

@Service
public class GithubApiService {
    private static Logger log = LogManager.getLogger(GithubApiService.class);

    @Value("${github,path}")
    private String GITHUB_PATH;

    public GithubData getGithubData(String login) {
        String requestPath = GITHUB_PATH+"/users/"+login;
        GithubData githubData = null;

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response
                    = restTemplate.getForEntity(requestPath, String.class);
            githubData = parseData(response.getBody());
        }catch (Exception e){
            log.error(e.toString());
        }
        return githubData;
    }

    private GithubData parseData(String data){
        Gson gson = new Gson();
        GithubData githubData = gson.fromJson(data, GithubData.class);
        return githubData;
    }

}
