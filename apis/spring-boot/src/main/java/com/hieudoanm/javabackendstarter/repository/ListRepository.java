package com.hieudoanm.javabackendstarter.repository;

import com.hieudoanm.javabackendstarter.dto.list.ListDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepository extends CrudRepository<ListDto, String> {
    List<ListDto> findAll();
}
