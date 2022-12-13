package com.hieudoanm.javabackendstarter.repository;

import com.hieudoanm.javabackendstarter.dto.user.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDto, String> {
    List<UserDto> findAll();
}
