package com.run.gtask.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password; // In mod normal nu trebuia sa expun parola, dar fiinde un proiect de teste, este ok
}
