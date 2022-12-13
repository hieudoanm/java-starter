package com.hieudoanm.javabackendstarter.service;

import com.hieudoanm.javabackendstarter.dto.list.ListDto;
import com.hieudoanm.javabackendstarter.dto.list.ListRequestDto;
import com.hieudoanm.javabackendstarter.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListService {
    @Autowired
    private ListRepository listRepository;

    public List<ListDto> getLists() {
        return listRepository.findAll();
    }

    public ListDto createList(ListRequestDto listRequest) {
        ListDto listDto = new ListDto();
        String uuid = UUID.randomUUID().toString();
        listDto.setId(uuid);
        listDto.setTitle(listRequest.getTitle());
        listDto.setDescription(listRequest.getDescription());
        listDto.setUserId(listRequest.getUserId());
        return listRepository.save(listDto);
    }

    public ListDto getList(String id) {
        return listRepository.findById(id).orElse(null);
    }

    public ListDto updateList(String id, ListRequestDto listRequest) throws Exception {
        ListDto listDto = listRepository.findById(id).orElse(null);
        if (listDto == null) {
            throw new Exception("Error Message");
        }
        listDto.setTitle(listRequest.getTitle());
        listDto.setDescription(listRequest.getDescription());
        listDto.setUserId(listRequest.getUserId());
        listRepository.save(listDto);
        return listDto;
    }

    public void deleteList(String id) {
        listRepository.deleteById(id);
    }
}
