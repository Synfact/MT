package com.example.MT.service;

import com.example.MT.model.Income;
import com.example.MT.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public Income getIncomeById(Long id){

        return incomeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Income with ID " + id + " not found"));
    }

    public Income saveIncome(Income income){
        return incomeRepository.save(income);
    }
}
