package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.infra.util.CreateExpenseValidation;
import com.study.challenge.financialcontrol.infra.util.ExpenseMapper;
import com.study.challenge.financialcontrol.usecase.expense.CreateExpense;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateExpenseUseCase implements CreateExpense {

    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;
    private final CreateExpenseValidation validation;

    @Override
    public ResponseEntity execute(ExpenseDTO expenseDTO) {

        Boolean exists = validation.expenseAlreadyExists(expenseDTO.getDescription(),  expenseDTO.getDate());
        if(exists){
            throw new RuntimeException("Expense already created!");
        }

        Expense expense = mapper.toModel(expenseDTO);
        Expense savedExpense = repository.createExpense(expense);

        return ResponseEntity.ok(ResponseMessage.builder()
                .message("Expense created with id " + savedExpense.getId()).build());
    }
}
