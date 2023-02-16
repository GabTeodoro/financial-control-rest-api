package com.study.challenge.financialcontrol.usecase.expense;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface FindExpenses {

    ResponseEntity execute(Pageable pageable);
    ResponseEntity execute(Long id);
}
