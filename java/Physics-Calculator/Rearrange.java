/**
 * Rearranges an equation that has been tokenized by Formula.
 *
 * Name: Taewoo Rim
 * Created: 23/3/2021
 * Modified: 23/3/2021
 */
public class Rearrange
{
    private String[] solveFor;
    private String[] expression;
    public Rearrange(Formula f, String symbol)
    {
        splitEquation(f);
    }
    
    /**
     * splitEquation
     * Splits the equation into 2 expression
     * Arguments:
     *      Formula f - tokenized formula
     * Returns: N/A
     * 
     * Name: Taewoo Rim
     * Created: 23/3/2021
     * Modified: 23/3/2021
     */
    public void splitEquation(Formula f)
    {
        String[] equation = f.getToken();
        int num = 0;
        for(int i = 0; i < equation.length; i++)
        {
            if(equation[i].equals("="))
            {
                num = i;
            }
        }
        solveFor = new String[num-1];
        expression = new String[equation.length-num];
        for(int i = 0; i < num; i++)
        {
            solveFor[i] = equation[i];
        }
        for(int i = num; i < equation.length; i++)
        {
            expression[i] = equation[num+1];
        }
    }
    
    /**
     * rearrangeExpressions
     * @description (Write a description of the function)
     * Arguments:
     *      Formula f - tokenized formula
     *      String symbol - the variable that needs to be isolated
     * Returns: String[] finalFormula
     * 
     * Name: Taewoo Rim
     * Created: 23/3/2021
     * Modified: 23/3/2021
     */
    public String[] rearrangeExpressions(Formula f, String symbol)
    {
        String[] finalFormula = new String[f.getToken().length - 2];
        
        return finalFormula;
    }
}
