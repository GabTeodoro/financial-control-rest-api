package com.study.challenge.financialcontrol.infra.util;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.infra.dto.ExpenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(target = "value", source = "value")
    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    Expense toModel(ExpenseDTO expenseDTO);

    ExpenseDTO toDTO(Expense Expense);
}
