package com.sw.shop.service;

import com.sw.shop.domain.HomeEntity;
import com.sw.shop.domain.ProductGroupEntity;
import com.sw.shop.repository.HomeRepository;
import com.sw.shop.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class HomeService {

    private HomeRepository homeRepository;

    public HomeService (HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public Iterable<HomeEntity> findAll() {
        return homeRepository.findAll();
    }

    public Optional<HomeEntity> findById(Long id) {
        return homeRepository.findById(id);
    }

    public HomeEntity save(HomeEntity home){
        return homeRepository.save(home);
    }

    public void deleteById(Long id) {
        homeRepository.deleteById(id);
    }
}
