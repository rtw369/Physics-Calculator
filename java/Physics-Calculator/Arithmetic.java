/**
 * Write a description of class Formula here.
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 16/3/2021
 */
public class Arithmetic
{
    private String result;
    public Arithmetic(Formula f, Value v)
    {
        String[] results = calculate(f, v.getValues());
        result = results[0];
    }
    
    /**
     * calculate
     * Checks for brackets and calculate
     * Arguments:
     *      Formula f
     *      double[] v - values of symbols
     * Returns: String[] f
     * 
     * Taewoo Rim
     * Created: 14/3/2021
     * Modified: 16/3/2021
     */
    public String[] calculate(Formula formula, double[] v)
    {
        String[] f = formula.getToken();
        Value value = new Value(formula,v);
        String[] Chunk = new String[f.length];
        int placeHolder = 0;
        
        // Find brackets and do order of operations
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("("))
            {
                placeHolder = i;
            }
            else if(f[i].equals(")"))
            {
                for(int count = i - placeHolder; placeHolder < i; count++)
                {
                    Chunk[count] = f[placeHolder];
                    i--;
                }
                orderOfOperations(value, Chunk, v);
                f[placeHolder] = f[placeHolder+1];
                for(int n = i-1; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        
        orderOfOperations(value, f, v);
        return f;
    }
    
    /**
     * OrderOfOperations
     * Does calculations according to the order of operation.
     * Arguments:
     *      Value value - used to call findValue in Value class
     *      String[] f - string array of expression that needs to be calculated accoring to the order of operation
     *      double[] v - values of symbols
     * Returns: String[] f
     * 
     * Taewoo Rim
     * Created: 14/3/2021
     * Modified: 16/3/2021
     */
    public String[] orderOfOperations(Value value, String[] f, double[] v)
    {
        // Find "^"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("^"))
            {
                f[i-1] = Double.toString(Math.pow(value.findValue(f[i-1]), value.findValue(f[i+1])));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        // Find "/"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("/"))
            {
                f[i-1] = Double.toString(value.findValue(f[i-1])/value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        // Find "*"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("*"))
            {
                f[i-1] = Double.toString(value.findValue(f[i-1])*value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        // Find "-"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("-"))
            {
                f[i-1] = Double.toString(value.findValue(f[i-1])-value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        // Find "+"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("+"))
            {
                f[i-1] = Double.toString(value.findValue(f[i-1])+value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        return f;
    }
    
    /**
     * functions
     * Checks to see if there are functions in the formula and calculates if there is
     * Arguments: 
     *      
     * Returns: 
     * 
     * Taewoo Rim
     * Created: 16/3/2021
     * Modified: 16/3/2021
     */
    public String[] functions(Value value, String[] f, double[] v)
    {
        boolean changed = false;
        for(int i = 0; i < f.length; i++)
        {
            switch(f[i])
            {
                case "sin":
                    f[i] = Double.toString(Math.sin(value.findValue(f[i+1])));
                    changed = true;
                    break;
                case "cos":
                    f[i] = Double.toString(Math.cos(value.findValue(f[i+1])));
                    changed = true;
                    break;
                case "tan":
                    f[i] = Double.toString(Math.tan(value.findValue(f[i+1])));
                    changed = true;
                    break;
                case "sin^-1":
                    f[i] = Double.toString(Math.asin(value.findValue(f[i+1])));
                    changed = true;
                    break;
                case "cos^-1":
                    f[i] = Double.toString(Math.acos(value.findValue(f[i+1])));
                    changed = true;
                    break;
                case "tan^-1":
                    f[i] = Double.toString(Math.atan(value.findValue(f[i+1])));
                    changed = true;
                    break;
                case "sqrt":
                    f[i] = Double.toString(Math.sqrt(value.findValue(f[i+1])));
                    changed = true;
                    break;
                default:
            }
            if(changed)
            {
                for (int n = i + 1; n < f.length - 1; n++)
                {
                    f[n] = f[n+1];
                }
            }
        }
        return f;
    }
    
    /**
     * getResult
     * Gets result
     * Arguments:N/a
     * Returns: String result
     * 
     * Taewoo Rim
     * Created: 16/3/2021
     * Modified: 16/3/2021
     */
    public String getResult()
    {
        return result;
    }
}
