package com.study.challenge.financialcontrol.infra.util;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IncomeMapper {

    @Mapping(target = "value", source = "value")
    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    Income toModel(IncomeDTO incomeDTO);

    IncomeDTO toDTO(Income income);
}
