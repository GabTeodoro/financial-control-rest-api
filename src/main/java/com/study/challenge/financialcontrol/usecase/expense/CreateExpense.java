package com.study.challenge.financialcontrol.usecase.expense;

import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import org.springframework.http.ResponseEntity;

public interface CreateExpense {

    ResponseEntity execute(ExpenseDTO expenseDTO);
}
