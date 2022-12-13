package com.hieudoanm.javabackendstarter.controller;

import com.hieudoanm.javabackendstarter.dto.list.ListDto;
import com.hieudoanm.javabackendstarter.dto.list.ListRequestDto;
import com.hieudoanm.javabackendstarter.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/lists", produces = APPLICATION_JSON_VALUE)
public class ListController {
    private final ListService listService;

    @GetMapping
    public List<ListDto> getLists() {
        return listService.getLists();
    }

    @PostMapping
    public ListDto createList(@Validated @RequestBody ListRequestDto listRequest) {
        return listService.createList(listRequest);
    }

    @GetMapping("/{id}")
    public ListDto getList(
            @PathVariable(value = "id") String id
    ) {
        return listService.getList(id);
    }

    @PutMapping("/{id}")
    public ListDto updateList(
            @PathVariable(value = "id") String id,
            @Validated @RequestBody ListRequestDto listRequest
    ) throws Exception {
        return listService.updateList(id, listRequest);
    }

    @PatchMapping("/{id}")
    public ListDto patchList(
            @PathVariable(value = "id") String id,
            @Validated @RequestBody ListRequestDto listRequest
    ) throws Exception {
        return listService.updateList(id, listRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteList(
            @PathVariable(value = "id") String id
    ) {
        listService.deleteList(id);
    }
}
