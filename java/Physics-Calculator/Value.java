import java.util.Scanner;
/**
 * Write a description of class Formula here.
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 16/3/2021
 */
public class Value
{
    private String[] symbols;
    private double[] values;
    private String[] exceptions = {"+","-","*","/",")","(","sin","cos","tan","sin^-1","cos^-1","tan^-1","sqrt"};

    public Value(Formula f, double[] inputs)
    {
        setSymbols(f.getToken());
        setValues(inputs);
    }

    /**
     *findValue
     * Finds a value based on string symbol
     * Arguments:
     *      String symbol - a string to find corresponding value
     * Returns: double value
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
     *getValues
     * Gets double[] values
     * Arguments: N/A
     * Returns: double value
     * 
     * Name: Taewoo Rim
     * Created: 16/3/2021
     * Modified: 16/3/2021
     */
    public double[] getValues()
    {
        return values;
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
     * Arguments:
     *      double[] inputs - inputed double array of values
     * Returns: N/A
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 16/3/2021
     */
    public void setValues(double[] inputs)
    {
        values = new double[symbols.length];

        for(int i = 0; i < symbols.length; i++)
        {
            values[i] = inputs[i];
        }
    }
}
