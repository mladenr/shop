package com.sw.shop.service;

import com.sw.shop.domain.UserEntity;
import com.sw.shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
