package com.springboot.eschool.repository;

import com.springboot.eschool.model.Holiday;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface HolidaysRepository extends JpaRepository<Holiday, String> {

}
