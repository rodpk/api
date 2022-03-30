package br.com.rodpk.api.services;

import java.util.List;

import br.com.rodpk.api.domain.User;
import br.com.rodpk.api.domain.dto.UserDTO;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create (UserDTO dto);
    
}
