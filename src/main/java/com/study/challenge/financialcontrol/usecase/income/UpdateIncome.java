package com.study.challenge.financialcontrol.usecase.income;

import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateIncome {

    ResponseEntity execute(Long id, IncomeDTO incomeDTO);
}
