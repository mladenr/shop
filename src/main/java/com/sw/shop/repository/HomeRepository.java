package com.sw.shop.repository;

import com.sw.shop.domain.HomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends CrudRepository<HomeEntity, Long> {
}
