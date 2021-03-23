import java.util.Scanner;
/**
 * Gets string array from Formula and seperates symbol from the string array, then assigns values to each symbol
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 22/3/2021
 */
public class Value
{
    public String[] symbols;
    private double[] values;
    private String[] signs = {"+","-","*","/","^",")","(","sin","cos","tan","sin^-1","cos^-1","tan^-1","sqrt","pi","e"};

    public Value(Formula f)
    {
        setSymbols(f);
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
            if(symbols[i].equals(symbol))
            {
                b = true;
                count = i;
            }
        }
        if(b)
        {
            value = values[count];
        }
        else if(symbol.equals("pi"))
        {
            return Math.PI;
        }
        else if(symbol.equals("e"))
        {
            return Math.E;
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
     * setSymbols
     * Sets String array symbols
     * Arguments:
     *      Formula f - tokenized string array of formula
     * Returns: N/A
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 17/3/2021
     */
    public void setSymbols(Formula f)
    {
        String[] s = f.getToken();
        boolean check;
        int count = 0;
        
        for(int i = 0; i < s.length; i++)
        {
            check = true;
            for(int n = 0; n < i; n++)
            {
                if(s[i].equals(s[n]))
                {
                    check = false;
                }
            }
            for(int n = 0; n < signs.length; n++)
            {
                if(s[i].equals(signs[n]))
                {
                    check = true;
                    count++;
                }
            }
            try
            {
                double v = Double.parseDouble(s[i]);
                count++;
            }
            catch(NumberFormatException e)
            {
                if(check == false)
                {
                    count++;
                }
            }
        }
        symbols = new String[s.length - count];
        count = 0;
        
        for(int i = 0; i < s.length; i++)
        {
            check = true;
            for(int n = 0; n < signs.length; n++)
            {   
                if(s[i].equals(signs[n]))
                {
                    check = false;
                }
            }
            for(int n = 0; n < i; n++)
            {   
                if(s[i].equals(s[n]))
                {
                    check = false;
                }
            }
            if(check)
            {
                try
                {
                    double v = Double.parseDouble(s[i]);
                }
                catch(NumberFormatException e)
                {
                    symbols[count] = s[i];
                    count++;
                }
            }
        }
    }

    /**
     * setValues
     * Sets double array values
     * Arguments:
     *      double[] inputs - inputed double array of values
     * Returns: N/A
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 22/3/2021
     */
    public void setValues(String[] inputs, Value value)
    {
        values = new double[symbols.length];
        for(int i = 0; i < symbols.length; i++)
        {
            try
            {
                values[i] = Double.parseDouble(inputs[i]);
            }
            catch(NumberFormatException e)
            {
                continue;
            }
        }
        for(int i = 0; i < symbols.length; i++)
        {
            try
            {
                values[i] = Double.parseDouble(inputs[i]);
            }
            catch(NumberFormatException e)
            {
                if(inputs[i].equals("pi"))
                {
                    values[i] = Math.PI;
                }
                else if(inputs[i].equals("e"))
                {
                    values[i] = Math.E;
                }
                else
                {
                    Formula f = new Formula(inputs[i]);
                    Arithmetic a = new Arithmetic(f,value);
                    values[i] = Double.parseDouble(a.getResult());
                }
            }
        }
    }
}
