package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Rate;

@Repository
public interface RmsRepository extends JpaRepository<Rate, Long>{

}
