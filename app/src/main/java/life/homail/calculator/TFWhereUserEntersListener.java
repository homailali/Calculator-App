package life.homail.calculator;
import android.text.Editable;
import android.text.TextWatcher;
public class TFWhereUserEntersListener implements TextWatcher{
    private CalculatorMain calculatorMain;
    private StringBuilder equation;
    private StringBuilder solvedExpression;
    private StringBuilder answer;
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
        if (editable.toString().isEmpty() || this.containsSymbol(editable)) {
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setText(null);
            return;
        }
        this.ifEditableIsNotEmpty(editable);
    }


    private boolean containsSymbol(Editable editable){
        String tempStr=String.valueOf(editable);
        return !(tempStr.contains("/") || tempStr.contains("+") || tempStr.contains("-") || tempStr.contains("x"));
    }

    private void ifEditableIsNotEmpty(Editable editable){
        this.initializeSomeThings(editable);
        this.replaceMultiplySymbol();
        this.answer=this.calculatorMain.solveExpression.solveExpressionMain(this.equation);
        if (answer!=null){
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setText(this.answer);
        }
    }
    private void initializeSomeThings(Editable editable){
        this.equation=new StringBuilder(editable);
        this.answer=new StringBuilder();
    }
    private void replaceMultiplySymbol(){
        for (int i=0;i<this.equation.length();i++){
            if (this.equation.charAt(i)=='x'){
                this.equation.setCharAt(i,'*');
            }
        }
    }
}