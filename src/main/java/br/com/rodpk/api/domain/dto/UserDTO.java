package br.com.rodpk.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private String password;
    
}
