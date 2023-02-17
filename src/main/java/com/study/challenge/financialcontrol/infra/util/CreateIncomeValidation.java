package com.study.challenge.financialcontrol.infra.util;

import com.study.challenge.financialcontrol.domain.entity.Income;
import com.study.challenge.financialcontrol.infra.repository.IncomeJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateIncomeValidation {

    private IncomeJPA incomeJPA;

    public Boolean incomeAlreadyExists(String description, String givenDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(givenDate, formatter);
        LocalDate firstDay = date.withDayOfMonth(1);
        LocalDate lastDay  = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));

        Income income = incomeJPA.findIncomeDescriptionMonth(description, firstDay, lastDay);

        if(income != null){
            return true;
        }
        return false;
    }
}
