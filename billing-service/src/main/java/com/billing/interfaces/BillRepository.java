package com.billing.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.billing.models.Bill;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long>{

}
