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
        String[] formulas = 
        {
            "( -1 * b + sqrt ( b ^ 2 - 4 * a * c ) ) / 2 * a",
            "( -1 * b - sqrt ( b ^ 2 - 4 * a * c ) ) / 2 * a",
            "v_o + a * t",
            "v_o * t + ( 1 / 2 ) * a * t ^ 2"
        };
        String formula;
        System.out.println("SELECT YOUR FORMULA");
        for(int i = 0; i < formulas.length; i++)
        {
            System.out.println((i+1)+". "+formulas[i]);
        }
        formula = scan.nextLine();
        switch(formula)
        {
            case"1":
                formula = formulas[0];
                break;
            case"2":
                formula = formulas[1];
                break;
            case"3":
                formula = formulas[2];
                break;
            case"4":
                formula = formulas[3];
                break;
            
            default:
                System.out.println("Formula not found.");
        }
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
