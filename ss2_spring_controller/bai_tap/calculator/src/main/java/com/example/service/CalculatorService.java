package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculator(double num1, double num2, String calculation) {
        switch (calculation) {
            case "Addition(+)":
                return num1 + num2;
            case "Subtraction(-)":
                return num1 - num2;
            case "Multiplication(*)":
                return num1 * num2;
            case "Division(/)":
                return num1 / num2;
        }
        return 0;
    }
}
