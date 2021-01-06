package com.example.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lkm.entity.EmployeeEntity;

public interface EmployeeDAO  extends JpaRepository<EmployeeEntity, Integer>{

}
