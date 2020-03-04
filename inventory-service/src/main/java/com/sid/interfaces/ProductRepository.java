package com.sid.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sid.models.Product;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

}
