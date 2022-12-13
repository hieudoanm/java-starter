package com.hieudoanm.javabackendstarter.dto.task;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskRequestDto {
    @JsonValue
    private String title;

    @JsonValue
    private String description = "";

    @JsonValue
    private String listId;

    @JsonValue
    private Boolean completed = false;
}
