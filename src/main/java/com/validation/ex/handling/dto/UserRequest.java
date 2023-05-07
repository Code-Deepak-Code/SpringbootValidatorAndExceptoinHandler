package com.validation.ex.handling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotNull(message = "name should not be null")
    private String name;

    @Email(message = "invalid email address")
    private String email;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "invalid mobile number entered")
    private String mobile;
    private String gender;

    @Min(18)
    @Max(60)
    private String age;

    @NotBlank
    private String nationality;
}
