package com.promegalex.mycv.controller;

import com.promegalex.mycv.model.UserDefinition;
import com.promegalex.mycv.repository.UserDefinitionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Mehmet Gökhan MERAL on 25.11.2019.
 */
@RestController(value = "/user")
public class UserDefinitionController {
    final UserDefinitionRepositoryImpl userDefinitionRepository;

    @Autowired
    public UserDefinitionController(UserDefinitionRepositoryImpl userDefinitionRepository) {
        this.userDefinitionRepository = userDefinitionRepository;
    }

    @PostMapping("/create")
    public ResponseEntity save(@RequestBody UserDefinition userDefinition) {
        userDefinitionRepository.save(userDefinition);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody UserDefinition userDefinition) {
        userDefinitionRepository.save(userDefinition);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam() String userName) {
        userDefinitionRepository.delete(userName);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<UserDefinition> get(@RequestParam() String userName) {
        Optional<UserDefinition> userDefinition = userDefinitionRepository.get(userName);
        ResponseEntity<UserDefinition> userDefinitionResponseEntity = new ResponseEntity<>(userDefinition.get(), HttpStatus.OK);
        return userDefinitionResponseEntity;
    }
}
