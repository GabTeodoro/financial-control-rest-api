package com.study.challenge.financialcontrol.application.controller;

import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.usecase.expense.CreateExpense;
import com.study.challenge.financialcontrol.usecase.expense.DeleteExpense;
import com.study.challenge.financialcontrol.usecase.expense.FindExpenses;
import com.study.challenge.financialcontrol.usecase.expense.UpdateExpense;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense")
@AllArgsConstructor
public class ExpenseController {

    private CreateExpense create;
    private FindExpenses find;
    private UpdateExpense update;
    private DeleteExpense delete;

    @Operation(summary = "Create a new expense")
    @PostMapping
    public ResponseEntity<ResponseMessage> create(@RequestBody ExpenseDTO expenseDTO) {
        return create.execute(expenseDTO);
    }

    @Operation(summary = "List all expenses")
    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> listAll() {
        return find.execute();
    }

    @Operation(summary = "Find an expense by id")
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> findById(@PathVariable Long id) {
        return find.execute(id);
    }

    @Operation(summary = "Update an expense")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id,
                                                  @RequestBody ExpenseDTO expenseDTO) {
        return update.execute(id, expenseDTO);
    }

    @Operation(summary = "Remove a expense")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id) {
        return delete.execute(id);
    }

}
