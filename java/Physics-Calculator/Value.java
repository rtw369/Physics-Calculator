import java.util.Scanner;
/**
 * Write a description of class Formula here.
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 15/3/2021
 */
public class Value
{
    private String[] symbols;
    private double[] values;
    private String[] exceptions = {"+","-","*","/",")","("};

    public Value(Formula f)
    {
        setSymbols(f.getToken());
        setValues();
    }

    /**
     * GetValue
     * @description (Write a description of the function)
     * Arguments:
     *      String symbol - a string to find corresponding value
     * Returns: double[] value
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 15/3/2021
     */
    public double findValue(String symbol)
    {
        double value;
        int count = 0;
        boolean b = false;

        for(int i = 0; i < symbols.length; i++)
        {
            if(symbols[i] == symbol)
            {
                b = true;
                count = i;
            }
        }
        if(b)
        {
            value = values[count];
        }
        //not found in symbols
        else
        {
            value = Double.parseDouble(symbol);
        }
        return value;
    }

    /**
     * SetSymbols
     * Sets String array symbols
     * Arguments:
     *      String[] tokens - tokenized string array of formula
     * Returns: N/A
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 15/3/2021
     */
    public void setSymbols(String[] tokens)
    {
        int check = 0;
        int count = 0;

        for(int i = 0; i < tokens.length; i++)
        {
            check = 0;
            while(check < exceptions.length)
            {
                if(tokens[i].equals(exceptions[check]))
                {
                    count++;
                }
                check++;
            }
        }

        symbols =  new String[tokens.length - count];
        count = 0;

        for(int i = 0; i < tokens.length; i++)
        {
            check = 0;
            for(int n = 0; n < exceptions.length; n++)
            {
                if(tokens[i].equals(exceptions[n]))
                {
                    check++;
                }
            }
            if(check == 0)
            {
                symbols[count] = tokens[i];
                count++;
            }
        }
    }

    /**
     * SetValues
     * Sets double array values
     * Arguments: N/A
     * Returns: N/A
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 15/3/2021
     */
    public void setValues()
    {
        Scanner scan = new Scanner(System.in);
        values = new double[symbols.length];

        for(int i = 0; i < symbols.length; i++)
        {
            System.out.println(symbols[i]+" : ");
            values[i] = Double.parseDouble(scan.nextLine());
        }
    }
}
