/**
 * Write a description of class Formula here.
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 15/3/2021
 */
public class Test
{
    public static void main(String[]args)
    {
        String[] symbols;
        double[] values = {1,2,3,4,5};
        String formulaForV = "v_o + a * t";
        Formula f = new Formula(formulaForV);
        Value v = new Value(f);
        Arithmetic a = new Arithmetic(f,v)
    }
    
    /**
     * @function_name
     * @description (Write a description of the function)
     * Arguments:
     *      @arg1 - @description
     * Returns: @returns
     * 
     * Name: @author (your name)
     * Created: @date (a version number or a date)
     * Modified: @modification_date
     */
}
