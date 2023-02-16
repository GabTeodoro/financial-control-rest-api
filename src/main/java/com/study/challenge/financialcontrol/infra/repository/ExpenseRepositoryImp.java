package com.study.challenge.financialcontrol.infra.repository;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ExpenseRepositoryImp implements ExpenseRepository {

    private ExpenseJPA jpa;

    @Override
    public Expense createExpense(Expense expense) {
        return jpa.save(expense);
    }

    @Override
    public Page<Expense> listAllExpenses(Pageable page) {
        return jpa.findAll(page);
    }

    @Override
    public Optional<Expense> findExpenseById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return jpa.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        jpa.deleteById(id);
    }
}
