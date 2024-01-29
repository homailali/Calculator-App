package life.homail.calculator
import android.view.View
import android.widget.Button
class OperatorBtnEventHandler(private var calculatorMain: CalculatorMain) : View.OnClickListener{
    private var clickedButton:Button?=null;
    override fun onClick(view: View){
        this.clickedButton=findTheButton(view)
        this.setTextOnScreen(this.clickedButton)
    }
    private fun setTextOnScreen(button: Button?){
        this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(button?.text)
    }
    private fun findTheButton(view: View):Button?{
        when (view.id){
         R.id.divideBtn -> return this.calculatorMain.calculatorViews.divideBtn;
         R.id.plusBtn -> return this.calculatorMain.calculatorViews.plusBtn;
         R.id.minusBtn -> return this.calculatorMain.calculatorViews.minusBtn;
         R.id.multiplyBtn -> return this.calculatorMain.calculatorViews.multiplyBtn;
        }
        return null
    }
}