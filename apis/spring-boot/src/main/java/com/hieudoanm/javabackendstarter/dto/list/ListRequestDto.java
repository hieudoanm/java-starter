package com.hieudoanm.javabackendstarter.dto.list;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListRequestDto {
    @JsonValue
    private String title;

    @JsonValue
    private String description = "";

    @JsonValue
    private String userId;
}
