package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.Payment;
@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

}
