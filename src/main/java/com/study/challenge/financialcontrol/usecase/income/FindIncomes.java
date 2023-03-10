package com.study.challenge.financialcontrol.usecase.income;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface FindIncomes {

    ResponseEntity execute();
    ResponseEntity execute(Long id);
}
