package ru.webdev.Calculator;

import org.springframework.stereotype.Component;

@Component
public class Divider implements Operation{
    @Override
	public double getResult(double a, double b) {
        return a / b;
    }
}
