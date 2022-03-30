package br.com.rodpk.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodpk.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
