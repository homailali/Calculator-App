package life.homail.calculator;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class SolveExpression {
    private CalculatorMain calculatorMain;
    private StringBuilder answer;
    public SolveExpression(CalculatorMain calculatorMain) {
        this.calculatorMain = calculatorMain;
    }

    protected StringBuilder solveExpressionMain(StringBuilder expression){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            this.answer= new StringBuilder(context.evaluateString(scriptable, String.valueOf(expression), "Javascript", 1, null).toString());
            this.makeTheSolvedAnswerBeautiful();
        } catch (Exception exception){
            return null;
        }
        return answer;
    }
    private void makeTheSolvedAnswerBeautiful(){
        this.removeZeroAtTheEnd();
        this.removeSomeDigitsAfterDecimalPoint();
    }


    private void removeSomeDigitsAfterDecimalPoint(){
        if (this.answer.toString().contains("E")) return;
        int count=0;
        boolean bool=false;
        for (int i=0;i<this.answer.length();i++){
            if (this.answer.charAt(i)=='.') bool=true;
            else if (bool) count++;
        }
        if (count>8) this.removingDecimalPoints();
    }
    private void removingDecimalPoints(){
        boolean bool=true;
        while (bool){
            this.answer.deleteCharAt(this.answer.length()-1);
            bool=this.ifDigitsAfterDecimalPointDeleted();
        }
    }
    private boolean ifDigitsAfterDecimalPointDeleted(){
        int count=0;
        boolean bool=false;
        for (char ch : this.answer.toString().toCharArray()){
            if (ch=='.') bool=true;
            else if (bool) count++;
        }
        return count>8;
    }
    private void removeZeroAtTheEnd(){
        if (this.answer.charAt(this.answer.length()-1)=='0' && this.answer.charAt(this.answer.length()-2)=='.'){
            this.answer.deleteCharAt(this.answer.length()-1);
            this.answer.deleteCharAt(this.answer.length()-1);
        }
    }
}