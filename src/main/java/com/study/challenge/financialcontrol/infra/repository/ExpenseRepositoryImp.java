package com.study.challenge.financialcontrol.infra.repository;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public List<Expense> listAllExpenses() {
        return jpa.findAll();
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
