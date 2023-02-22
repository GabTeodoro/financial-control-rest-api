package com.study.challenge.financialcontrol.infra.repository;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExpenseJPA extends JpaRepository<Expense, Long> {
    @Query("SELECT e FROM Expense e WHERE e.description = :description AND e.date BETWEEN :firstDay AND :lastDay")
    Expense findExpenseDescriptionMonth(@Param("description") String description,
                                      @Param("firstDay") LocalDate firstDay,
                                      @Param("lastDay") LocalDate lastDay);
}
