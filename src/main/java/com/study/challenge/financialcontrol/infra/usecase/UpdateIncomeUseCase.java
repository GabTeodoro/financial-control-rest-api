package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.domain.port.IncomeRepository;
import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.infra.util.CreateIncomeValidation;
import com.study.challenge.financialcontrol.infra.util.IncomeMapper;
import com.study.challenge.financialcontrol.usecase.income.UpdateIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateIncomeUseCase implements UpdateIncome {

    private final IncomeRepository repository;
    private final IncomeMapper mapper;
    private CreateIncomeValidation validation;

    @Override
    public ResponseEntity execute(Long id, IncomeDTO incomeDTO) {

        Optional<Income> optionalIncome = repository.findIncomeById(id);

        if(optionalIncome.isEmpty()) {
            throw new RuntimeException(id + " NOT FOUND!");
        }

        Boolean exists = validation.incomeAlreadyExists(incomeDTO.getDescription(),  incomeDTO.getDate());
        if(exists){
            throw new RuntimeException("Income already created!");
        }

        Income income = mapper.toModel(incomeDTO);
        Income updatedIncome = repository.updateIncome(income);
        return ResponseEntity.ok(ResponseMessage.builder()
                .message("Income updated with id " + updatedIncome.getId()).build());
    }
}
