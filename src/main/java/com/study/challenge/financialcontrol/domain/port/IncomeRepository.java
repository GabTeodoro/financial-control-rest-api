package com.study.challenge.financialcontrol.domain.port;

import com.study.challenge.financialcontrol.domain.entity.Income;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IncomeRepository {

    Income createIncome(Income income);
    List<Income> listAllIncomes();
    Optional<Income> findIncomeById(Long id);
    Income updateIncome(Income income);
    void deleteIncome(Long id);


}
