package com.study.challenge.financialcontrol.infra.repository;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.domain.port.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class IncomeRepositoryImp implements IncomeRepository {

    private IncomeJPA jpa;

    @Override
    public Income createIncome(Income income) {
        return jpa.save(income);
    }

    @Override
    public Page<Income> listAllIncomes(Pageable page) {
        return jpa.findAll(page);
    }

    @Override
    public Optional<Income> findIncomeById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Income updateIncome(Income income) {
        return jpa.save(income);
    }

    @Override
    public void deleteIncome(Long id) {
        jpa.deleteById(id);
    }
}
