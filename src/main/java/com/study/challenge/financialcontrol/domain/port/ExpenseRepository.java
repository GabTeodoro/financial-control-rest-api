package com.study.challenge.financialcontrol.domain.port;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ExpenseRepository {

    Expense createExpense(Expense expense);
    Page<Expense> listAllExpenses(Pageable page);
    Optional<Expense> findExpenseById(Long id);
    Expense updateExpense(Expense expense);
    void deleteExpense(Long id);
}
