package br.com.rodpk.api.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

    private static final int INDEX = 0;
    private static final String PASSWORD = "123";
    private static final String EMAIL = "elizabeth@gmail.com";
    private static final Integer ID = 1;
    private static final String NAME = "Elizabeth";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }


    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(user);
        ResponseEntity<UserDTO> response = resource.create(userDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
        assertEquals(ResponseEntity.class, response.getClass());
    }

    @Test
    void whenDeleteThenReturnSuccess() {
        doNothing().when(service).delete(anyInt());
        ResponseEntity<UserDTO> response = resource.delete(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        verify(service, times(1)).delete(anyInt());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }

    @Test
    void whenFindAllThenReturnAnListOfUserDTO() {
        when(service.findAll()).thenReturn(List.of(user));
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<List<UserDTO>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(userDTO.getClass(), response.getBody().get(INDEX).getClass());

        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword());
        
    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(service.update(userDTO)).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.update(ID, userDTO);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());


    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(1, NAME, EMAIL, PASSWORD);
    }
}
