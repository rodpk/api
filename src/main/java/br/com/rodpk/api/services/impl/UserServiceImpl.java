package br.com.rodpk.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.api.domain.User;
import br.com.rodpk.api.domain.dto.UserDTO;
import br.com.rodpk.api.exceptions.ObjectNotFoundException;
import br.com.rodpk.api.repositories.UserRepository;
import br.com.rodpk.api.services.UserService;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository repository;


    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO dto) {
        
        return repository.save(mapper.map(dto, User.class));
    }
    
}
