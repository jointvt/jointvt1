import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    /** Допустимые операторы */
    private static final List<String> operators = Arrays.asList("+", "-", "*", "/");
    /** Допустимые арабскиечисла */
    private static final List<String> allowedArabic = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    /** Допустимые римские числа */
    private static final List<String> allowedRoman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    public static ExpressionDTO parse(String input) throws CustomException {
        String[] splicedInput = input.split(" ");
        ExpressionDTO expression;

        if (splicedInput.length != 3) {
            /* В выражении должно быть два операнда и оператор */
            throw new CustomException("Invalid expression");
        } else if (!operators.contains(splicedInput[1])) {
            /* Можем выполнять только четыре определённых действия */
            throw new CustomException("Invalid operator");
        } else if ((!allowedArabic.contains(splicedInput[0]) && !allowedRoman.contains(splicedInput[0])) ||
                (!allowedArabic.contains(splicedInput[2]) && !allowedRoman.contains(splicedInput[2]))) {
            /* Если первый или второй операнд не соответствуют диапазону допустимых значений */
            throw new CustomException("Invalid operand");
        } else if ((allowedArabic.contains(splicedInput[0]) && allowedRoman.contains(splicedInput[2])) ||
                (allowedArabic.contains(splicedInput[2]) && allowedRoman.contains(splicedInput[0]))) {
            /* Если операнды разного типа */
            throw new CustomException("Operands of different types");
        } else if (allowedArabic.contains(splicedInput[0])) {
            /* Если выражение из арабских цифр */
            expression = new ExpressionDTO(allowedArabic.indexOf(splicedInput[0]) + 1,
                    allowedArabic.indexOf(splicedInput[2]) + 1, splicedInput[1], TypeOfExpression.ARABIC);
        } else {
            /* Значит из римских */
            expression = new ExpressionDTO(allowedRoman.indexOf(splicedInput[0]) + 1,
                    allowedRoman.indexOf(splicedInput[2]) + 1, splicedInput[1], TypeOfExpression.ROMAN);
        }
        return expression;
    }
}