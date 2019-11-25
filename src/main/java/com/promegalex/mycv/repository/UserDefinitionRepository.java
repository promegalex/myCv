package com.promegalex.mycv.repository;

import com.promegalex.mycv.model.UserDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Mehmet Gökhan MERAL on 25.11.2019.
 */
public interface UserDefinitionRepository extends MongoRepository<UserDefinition, String> {
}
