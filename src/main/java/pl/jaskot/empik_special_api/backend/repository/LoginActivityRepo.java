package pl.jaskot.empik_special_api.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jaskot.empik_special_api.backend.entity.LoginActivity;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface LoginActivityRepo extends CrudRepository<LoginActivity, Long> {

    Optional<LoginActivity> findByLogin(String login);
}
