package life.homail.calculator;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Objects;
public class CalculatorViews{
    private CalculatorMain calculatorMain;
    // NumberBtn
    protected Button button0;
    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected Button button4;
    protected Button button5;
    protected Button button6;
    protected Button button7;
    protected Button button8;
    protected Button button9;
    // Operator Btn
    protected Button divideBtn;
    protected Button multiplyBtn;
    protected Button minusBtn;
    protected Button plusBtn;
    // Other
    protected Button decimalPointBtn;
    protected Button rightBracketBtn;
    protected Button leftBracketBtn;
    protected Button allClearBtn;
    protected Button deleteOneBtn;
    protected Button equalBtn;

    protected TextInputEditText textFieldWhereAnswerDisplays;
    protected TextInputEditText textFieldWhereUserEnters;
    // Constructor
    public CalculatorViews(CalculatorMain calculatorMain){
        this.calculatorMain = calculatorMain;
        this.thingsToDoWhenConstructorIsCreated();
    }
    private void thingsToDoWhenConstructorIsCreated(){
        this.initializeNumberBtn();
        this.initializeOperatorBtn();
        this.initializeOtherBtn();
        this.initializeTextFields();
        this.setNumberBtnEventHandler();
        this.setOperatorBtnEventHandler();
        this.setOtherBtnEventHandler();
        this.setTextFieldHandler();
    }
    // Methods
    private void initializeNumberBtn(){
        this.button0=this.calculatorMain.findViewById(R.id.button0);
        this.button1=this.calculatorMain.findViewById(R.id.button1);
        this.button2=this.calculatorMain.findViewById(R.id.button2);
        this.button3=this.calculatorMain.findViewById(R.id.button3);
        this.button4=this.calculatorMain.findViewById(R.id.button4);
        this.button5=this.calculatorMain.findViewById(R.id.button5);
        this.button6=this.calculatorMain.findViewById(R.id.button6);
        this.button7=this.calculatorMain.findViewById(R.id.button7);
        this.button8=this.calculatorMain.findViewById(R.id.button8);
        this.button9=this.calculatorMain.findViewById(R.id.button9);
    }
    private void initializeOperatorBtn(){
        this.divideBtn=this.calculatorMain.findViewById(R.id.divideBtn);
        this.multiplyBtn=this.calculatorMain.findViewById(R.id.multiplyBtn);
        this.minusBtn=this.calculatorMain.findViewById(R.id.minusBtn);
        this.plusBtn=this.calculatorMain.findViewById(R.id.plusBtn);
    }
    private void initializeOtherBtn(){
        this.leftBracketBtn=this.calculatorMain.findViewById(R.id.leftBracketBtn);
        this.rightBracketBtn=this.calculatorMain.findViewById(R.id.rightBracketBtn);
        this.allClearBtn=this.calculatorMain.findViewById(R.id.allClear);
        this.deleteOneBtn=this.calculatorMain.findViewById(R.id.deleteOneBtn);
        this.decimalPointBtn=this.calculatorMain.findViewById(R.id.decimalPointBtn);
        this.equalBtn=this.calculatorMain.findViewById(R.id.equalBtn);
    }
    private void initializeTextFields(){
        this.textFieldWhereUserEnters=this.calculatorMain.findViewById(R.id.textFieldWhereUserEnters);
        this.textFieldWhereAnswerDisplays=this.calculatorMain.findViewById(R.id.textFieldWhereAnswerDisplays);
    }
    // SetEventHandler
    private void setNumberBtnEventHandler() {
        this.button0.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button1.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button2.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button3.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button4.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button5.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button6.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button7.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button8.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
        this.button9.setOnClickListener(this.calculatorMain.numberBtnEventHandler);
    }
    private void setOperatorBtnEventHandler() {
        this.plusBtn.setOnClickListener(this.calculatorMain.operatorBtnEventHandler);
        this.minusBtn.setOnClickListener(this.calculatorMain.operatorBtnEventHandler);
        this.divideBtn.setOnClickListener(this.calculatorMain.operatorBtnEventHandler);
        this.multiplyBtn.setOnClickListener(this.calculatorMain.operatorBtnEventHandler);
    }
    private void setOtherBtnEventHandler(){
        this.decimalPointBtn.setOnClickListener(this::otherBtnEventHandler);
        this.rightBracketBtn.setOnClickListener(this::otherBtnEventHandler);
        this.leftBracketBtn.setOnClickListener(this::otherBtnEventHandler);
        this.allClearBtn.setOnClickListener(this::otherBtnEventHandler);
        this.deleteOneBtn.setOnClickListener(this::otherBtnEventHandler);
        this.equalBtn.setOnClickListener(this::otherBtnEventHandler);
    }
    private void setTextFieldHandler(){
        this.textFieldWhereUserEnters.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v){

                return true;
            }
        });
        this.textFieldWhereUserEnters.addTextChangedListener(this.calculatorMain.TFWhereUserEntersListener);
    }
    // Handling some click event here
    private void otherBtnEventHandler(View view){
        if (view.getId()==R.id.decimalPointBtn) this.addTextToTextField(".");
        else if (view.getId()==R.id.rightBracketBtn) this.addTextToTextField(")");
        else if (view.getId()==R.id.leftBracketBtn) this.addTextToTextField("(");
        else if (view.getId()==R.id.allClear) this.textFieldWhereUserEnters.setText(null);
        else if (view.getId()==R.id.deleteOneBtn){
            StringBuilder stringBuilder=new StringBuilder(Objects.requireNonNull(this.textFieldWhereUserEnters.getText(),"Text Field is null"));
            if (stringBuilder.toString().isEmpty()) return;
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            this.textFieldWhereUserEnters.setText(stringBuilder.toString());
        }
        else if (view.getId()==R.id.equalBtn){}
    }
    private void addTextToTextField(String text){

        this.textFieldWhereUserEnters.append(text);
    }

}