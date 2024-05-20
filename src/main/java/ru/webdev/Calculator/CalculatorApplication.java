package ru.webdev.Calculator;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorApplication {

    private final Calculator calculator;

    public CalculatorApplication(@Qualifier("calculator") Calculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Bean
    public boolean outToConsole() throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число a: ");
        double a = in.nextDouble();
        System.out.print("Введите число b: ");
        double b = in.nextDouble();
        System.out.println("Введите тип операции: " + calculator.getSupportedOperations());
        String operationType = in.next();

        calculator.calc(operationType, a, b);
        return true;
    }

}
