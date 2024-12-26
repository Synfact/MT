package com.example.MT.controller;

import com.example.MT.model.Income;
import com.example.MT.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;

    @GetMapping("/income/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id){
        var income = incomeService.getIncomeById(id);
        return new ResponseEntity<>(income, HttpStatus.OK);
    }

    @PostMapping("/income")
    public ResponseEntity<Income> saveIncome(@RequestBody Income income){
        return new ResponseEntity<>(incomeService.saveIncome(income),HttpStatus.OK);
    }
}
