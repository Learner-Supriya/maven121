package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
