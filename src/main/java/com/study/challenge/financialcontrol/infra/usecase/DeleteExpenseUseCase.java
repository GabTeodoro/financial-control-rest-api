package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.usecase.expense.DeleteExpense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteExpenseUseCase implements DeleteExpense {

    private final ExpenseRepository repository;

    @Override
    public ResponseEntity execute(Long id) {

        Optional<Expense> optionalExpense = repository.findExpenseById(id);
        if(optionalExpense.isEmpty()) {
            throw new RuntimeException(id + " NOT FOUND!");
        }
        repository.deleteExpense(id);
        return ResponseEntity.ok(ResponseMessage.builder()
                .message("Expense deleted with id " + id).build());
    }
}
