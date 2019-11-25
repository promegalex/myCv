package com.promegalex.mycv.repository;

import com.promegalex.mycv.model.UserDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Mehmet Gökhan MERAL on 25.11.2019.
 */
@Service
//public class UserDefinitionRepositoryImpl implements UserDefinitionRepository {
public class UserDefinitionRepositoryImpl {
    final UserDefinitionRepository userDefinitionRepository;

    @Autowired
    public UserDefinitionRepositoryImpl(UserDefinitionRepository userDefinitionRepository) {
        this.userDefinitionRepository = userDefinitionRepository;
    }

    public void save(UserDefinition userDefinition) {
        userDefinitionRepository.save(userDefinition);
    }

    public void delete(String userName) {
        userDefinitionRepository.deleteById(userName);
    }

    public Optional<UserDefinition> get(String userName) {
        return userDefinitionRepository.findById(userName);
    }
}
