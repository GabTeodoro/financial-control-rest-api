package com.study.challenge.financialcontrol.usecase.expense;

import org.springframework.http.ResponseEntity;

public interface FindExpenses {

    ResponseEntity execute();
    ResponseEntity execute(Long id);
}
