package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.PassengerInfo;

public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long> {

}
