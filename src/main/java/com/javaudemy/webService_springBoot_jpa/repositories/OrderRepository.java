package com.javaudemy.webService_springBoot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaudemy.webService_springBoot_jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
