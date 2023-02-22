package com.study.challenge.financialcontrol.infra.util;

import com.study.challenge.financialcontrol.domain.entity.Expense;
import com.study.challenge.financialcontrol.infra.repository.ExpenseJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreateExpenseValidation {

    private ExpenseJPA expenseJPA;

    public Boolean expenseAlreadyExists(String description, String givenDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(givenDate, formatter);
        LocalDate firstDay = date.withDayOfMonth(1);
        LocalDate lastDay  = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));

        Expense expense = expenseJPA.findExpenseDescriptionMonth(description, firstDay, lastDay);

        if(expense != null){
            return true;
        }
        return false;
    }
}
