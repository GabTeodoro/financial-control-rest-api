package com.study.challenge.financialcontrol.usecase.income;

import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import org.springframework.http.ResponseEntity;

public interface CreateIncome {

    ResponseEntity execute(IncomeDTO incomeDTO);
}
