package com.example.MT.service;

import com.example.MT.model.Income;
import com.example.MT.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public Income getIncomeById(Long id){
        return incomeRepository.getReferenceById(id);
    }

    public Income saveIncome(Income income){
        return incomeRepository.save(income);
    }
}
