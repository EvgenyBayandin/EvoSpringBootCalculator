package ru.webdev.Calculator;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private final Map<String, Operation> operations;

    public Calculator(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public void calc(String operationType, double a, double b) throws Exception {
        double result = Optional.ofNullable(operations.get(operationType))
                .orElseThrow(() -> new Exception("Unsupported operation"))
                .getResult(a, b);
        System.out.println(result);
    }

    public String getSupportedOperations() {
        return operations.keySet().toString();
    }

}
