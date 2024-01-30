package life.homail.calculator;
public class EqualBtnHandler {
    private CalculatorMain calculatorMain;
    public EqualBtnHandler(CalculatorMain calculatorMain) {

        this.calculatorMain = calculatorMain;
    }
    protected void equalBtnHandlerMain(){
        this.calculatorMain.calculatorViews.textFieldWhereUserEnters.setText(this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.getText());
    }
}