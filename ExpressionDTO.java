public class ExpressionDTO {
    int firstOperand;
    int secondOperand;
    String operator;
    TypeOfExpression type;

    public ExpressionDTO (int firstOperand, int secondOperand, String operator, TypeOfExpression type){
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
        this.type = type;
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExpressionDTO)) {
            return false;
        }
        ExpressionDTO expr = (ExpressionDTO) obj;

        return firstOperand == expr.firstOperand &&
                secondOperand == expr.secondOperand &&
                operator.equals(expr.operator) &&
                type.equals(expr.type);
    }
}
