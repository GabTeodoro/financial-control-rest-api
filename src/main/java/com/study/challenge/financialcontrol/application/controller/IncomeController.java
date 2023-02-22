package com.study.challenge.financialcontrol.application.controller;

import com.study.challenge.financialcontrol.infra.dto.IncomeDTO;
import com.study.challenge.financialcontrol.infra.dto.ResponseMessage;
import com.study.challenge.financialcontrol.usecase.income.CreateIncome;
import com.study.challenge.financialcontrol.usecase.income.DeleteIncome;
import com.study.challenge.financialcontrol.usecase.income.FindIncomes;
import com.study.challenge.financialcontrol.usecase.income.UpdateIncome;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/income")
@AllArgsConstructor
public class IncomeController {

    private CreateIncome create;
    private FindIncomes find;
    private UpdateIncome update;
    private DeleteIncome delete;

    @PostMapping
    public ResponseEntity<ResponseMessage> create(@RequestBody IncomeDTO incomeDTO){
        return create.execute(incomeDTO);
    }

    @GetMapping
    public ResponseEntity<List<IncomeDTO>> listAll() {
        return find.execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDTO> findById(@PathVariable Long id) {
        return find.execute(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> update(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        return update.execute(id, incomeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id) {
        return delete.execute(id);
    }

}
