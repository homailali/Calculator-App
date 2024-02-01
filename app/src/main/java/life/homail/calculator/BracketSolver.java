package life.homail.calculator;
public class BracketSolver {
    private CalculatorMain calculatorMain;
    private StringBuilder equation;
    private StringBuilder equationToSolve;
    private int indexToInsertAnswer;
    public BracketSolver(CalculatorMain calculatorMain) {

        this.calculatorMain = calculatorMain;
    }
    protected StringBuilder bracketSolverMain(StringBuilder equation){
        this.equation=equation;
        this.solveTheBracketsEquation();
        return this.equation;
    }
    private void solveTheBracketsEquation(){
        while (this.isSolved()){
            this.solvingIt();
        }
        if (this.ifHasSymbol()) this.solveTheExpressionFinalTime();
    }
    private boolean ifHasSymbol(){
        StringBuilder tempStr=new StringBuilder(this.equation);
        if (tempStr.charAt(0)=='-' || tempStr.charAt(0)=='+'){
            tempStr.deleteCharAt(0);
        }
        return (tempStr.toString().contains("-") || tempStr.toString().contains("/") || tempStr.toString().contains("x") || tempStr.toString().contains("+"));
    }
    private void solveTheExpressionFinalTime(){
        this.equation=new StringBuilder(this.calculatorMain.solveExpression.solveExpressionMain(this.equation));
    }
    private void solvingIt(){
        for (int i=0;i<this.equation.length();i++){
            if (this.equation.charAt(i)==')'){
                this.findTillPreviousBracket(i);
                this.equation.setCharAt(i,'a');
                break;
            }
        }
        this.deleteSolvedExpression();
        this.ifContainsPlusMinus();
        this.passTheExpressionToSolved();
    }
    private void passTheExpressionToSolved(){
        if (this.equationToSolve.length()>1) {
            StringBuilder answer = new StringBuilder(this.calculatorMain.solveExpression.solveExpressionMain(this.equationToSolve));
            this.equation.insert(this.indexToInsertAnswer, answer);
        } else {
            this.equation.insert(this.indexToInsertAnswer,this.equationToSolve);
        }
    }
    private void ifContainsPlusMinus(){
        if (this.equationToSolve.toString().contains("+-") || this.equationToSolve.toString().contains("-+")){
           try {
               for (int i=0;i<this.equationToSolve.length();i++){
                   if (this.equationToSolve.charAt(i)=='+' && this.equationToSolve.charAt(i+1)=='-'){
                       this.equationToSolve.deleteCharAt(i);
                       return;
                   } else if (this.equationToSolve.charAt(i)=='-' && this.equationToSolve.charAt(i+1)=='+'){
                       this.equationToSolve.deleteCharAt(i+1);
                       return;
                   }
               }
           } catch (IndexOutOfBoundsException indexOutOfBoundsException){}
        }
    }
    private void findTillPreviousBracket(int index){
        StringBuilder tempStringBuilder=new StringBuilder();
        for (int i=index-1;i>=0;i--){
            if (this.equation.charAt(i)=='(') {
                this.equation.setCharAt(i,'a');
                this.indexToInsertAnswer=i;
                break;
            }
            else {
                tempStringBuilder.append(this.equation.charAt(i));
                this.equation.setCharAt(i,'a');
            }
        }
        this.equationToSolve=tempStringBuilder.reverse();
    }
    private void deleteSolvedExpression(){
        for (int i=0;i<this.equation.length();i++){
            if (this.equation.charAt(i)=='a'){
                this.equation.deleteCharAt(i);
                i-=1;
            }
        }
    }
    private boolean isSolved(){
        return this.equation.toString().contains("(") || this.equation.toString().contains(")");
    }
}