package com.example.MT.service;

import com.example.MT.model.Income;
import com.example.MT.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public Income getIncomeById(Long id){
        return incomeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Income with ID " + id + " not found"));
    }

    public Page<Income> getAllIncome(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return incomeRepository.findAll(pageable);
    }

    public Income saveIncome(Income income){
        return incomeRepository.save(income);
    }
}
