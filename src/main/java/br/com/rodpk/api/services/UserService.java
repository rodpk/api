package br.com.rodpk.api.services;

import br.com.rodpk.api.domain.User;

public interface UserService {

    User findById(Integer id);
    
}
