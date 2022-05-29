package pl.jaskot.empik_special_api.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GithubData {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private int public_repos;
    private int followers;

}
