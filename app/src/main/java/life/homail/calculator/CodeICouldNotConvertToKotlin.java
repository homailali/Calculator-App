package life.homail.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
    protected StringBuilder removeSomeDecimalPoints(StringBuilder equationToDelete){
        if (equationToDelete.toString().contains("e") || equationToDelete.toString().contains("E")) return equationToDelete;
        boolean bool=true;
        while (bool){
            equationToDelete.deleteCharAt(equationToDelete.length()-1);
            bool=this.checkIfDecimalPointsDeleted(equationToDelete);
        }
        return equationToDelete;
    }
    private boolean checkIfDecimalPointsDeleted(StringBuilder equation){
        boolean bool=false;
        int count=0;
        for (int i=0;i<equation.length();i++){
            if (equation.charAt(i)=='.') bool=true;
            else if (bool) count++;
        }
        return count>8;
    }
    protected StringBuilder removeMultiplyMinus(StringBuilder equation){
        StringBuilder tempStr=new StringBuilder(equation);
        if (equation.toString().contains("x-")){
            try {
                for (int i = 0; i < tempStr.length(); i++) {
                    if (tempStr.charAt(i)=='x' && tempStr.charAt(i+1)=='-'){
                        tempStr.deleteCharAt(i+1);
                    }
                }
            } catch (IndexOutOfBoundsException indexOutOfBoundsException){}
        }
        return tempStr;
    }
}