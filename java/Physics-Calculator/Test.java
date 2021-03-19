/**
 * Main program
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 16/3/2021
 */
public class Test
{
    public static void main(String[]args)
    {
        double[] inputs = {-4,1,4};
        String formulaForx1 = "( -1 * b + sqrt ( b ^ 2 - 4 * a * c ) ) / 2 * a";
        Formula f = new Formula(formulaForx1);
        Value v = new Value(f, inputs);
        Arithmetic a = new Arithmetic(f,v);
        //System.out.println(a.getResult());
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
