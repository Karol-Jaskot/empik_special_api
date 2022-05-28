package pl.jaskot.empik_special_api.backend.services;

import org.springframework.stereotype.Service;
import pl.jaskot.empik_special_api.backend.entity.GithubData;
import pl.jaskot.empik_special_api.backend.entity.UserResponse;

@Service
public class UserResponseService {

    public UserResponse parseGithubData(GithubData git){
        return UserResponse.builder()
                .id(git.getId())
                .login(git.getLogin())
                .name(git.getName())
                .type(git.getType())
                .avatar_url(git.getAvatar_url())
                .created_at(git.getCreated_at())
                .calculations(calculateStatisticForUser(git.getFollowers(), git.getPublic_repos()))
                .build();
    }

    public double calculateStatisticForUser(int followers, int public_repo){
        if(followers < 1){
            return 0.0;
        }
        return 6.0 / ((double) followers) * (2+ ((double) public_repo));
    }
}