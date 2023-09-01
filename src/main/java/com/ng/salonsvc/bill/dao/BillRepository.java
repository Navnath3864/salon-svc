package com.ng.salonsvc.bill.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ng.salonsvc.bill.dao.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Integer> {

}
