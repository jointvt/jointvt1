public class Calculator {
/**
 * @param expression Data-Transfer Object для передачи операндов, оператора и типа выражения
 *@return Результат в виде строки
 * @throws CustomException
 */
    public static String calc(ExpressionDTO expression) throws CustomException {
        int res = switch (expression.operator) {
            case "+" -> expression.firstOperand + expression.secondOperand;
            case "-" -> expression.firstOperand - expression.secondOperand;
            case "*" -> expression.firstOperand * expression.secondOperand;
            case "/" -> (int) (expression.firstOperand / expression.secondOperand);
                default -> 0;
        };
        /* Если выражение передано арабскими цифрами, то возвращаем результат */
        if (expression.type == TypeOfExpression.ARABIC) {
            return Integer.toString(res);
        } else if (res <= 0) {
            /*Если же римскими, то результат может быть только положиельный */
            throw new CustomException("Result less or equal 0. The Roman did not use 0 and negative numbers.");
        } else {
            /*Конверитруем результат в римские цифры и возвращаем */
            return Converter.arabicToRoman(res);
        }
    }
}
