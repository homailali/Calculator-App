package life.homail.calculator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

public class DarkAndLightModeHandler implements View.OnClickListener{
    private CalculatorMain calculatorMain;
    private boolean darkAndLightModeTracker=true;
    protected DarkAndLightModeHandler(CalculatorMain calculatorMain){
        this.calculatorMain=calculatorMain;
    }
    @Override
    public void onClick(View view){
        boolean bool=checkWhichModeToChangeOn();
        if (bool) this.changeToLightMode();
        else this.changeToDarkMode();
    }

    private boolean checkWhichModeToChangeOn(){
         if (this.darkAndLightModeTracker){
             this.darkAndLightModeTracker=false;
             return true;
         } else {
             this.darkAndLightModeTracker=true;
             return false;
         }
    }
    private void changeToLightMode(){
        this.calculatorMain.calculatorViews.darkAndLightModeBtn.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.dark_mode_black,0,0);


        // Background
        // Layout color settings
        this.changeLayoutInnerColor("#FFFFFF");
        this.changeOuterLayoutBgColor("#E6E6E6");
        // Btn Color settings
        this.setOperatorBtnColor("#F28705");
        this.setNumberBtnColor("#CECECE");
        this.setOtherBtnColor("#CECECE");
        this.modeChangerBtnColor("#FFFFFF");
        // Text
        // BtnTextColorSettings
        this.setBtnTextColorOtherThenOperator("#2E2E2E");
        this.setOperatorBtnTextColor("#FFFFFF");
        // TextFieldSettings
        this.setTextFieldTextColor("#2E2E2E","#696969");
        this.setCasioHeadingColor("#2E2E2E");
        // TextField Stroke settings
        this.changeTextFieldStroke("light");
    }

    private void changeToDarkMode(){


        this.calculatorMain.calculatorViews.darkAndLightModeBtn.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.light_mode_white,0,0);

        // Layout color settings
        this.changeLayoutInnerColor("#2A2E37");
        this.changeOuterLayoutBgColor("#2A2E37");
        // Btn Color settings
        this.setOperatorBtnColor("#C25BDE");
        this.setNumberBtnColor("#2F3646");
        this.setOtherBtnColor("#2F3646");
        this.modeChangerBtnColor("#2A2E37");
        this.modeChangerBtnColor("#2A2E37");
        // BtnTextColorSettings
        this.setBtnTextColorOtherThenOperator("#FFFFFF");
        this.setOperatorBtnTextColor("#FFFFFF");
        // TextFieldSettings
        this.setTextFieldTextColor("#FFFFFF","#A3A3A3");
        this.setCasioHeadingColor("#FFFFFF");
        // Text Field Stroke Settings
        this.changeTextFieldStroke("dark");
    }




















    // TextField Stroke Settings
    private void changeTextFieldStroke(String str){
        if (str.equals("dark")){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.setBackgroundResource(R.drawable.custom_bgedittext_dark);
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setBackgroundResource(R.drawable.custom_bgedittext_dark);
        } else if (str.equals("light")){
            this.calculatorMain.calculatorViews.textFieldWhereUserEnters.setBackgroundResource(R.drawable.custom_bgedittext_light);
            this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setBackgroundResource(R.drawable.custom_bgedittext_light);
        }
    }
    // Layout settings
    private void changeLayoutInnerColor(String color){
        this.calculatorMain.calculatorViews.constraintLayoutInner.setBackgroundColor(Color.parseColor(color));
    }
    private void changeOuterLayoutBgColor(String color){
        this.calculatorMain.calculatorViews.constraintLayoutOuter.setBackgroundColor(Color.parseColor(color));
    }
    // Text settings
    private void setTextFieldTextColor(String userColor,String answerColor){
        this.calculatorMain.calculatorViews.textFieldWhereUserEnters.setTextColor(Color.parseColor(userColor));
        this.calculatorMain.calculatorViews.textFieldWhereAnswerDisplays.setTextColor(Color.parseColor(answerColor));
    }
    private void setBtnTextColorOtherThenOperator(String color){
        this.calculatorMain.calculatorViews.button0.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button1.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button2.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button3.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button4.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button5.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button6.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button7.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button8.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button9.setTextColor(Color.parseColor(color));


        this.calculatorMain.calculatorViews.decimalPointBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.divideBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.leftBracketBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.rightBracketBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.allClearBtn.setTextColor(Color.parseColor(color));
    }
    private void setOperatorBtnTextColor(String color){
        this.calculatorMain.calculatorViews.minusBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.plusBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.multiplyBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.equalBtn.setTextColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.deleteOneBtn.setTextColor(Color.parseColor(color));
    }
    private void setCasioHeadingColor(String color){
        this.calculatorMain.calculatorViews.casioHeading.setTextColor(Color.parseColor(color));
    }
    // Btn settings
    private void setOtherBtnColor(String color){
        this.calculatorMain.calculatorViews.decimalPointBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.divideBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.leftBracketBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.rightBracketBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.allClearBtn.setBackgroundColor(Color.parseColor(color));
    }
    private void setNumberBtnColor(String color){
        this.calculatorMain.calculatorViews.button0.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button1.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button2.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button3.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button4.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button5.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button6.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button7.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button8.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.button9.setBackgroundColor(Color.parseColor(color));
    }
    private void setOperatorBtnColor(String color){
        this.calculatorMain.calculatorViews.minusBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.plusBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.multiplyBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.equalBtn.setBackgroundColor(Color.parseColor(color));
        this.calculatorMain.calculatorViews.deleteOneBtn.setBackgroundColor(Color.parseColor(color));
    }
    // Mode changer Btn Settings
    private void modeChangerBtnColor(String color){
        this.calculatorMain.calculatorViews.darkAndLightModeBtn.setBackgroundColor(Color.parseColor(color));
    }
}