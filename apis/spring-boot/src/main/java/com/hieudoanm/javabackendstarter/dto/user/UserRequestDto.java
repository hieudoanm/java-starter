package com.hieudoanm.javabackendstarter.dto.user;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    @JsonValue
    private String username;

    @JsonValue
    private String password;
}
