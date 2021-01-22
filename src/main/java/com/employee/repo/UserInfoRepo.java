package com.employee.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.entity.UserInfo;

public interface UserInfoRepo extends MongoRepository<UserInfo, String>{

}
