package com.study.challenge.financialcontrol.usecase.income;

import org.springframework.http.ResponseEntity;

public interface DeleteIncome {

    ResponseEntity execute(Long id);
}
