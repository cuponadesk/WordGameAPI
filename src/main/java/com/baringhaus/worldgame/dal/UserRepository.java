package com.baringhaus.worldgame.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.baringhaus.worldgame.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
