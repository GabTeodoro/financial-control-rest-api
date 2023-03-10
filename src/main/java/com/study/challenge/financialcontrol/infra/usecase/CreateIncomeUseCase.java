package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.domain.port.IncomeRepository;
import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.infra.util.CreateIncomeValidation;
import com.study.challenge.financialcontrol.infra.util.IncomeMapper;
import com.study.challenge.financialcontrol.usecase.income.CreateIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateIncomeUseCase implements CreateIncome {

    private final IncomeRepository repository;
    private final IncomeMapper mapper;
    private CreateIncomeValidation validation;

    @Override
    public ResponseEntity execute(IncomeDTO incomeDTO) {

        Boolean exists = validation.incomeAlreadyExists(incomeDTO.getDescription(),  incomeDTO.getDate());
        if(exists){
            throw new RuntimeException("Income already created!");
        }

        Income income = mapper.toModel(incomeDTO);
        Income incomeSaved = repository.createIncome(income);

        return ResponseEntity.ok(ResponseMessage.builder()
                .message("Income created with id " + incomeSaved.getId()).build());
    }
}
