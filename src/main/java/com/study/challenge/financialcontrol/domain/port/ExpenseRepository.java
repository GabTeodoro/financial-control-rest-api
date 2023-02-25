package com.study.challenge.financialcontrol.domain.port;

import com.study.challenge.financialcontrol.domain.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {

    Expense createExpense(Expense expense);
    List<Expense> listAllExpenses();
    Optional<Expense> findExpenseById(Long id);
    Expense updateExpense(Expense expense);
    void deleteExpense(Long id);
}
