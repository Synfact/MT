package com.example.MT.service;

import com.example.MT.model.Income;
import com.example.MT.repository.IncomeRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncomeServiceTest {

    @Mock
    private IncomeRepository incomeRepository;

    @InjectMocks
    private IncomeService incomeService;

    //tipo default sdelati? chto bi ne sozdavati otdelino v teste
    private Income generateTestData(){
        Income income = new Income();
        income.setId(1L);
        income.setName("Salary");
        income.setSource("Job");
        return income;
    }


    @Test
    void getIncomeById() {
        Long id = 1L;
        Income income = new Income();
        income.setId(id);
        income.setName("Salary");
        income.setSource("Job");

        when(incomeRepository.findById(id)).thenReturn(Optional.of(income));

        Income result = incomeService.getIncomeById(id);

        assertNotNull(result);
        assertEquals("Salary", result.getName());
        assertEquals("Job", result.getSource());
    }

    @Test
    void getIncomeByIdNotFound() {
        Long id = 1L;
        when(incomeRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class ,()->incomeService.getIncomeById(id));
    }

    @Test
    void saveIncome() {
        Income income = new Income();
        income.setName("Freelance");
        income.setSource("Projects");
        income.setAmount(25L);

        when(incomeRepository.save(income)).thenReturn(income);

        Income result = incomeService.saveIncome(income);

        assertNotNull(result);
        assertEquals("Freelance", result.getName());
        assertEquals("Projects", result.getSource());
    }
}