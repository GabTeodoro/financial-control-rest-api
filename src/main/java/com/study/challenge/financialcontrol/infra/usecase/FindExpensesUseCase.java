package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import com.study.challenge.financialcontrol.infra.util.ExpenseMapper;
import com.study.challenge.financialcontrol.usecase.expense.FindExpenses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindExpensesUseCase implements FindExpenses {

    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;

    @Override
    public ResponseEntity execute() {
        List<Expense> expenses = repository.listAllExpenses();
        List<ExpenseDTO> expenseDTOS = expenses.stream()
                .map(mapper::toDTO).collect(Collectors.toList());

        return ResponseEntity.ok(expenseDTOS);
    }

    @Override
    public ResponseEntity execute(Long id) {
        Optional<Expense> optionalExpense = repository.findExpenseById(id);
        if(optionalExpense.isEmpty()) {
            throw new RuntimeException(id + " NOT FOUND!");
        }

        Expense expense = optionalExpense.get();
        ExpenseDTO expenseDTO = mapper.toDTO(expense);
        return ResponseEntity.ok(expenseDTO);
    }
}
