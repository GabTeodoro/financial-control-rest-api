package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.infra.util.CreateExpenseValidation;
import com.study.challenge.financialcontrol.infra.util.ExpenseMapper;
import com.study.challenge.financialcontrol.usecase.expense.UpdateExpense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateExpenseUseCase implements UpdateExpense {

    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;
    private final CreateExpenseValidation validation;

    @Override
    public ResponseEntity execute(Long id, ExpenseDTO expenseDTO) {

        Optional<Expense> optionalExpense = repository.findExpenseById(id);
        if(optionalExpense.isEmpty()) {
            throw new RuntimeException(id + " NOT FOUND!");
        }

        Boolean exists = validation.expenseAlreadyExists(expenseDTO.getDescription(),  expenseDTO.getDate());
        if(exists){
            throw new RuntimeException("Expense already created!");
        }

        Expense expense = mapper.toModel(expenseDTO);
        Expense updatedExpense = repository.updateExpense(expense);
        return ResponseEntity.ok(ResponseMessage.builder()
                .message("Expense updated with id " + updatedExpense.getId()).build());
    }
}
