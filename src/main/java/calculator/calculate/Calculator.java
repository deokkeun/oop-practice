package calculator.calculate;

import calculator.calculate.*;

import java.util.List;

public class Calculator {

    // interface를 구현한 구현체를 받아온다
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        //return ArithmeticOperator.calculate(operand1, operator, operand2);


        return arithmeticOperators.stream()
                // 들어온 operator에 맞는 구현체를 찾는다
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                // 그 구현체에게 calculate작업을 위임 한다
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                // 첫 번째 값을 갖는다
                .findFirst()
                // 연산자(operator)에 해당하는 구현체가 없다면, 예외 발생 한다
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
