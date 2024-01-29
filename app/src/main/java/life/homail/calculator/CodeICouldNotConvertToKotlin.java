package life.homail.calculator;

public class CodeICouldNotConvertToKotlin {
    private CalculatorMain calculatorMain;
    public CodeICouldNotConvertToKotlin(CalculatorMain calculatorMain) {
        this.calculatorMain = calculatorMain;
    }

    protected StringBuilder deleteSolvedExpression(StringBuilder expression){
        for (int i=0;i<expression.length();i++){
            if (expression.charAt(i)=='a'){
                expression.deleteCharAt(i);
                i=i-1;
            }
        }
        return expression;
    }
}
