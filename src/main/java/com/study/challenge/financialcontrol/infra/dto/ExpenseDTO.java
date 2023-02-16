package com.study.challenge.financialcontrol.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 80)
    private String description;

    @NotEmpty
    private String value;

    @NotEmpty
    private String date;
}
