package com.study.challenge.financialcontrol.infra.repository;

import com.study.challenge.financialcontrol.domain.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IncomeJPA extends JpaRepository<Income, Long> {

    @Query("SELECT i FROM Income i WHERE i.description = :description AND i.date BETWEEN :firstDay AND :lastDay")
    Income findIncomeDescriptionMonth(@Param("description") String description,
                                      @Param("firstDay") LocalDate firstDay,
                                      @Param("lastDay") LocalDate lastDay);
}
