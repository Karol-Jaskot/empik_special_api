package pl.jaskot.empik_special_api.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private double calculations;

}
