package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.domain.port.IncomeRepository;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.infra.util.IncomeMapper;
import com.study.challenge.financialcontrol.usecase.income.DeleteIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteIncomeUseCase implements DeleteIncome {

    private final IncomeRepository repository;
    private final IncomeMapper mapper;

    @Override
    public ResponseEntity execute(Long id) {

        Optional<Income> optionalIncome = repository.findIncomeById(id);

        if(optionalIncome.isEmpty()) {
            throw new RuntimeException(id + " NOT FOUND!");
        }

        repository.deleteIncome(id);
        return ResponseEntity.ok(ResponseMessage.builder()
                .message("Income deleted with id " + id).build());
    }
}
