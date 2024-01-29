package life.homail.calculator
import android.view.View
import android.widget.Button
class NumberBtnEventHandler(private val calculatorMain: CalculatorMain) :  View.OnClickListener{
    private var clickedButton: Button?=null
    override fun onClick(view:View){
        this.clickedButton=this.findTheButtonClicked(view)
        this.setTextOnScreen(this.clickedButton)
    }
    private fun setTextOnScreen(clickedButton: Button?){
        this.calculatorMain.calculatorViews.textFieldWhereUserEnters.append(clickedButton?.text.toString())
    }
    private fun findTheButtonClicked(view:View):Button?{
        when (view.id) {
            R.id.button0 -> return this.calculatorMain.calculatorViews.button0;
            R.id.button1 -> return this.calculatorMain.calculatorViews.button1;
            R.id.button2 -> return this.calculatorMain.calculatorViews.button2;
            R.id.button3 -> return this.calculatorMain.calculatorViews.button3;
            R.id.button4 -> return this.calculatorMain.calculatorViews.button4;
            R.id.button5 -> return this.calculatorMain.calculatorViews.button5;
            R.id.button6 -> return this.calculatorMain.calculatorViews.button6;
            R.id.button7 -> return this.calculatorMain.calculatorViews.button7;
            R.id.button8 -> return this.calculatorMain.calculatorViews.button8;
            R.id.button9 -> return this.calculatorMain.calculatorViews.button9;
        }
        return null;
    }
}