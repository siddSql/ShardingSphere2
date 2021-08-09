package com.example.dbtablesharding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbtablesharding.model.TOrder0;

@Repository
public interface OrderRepository extends JpaRepository<TOrder0, Long> {
}