package com.study.challenge.financialcontrol.infra.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 80)
    private String description;

    @NotEmpty
    private String value;

    @NotEmpty
    private String date;
}
