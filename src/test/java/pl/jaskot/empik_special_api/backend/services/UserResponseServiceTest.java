package pl.jaskot.empik_special_api.backend.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.util.Assert;

@SpringBootTest
public class UserResponseServiceTest {

    @Autowired
    UserResponseService userResponseService;

    @Test
    public void calculateStatisticForUser_ZeroParams(){
        double result = userResponseService.calculateStatisticForUser(0,0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculateStatisticForUser_GoodParams(){
        double result = userResponseService.calculateStatisticForUser(12,8);
        assertThat(result).isEqualTo(5);
    }

}
