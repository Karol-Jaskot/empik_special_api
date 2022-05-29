package pl.jaskot.empik_special_api.backend.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.jaskot.empik_special_api.backend.entity.GithubData;
import pl.jaskot.empik_special_api.backend.entity.UserResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserResponseServiceTest {

    @Autowired
    private UserResponseService userResponseService;

    @Test
    public void calculateStatisticForUser_ZeroParams(){
        double result = userResponseService.calculateStatisticForUser(0,0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculateStatisticForUser_StandardParams(){
        double result = userResponseService.calculateStatisticForUser(12,8);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void parseGithubData_FullDataCopy(){
        GithubData gd = GithubData.builder()
                .id(5L)
                .name("NAME_T")
                .login("LOGIN_T")
                .type("TYPE_T")
                .avatar_url("AVATAR_URL_T")
                .created_at("CREATED_AT_T")
                .build();

        UserResponse ur = userResponseService.parseGithubData(gd);

        assertThat(ur.getId()).isEqualTo(ur.getId());
        assertThat(ur.getName()).isEqualTo(ur.getName());
        assertThat(ur.getLogin()).isEqualTo(ur.getLogin());
        assertThat(ur.getType()).isEqualTo(gd.getType());
        assertThat(ur.getAvatar_url()).isEqualTo(gd.getAvatar_url());
        assertThat(ur.getCreated_at()).isEqualTo(gd.getCreated_at());
    }

    @Test
    public void parseGithubData_CheckCorrectingCalculationInResponse(){
        GithubData gd = GithubData.builder()
                .followers(12)
                .public_repos(8)
                .build();

        UserResponse ur = userResponseService.parseGithubData(gd);
        assertThat(ur.getCalculations()).isEqualTo(5);
    }

}
