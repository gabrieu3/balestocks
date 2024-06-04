package com.balestocks.scrap.repository;

import com.balestocks.scrap.entity.StockInvestSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInvestSiteRepository extends JpaRepository<StockInvestSite, Integer> {

}
