package com.study.challenge.financialcontrol.infra.usecase;

import com.study.challenge.financialcontrol.domain.port.ExpenseRepository;
import com.study.challenge.financialcontrol.infra.util.CreateExpenseValidation;
import com.study.challenge.financialcontrol.infra.util.ExpenseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreateExpenseUseCaseTest {

    @Mock
    private ExpenseRepository repository;

    @Mock
    private ExpenseMapper mapper;

    @Mock
    private CreateExpenseValidation validation;

    @InjectMocks
    private CreateExpenseUseCase useCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
        assert(true);
    }

}