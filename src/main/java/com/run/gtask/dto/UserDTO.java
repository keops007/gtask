package com.run.gtask.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password; // Nu expune parola în mod normal, dar aici e pentru exemplu
}
