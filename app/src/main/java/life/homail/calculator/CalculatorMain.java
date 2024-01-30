package life.homail.calculator;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class CalculatorMain extends AppCompatActivity{
    protected CalculatorViews calculatorViews;
    protected BracketSolver bracketSolver=new BracketSolver(this);
    protected EqualBtnHandler equalBtnHandler=new EqualBtnHandler(this);
    protected SolveExpression solveExpression=new SolveExpression(this);
    protected IfValidExpression ifValidExpression=new IfValidExpression(this);
    protected NumberBtnEventHandler numberBtnEventHandler=new NumberBtnEventHandler(this);
    protected OperatorBtnEventHandler operatorBtnEventHandler=new OperatorBtnEventHandler(this);
    protected TFWhereUserEntersListener TFWhereUserEntersListener=new TFWhereUserEntersListener(this);
    protected CodeICouldNotConvertToKotlin codeICouldNotConvertToKotlin=new CodeICouldNotConvertToKotlin(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.activity_main);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
    }
    private void doSomeThingsAfterLayoutHasBeenSetUp(){
        this.calculatorViews=new CalculatorViews(this);
    }
}