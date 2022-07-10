package com.kimsiyong.securitybasic.config.auth;

import com.kimsiyong.securitybasic.model.User;
import com.kimsiyong.securitybasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userEntity = Optional.ofNullable(userRepository.findByUsername(username));

        if(userEntity.isPresent()){
            return new PrincipalDetails(userEntity.get());
        }


        return null;
    }
}
