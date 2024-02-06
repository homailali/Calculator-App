package life.homail.calculator;
import android.view.View;
public class NumberBtnEventHandler implements View.OnClickListener{
    private CalculatorMain calculatorMain;
    protected NumberBtnEventHandler(CalculatorMain calculatorMain){
        this.calculatorMain=calculatorMain;
    }

    @Override
    public void onClick(View view){
        this.findTheBtnAndPerformActionsAccordingly(view);
        this.calculatorMain.soundHandlerAndPlayer.playSound();
    }

    private void findTheBtnAndPerformActionsAccordingly(View view){
        if (view.getId()==R.id.button0){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button0.getText());
        } else if (view.getId()==R.id.button1){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button1.getText());
        } else if (view.getId()==R.id.button2){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button2.getText());
        } else if (view.getId()==R.id.button3){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button3.getText());
        } else if (view.getId()==R.id.button4){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button4.getText());
        } else if (view.getId()==R.id.button5){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button5.getText());
        } else if (view.getId()==R.id.button6){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button6.getText());
        } else if (view.getId()==R.id.button7){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button7.getText());
        } else if (view.getId()==R.id.button8){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button8.getText());
        } else if (view.getId()==R.id.button9){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(this.calculatorMain.calculatorViews.button9.getText());
        }
    }
}
