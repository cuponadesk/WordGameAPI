package com.baringhaus.worldgame.dal;

import com.baringhaus.worldgame.model.Letters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettersRepository extends MongoRepository<Letters, String> {



}
