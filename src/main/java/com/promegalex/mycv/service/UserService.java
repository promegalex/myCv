package com.promegalex.mycv.service;

import com.promegalex.mycv.model.UserDefinition;
import com.promegalex.mycv.repository.UserDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Mehmet Gökhan MERAL on 25.11.2019.
 */
@Service
public class UserService implements UserDetailsService {
    final UserDefinitionRepository userDefinitionRepository;

    @Autowired
    public UserService(UserDefinitionRepository userDefinitionRepository) {
        this.userDefinitionRepository = userDefinitionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDefinition> byId = userDefinitionRepository.findById(username);
        if (!byId.isPresent()) {
            throw new UsernameNotFoundException("User cannot be found.!");
        }
        return byId.get();
    }
}
