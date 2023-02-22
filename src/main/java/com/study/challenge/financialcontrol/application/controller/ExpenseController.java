package com.study.challenge.financialcontrol.application.controller;

import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.usecase.expense.CreateExpense;
import com.study.challenge.financialcontrol.usecase.expense.DeleteExpense;
import com.study.challenge.financialcontrol.usecase.expense.FindExpenses;
import com.study.challenge.financialcontrol.usecase.expense.UpdateExpense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/expense")
@AllArgsConstructor
public class ExpenseController {

    private CreateExpense create;
//    private FindExpenses find;
//    private UpdateExpense update;
//    private DeleteExpense delete;

    @PostMapping
    public ResponseEntity<ResponseMessage> create(@RequestBody ExpenseDTO expenseDTO) {
        return create.execute(expenseDTO);
    }

}