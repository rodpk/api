package br.com.rodpk.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.rodpk.api.domain.User;
import br.com.rodpk.api.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean // sobe sempre que ta ativo
    public void startDB() {
        User u1 = new User(null, "Rodrigo", "rodrigo@gmail.com", "123");
        User u2 = new User(null, "Gisele", "gisele@gmail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
