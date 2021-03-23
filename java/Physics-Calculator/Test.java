/**
 * Main program
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 22/3/2021
 */
import java.util.Scanner;
public class Test
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        String formula = "a + b + c";
        Formula f = new Formula(formula);
        Value v = new Value(f);
        String [] input = new String[v.symbols.length];
        for(int i = 0; i < input.length; i++)
        {
            System.out.println("ENTER A NUMBER FOR : "+v.symbols[i]);
            input[i] = scan.nextLine();
        }
        v.setValues(input,v);
        Arithmetic a = new Arithmetic(f,v);
        System.out.println(a.getResult());
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
