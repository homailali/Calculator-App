package life.homail.calculator
import kotlin.text.StringBuilder
class IfValidExpression(private val calculatorMain: CalculatorMain){
    private lateinit var equation:StringBuilder
    private var numbers=ArrayList<String>()
    private var symbols=ArrayList<String>()
    private var numStr:StringBuilder=StringBuilder()
    // Methods
    fun ifValidMain():Boolean{
        this.equation= StringBuilder(this.calculatorMain.calculatorViews.textFieldWhereUserEnters.text)
        this.reinitializeSomeThings()
        return this.checkIfValidExpression()
    }
    private fun checkIfValidExpression():Boolean{
        var bool:Boolean = this.checkForFirstSymbol(true)
        bool=this.checkForLastSymbol(bool)
        bool=this.checkNumberOfSymbolsAndNumberOfDigits(bool)
        bool=this.checkForBracketsError(bool)
        bool=this.checkForDecimalPointErrors(bool)
        return bool
    }
    // Symbols and decimal points errors
    private fun checkNumberOfSymbolsAndNumberOfDigits(bool: Boolean):Boolean{
        if (!bool) return false
        for (char in this.equation){
            if (this.isCharSymbol(char)){
                this.symbols.add(char.toString())
                if (this.numStr.isNotEmpty()){
                    this.numbers.add(this.numStr.toString())
                    this.numStr=StringBuilder()
                }
            } else this.numStr.append(char)
        }
        if (this.numStr.isNotEmpty()) this.numbers.add(numStr.toString())
        if (this.symbols.size==0) return false
        return symbols.size+1==this.numbers.size
    }
    private fun checkForFirstSymbol(bool: Boolean):Boolean{
        if (!bool || this.equation.length<=2) return false
        if (this.equation[0] == '/' || this.equation[0] == 'x') return false;
        else if (this.equation[0]=='-' || this.equation[0]=='+'){
            numStr.append(this.equation[0])
            this.equation.deleteCharAt(0)
        }
        return true
    }
    private fun checkForLastSymbol(bool: Boolean):Boolean{
        if (!bool) return false
        if (this.equation.last()=='.'){
            if (this.isCharSymbol(this.equation.get(this.equation.length-2))){
                return false
            }
        }
        return true
    }
    private fun checkForDecimalPointErrors(bool: Boolean):Boolean{
        if (!bool) return false
        var decimalPointCount:Int=0
        for (str:String in this.numbers){
            decimalPointCount=0;
            for (char:Char in str){
                if (char=='.') decimalPointCount++;
            }
            if (decimalPointCount>1) return false
        }
        return true
    }
    // Brackets Error
    private fun checkForBracketsError(bool: Boolean):Boolean{
        if (!bool) return false
        if (!this.equation.contains("(") && !this.equation.contains(")")) return true
        var innerBool:Boolean=true
        innerBool=this.checkTheNumberOfBrackets(true)
        innerBool=this.checkSomeOtherBracketErrors(innerBool)
        innerBool=this.checkForBracketAndNumber(innerBool)
        return innerBool
    }
    private fun checkTheNumberOfBrackets(innerBool: Boolean):Boolean{
        if (!innerBool) return false
        var leftBracketCount:Int=0
        var rightBracketCount:Int=0
        for (char in this.equation){
            if (char=='(') leftBracketCount++
            else if (char==')') rightBracketCount++;
        }
        return leftBracketCount==rightBracketCount
    }
    private fun checkSomeOtherBracketErrors(bool: Boolean):Boolean{
        if (!bool) return false
        return !(
             this.equation.contains("()") || this.equation.contains(")(") ||
             this.equation.contains(").") || this.equation.contains("(.")
        )
    }
    private fun checkForBracketAndNumber(bool: Boolean):Boolean{
        if (!bool) return false
        var innerBool:Boolean=true;
        for (i in 0 until this.equation.length){
            try {
                if (this.equation[i] == '(') {
                    innerBool = this.doesBracketHaveANumberWithIt(this.equation[i - 1], innerBool)
                } else if (this.equation[i]==')'){
                    innerBool = this.doesBracketHaveANumberWithIt(this.equation[i+1], innerBool)
                }
            } catch (indexOutOfBound:IndexOutOfBoundsException){}
            if (!innerBool) break
        }
        return innerBool
    }
    private fun doesBracketHaveANumberWithIt(char:Char,bool: Boolean):Boolean{
        if (!bool) return false
        return when(char){
            '0','1','2','3','4','5','6','7','8','9' ->false
            else->true
        }
    }
    // Other and common
    private fun isCharSymbol(char: Char):Boolean{
        when (char){
            '+'-> return true;
            '-'-> return true
            '/'-> return true
            'x'-> return true
            else->return false
        }
    }
    private fun reinitializeSomeThings(){
        this.symbols= ArrayList<String>()
        this.numbers= ArrayList<String>()
        this.numStr= StringBuilder()
    }
}