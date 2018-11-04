package com.sw.shop.repository;

import com.sw.shop.domain.ProductGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroupEntity, Long> {
}
