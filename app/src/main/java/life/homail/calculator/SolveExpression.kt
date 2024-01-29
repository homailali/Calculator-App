package life.homail.calculator
import kotlin.text.StringBuilder
class SolveExpression(private val calculatorMain: CalculatorMain){
    // Fields
    private var operatorToLookFor:Char=' '
    private lateinit var equation:StringBuilder
    private var indexToPutTheSolvedEquation:Int=0
    private var ifMinusAddedInPreviousNumber:Boolean=false
    // Methods
    fun solveExpressionMain(equation:String):String{
        this.resetSomeThings()
        this.equation=StringBuilder(equation)
        this.solvingExpression()
        return this.equation.toString()
    }
    private fun solvingExpression(){
        while (this.ifEquationSolved()){
            this.operatorToLookFor=this.findOperatorToLookFor()
            this.separateNumberAndSymbol()
        }
    }
    private fun separateNumberAndSymbol(){
        var num1Str:StringBuilder=StringBuilder()
        var num2Str:StringBuilder=StringBuilder()
        if (this.equation[0]=='-' || this.equation[0]=='+') {
            num1Str.append(this.equation[0])
            this.equation.deleteCharAt(0)
        }
        for (i in 0 until this.equation.length){
            if (this.equation[i]==this.operatorToLookFor){
                num1Str.append(this.findPreviousNumber(i))
                num2Str.append(this.findTheNumberAfter(i))
                this.equation.setCharAt(i,'a')
                break
            }
        }
        this.deleteSolvedExpression()
        this.perFormCalc(num1Str,num2Str)
    }
    private fun perFormCalc(num1Str:StringBuilder,num2Str:StringBuilder){
        val num1:Double=num1Str.toString().toDouble()
        val num2:Double=num2Str.toString().toDouble()
        val answer:Double;
        when(this.operatorToLookFor){
            '/'->answer=num1/num2
            'x'->answer=num1*num2
            '+'->answer=num1+num2
            '-'->answer=num1-num2
            else->answer=0.0;
        }
        this.equation.insert(this.indexToPutTheSolvedEquation,answer.toString())
    }
    private fun findTheNumberAfter(index: Int):StringBuilder{
        val indexToStart:Int=index+1;
        val tempStringBuilder:StringBuilder= StringBuilder()
        for (i in indexToStart until this.equation.length){
            if (this.ifCharIsSymbol(this.equation[i])){
                break
            } else {
                tempStringBuilder.append(this.equation[i])
                this.equation.setCharAt(i,'a')
            }
        }
        return tempStringBuilder
    }
    private fun findPreviousNumber(index:Int):StringBuilder{
        val indexToStart:Int=index-1;
        val tempStringBuilder:StringBuilder= StringBuilder();
        for (i in indexToStart downTo 0){
            if (this.ifCharIsSymbol(this.equation[i])){
                if (this.equation[i]=='-'){
                    tempStringBuilder.append(this.equation[i])
                    this.equation.setCharAt(i,'a')
                    this.ifMinusAddedInPreviousNumber=true
                    this.indexToPutTheSolvedEquation=i
                }
                break
            } else {
                tempStringBuilder.append(this.equation[i])
                this.equation.setCharAt(i,'a')
                this.indexToPutTheSolvedEquation=i
            }
        }
        return tempStringBuilder.reverse()
    }
    private fun ifCharIsSymbol(char:Char): Boolean {
        when (char) {
            '/', '+', '-', 'x','X' -> return true
            else -> return false
        }
    }
    private fun deleteSolvedExpression(){
        this.equation=this.calculatorMain.codeICouldNotConvertToKotlin.deleteSolvedExpression(this.equation)
    }
    private fun findOperatorToLookFor():Char{
        if (this.equation.contains('/')) return '/'
        else if (this.equation.contains('x')) return 'x'
        else if (this.equation.contains('+')) return '+'
        else if (this.equation.contains('-')) return '-'
        throw Exception();
    }
    private fun ifEquationSolved():Boolean{
        var tempStringBuilder:StringBuilder;
        if (this.equation[0]=='-' || this.equation[0]=='+'){
            tempStringBuilder=StringBuilder(this.equation)
            tempStringBuilder.deleteCharAt(0)
        } else tempStringBuilder=StringBuilder(this.equation)
        return (
                (tempStringBuilder.contains("/") || tempStringBuilder.contains("x") ||
             tempStringBuilder.contains("+") || tempStringBuilder.contains("-"))
        )
    }
    private fun resetSomeThings(){
        this.indexToPutTheSolvedEquation=0
        this.ifMinusAddedInPreviousNumber=false
    }
}