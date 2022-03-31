package br.com.rodpk.api.resources;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rodpk.api.domain.User;
import br.com.rodpk.api.domain.dto.UserDTO;
import br.com.rodpk.api.services.UserService;

@SpringBootTest
public class UserResourceTest {

    @InjectMocks
    private UserResource resource;
    @Mock
    private UserService service;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;

    private static final String EMAIL_JA_CADASTRADO_NO_SISTEMA = "Email já cadastrado no sistema";
    private static final int INDEX = 0;
    private static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    private static final String PASSWORD = "123";
    private static final String EMAIL = "elizabeth@gmail.com";
    private static final Integer ID = 1;
    private static final String NAME = "Elizabeth";

    @Test
    void testCreate() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testUpdate() {

    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(1, NAME, EMAIL, PASSWORD);
    }
}
