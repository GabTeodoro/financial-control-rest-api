package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.domain.port.IncomeRepository;
import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import com.study.challenge.financialcontrol.infra.util.IncomeMapper;
import com.study.challenge.financialcontrol.usecase.income.FindIncomes;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FindIncomesUseCase implements FindIncomes {

    private final IncomeRepository repository;
    private final IncomeMapper mapper;

    @Override
    public ResponseEntity execute() {
        List<Income> incomes = repository.listAllIncomes();
        List<IncomeDTO> incomeDTOS = incomes.stream().map(mapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(incomeDTOS);
    }

    @Override
    public ResponseEntity execute(Long id) {

        Optional<Income> optionalIncome = repository.findIncomeById(id);
        Income income = optionalIncome.get();

        if(income == null) {
            throw new RuntimeException(id + "NOT FOUND!");
        }

        IncomeDTO incomeDTO = mapper.toDTO(income);
        return ResponseEntity.ok(incomeDTO);
    }
}
