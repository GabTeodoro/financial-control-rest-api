package com.study.challenge.financialcontrol.usecase.expense;

import org.springframework.http.ResponseEntity;

public interface DeleteExpense {

    ResponseEntity execute(Long id);
}
