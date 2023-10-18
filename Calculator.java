public class Calculator {
    private char operator;
    private int operand1;
    private int operand2;
    private String expression;

    public Calculator() {
    }

    public char getOperator() {
        return operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean verify() {
        int index1ofOp1 = 0;
        int index2ofOp1;
        int index1ofOp2;
        int index2ofOp2 = expression.length();
        String expression = getExpression();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                if (expression.charAt(i - 1) == ' ' && expression.charAt(i + 1) == ' ') {
                    operator = expression.charAt(i);
                    index2ofOp1 = i - 1;
                    index1ofOp2 = i + 2;
                    try{
                        operand1 = Integer.parseInt(expression.substring(index1ofOp1, index2ofOp1));
                        operand2 = Integer.parseInt(expression.substring(index1ofOp2, index2ofOp2));
                    }
                    catch (Exception NumberFormatException){
                        return false;
                    }

                    if (getOperand2() == 0 && operator == '/') {
                        return false;
                    }
                    else {
                        return true;
                    }

                }
            }

        }
        return false;
    }


    public int evaluate() {
        int result = 0;
        if (operator == '+') {
            result = (getOperand1() + getOperand2());
        } else if (getOperator() == '-') {
            result = (getOperand1() - getOperand2());
        } else if (getOperator() == '*') {
            result = (getOperand1() * getOperand2());
        } else if (getOperator() == '/') {
            result = (getOperand1() / getOperand2());
        }
        return result;
    }
}
