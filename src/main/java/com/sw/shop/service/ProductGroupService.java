package com.sw.shop.service;

import com.sw.shop.domain.ProductGroupEntity;
import com.sw.shop.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductGroupService {

    private ProductGroupRepository productGroupRepository;

    public ProductGroupService (ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }

    public Iterable<ProductGroupEntity> findAll() {
        return productGroupRepository.findAll();
    }

    public Optional<ProductGroupEntity> findById(Long id) {
        return productGroupRepository.findById(id);
    }

    public ProductGroupEntity save(ProductGroupEntity productGroup){
        return productGroupRepository.save(productGroup);
    }

    public void deleteById(Long id) {
        productGroupRepository.deleteById(id);
    }
}
