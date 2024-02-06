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
        if (editable.toString().isEmpty()){
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setText(null);
            return;
        } else if (this.containsSymbol(editable)) return;
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
        if (this.ifAllowedToSetAnswer()){
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setText(this.answer);
        }
    }
    private boolean ifAllowedToSetAnswer(){
        if (this.answer==null) return false;
        else if (this.answer.toString().contains("mozilla")) return false;
        else if (this.answer.toString().equalsIgnoreCase("nan")) return false;
        else if (this.answer.toString().contains("/")) return false;
        return true;
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