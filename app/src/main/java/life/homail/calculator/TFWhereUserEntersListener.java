package life.homail.calculator;
import android.text.Editable;
import android.text.TextWatcher;
public class TFWhereUserEntersListener implements TextWatcher{
    private CalculatorMain calculatorMain;
    private StringBuilder equation;
    private StringBuilder solvedExpression;
    protected TFWhereUserEntersListener(CalculatorMain calculatorMain){
        this.calculatorMain=calculatorMain;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
    @Override
    public void afterTextChanged(Editable editable){
        this.initializeSomeThings(editable);
        if (!editable.toString().isEmpty() && this.calculatorMain.ifValidExpression.ifValidMain()){
            if (editable.toString().contains("(") || editable.toString().contains(")")) this.solvedExpression=this.calculatorMain.bracketSolver.bracketSolverMain(this.equation);
            else this.solvedExpression=new StringBuilder(this.calculatorMain.solveExpression.solveExpressionMain(String.valueOf(this.equation)));
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setText(this.solvedExpression);
        } else if (editable.toString().isEmpty()){
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setText(null);
        }
    }
    private void initializeSomeThings(Editable editable){
        this.equation=new StringBuilder(editable);
    }
}