package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.beans.PaymentTraining;
@Repository
public interface PaymentDaoForTraining extends JpaRepository<PaymentTraining, Long> {

}
