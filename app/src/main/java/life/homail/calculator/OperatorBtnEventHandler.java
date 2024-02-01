package life.homail.calculator;
import android.view.View;
public class OperatorBtnEventHandler implements View.OnClickListener{
    private CalculatorMain calculatorMain;

    public OperatorBtnEventHandler(CalculatorMain calculatorMain) {
        this.calculatorMain = calculatorMain;
    }

    @Override
    public void onClick(View view){
        this.findBtnAndPerformOperation(view);
    }
    private void findBtnAndPerformOperation(View view){
        if (view.getId()==R.id.minusBtn){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.minusBtn.getText());
        } else if (view.getId()==R.id.plusBtn){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.plusBtn.getText());
        } else if (view.getId()==R.id.divideBtn){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.divideBtn.getText());
        } else if (view.getId()==R.id.multiplyBtn){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.multiplyBtn.getText());
        }
    }
}