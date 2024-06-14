package com.aadharapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadharapi.entity.AadharEntity;

public interface AadharRepository extends JpaRepository<AadharEntity, String> {

}