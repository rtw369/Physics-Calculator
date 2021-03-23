/**
 * Gets tokenized formula from Formula and values from Value, then calculates and saves the result
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 18/3/2021
 */
public class Arithmetic
{
    private String result;
    public Arithmetic(Formula f, Value v)
    {
        String[] results = calculate(f, v);
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
     * Modified: 18/3/2021
     */
    public String[] calculate(Formula formula, Value v)
    {
        String[] s = formula.getToken();
        String[] chunk;
        boolean brackets = true;
        int placeHolder = 0;
        int num;
        int count;
        
        // Find brackets and do order of operations
        while(brackets)
        {
            brackets = false;
            for(int i = 0; i < s.length; i++)
            {
                if(s[i].equals("("))
                {
                    placeHolder = i;
                }
                if(s[i].equals(")"))
                {
                    num = placeHolder;
                    count = i - placeHolder;
                    chunk = new String[count];
                    for(int n = 0; n < count; n++)
                    {
                        chunk[n] = s[num];
                        num++;
                    }
                    chunk = orderOfOperations(v, chunk);
                    s[placeHolder] = chunk[0];
                    chunk = new String[s.length-count];
                    num = 0;
                    for(int n = 0; n <= placeHolder; n++)
                    {
                        chunk[num] = s[n];
                        num++;
                    }
                    for(int n = i+1; n < s.length; n++)
                    {
                        chunk[num] = s[n];
                        num++;
                    }
                    s = chunk;
                }
            }
            for(int i = 0; i < s.length; i++)
            {
                if(s[i].equals("("))
                {
                    brackets =  true;
                }
                else if(s[i].equals(")"))
                {
                    brackets = true;
                }
            }
        }
        
        s = orderOfOperations(v, s);
        return s;
    }
    
    /**
     * orderOfOperations
     * Does calculations according to the order of operation.
     * Arguments:
     *      Value value - used to call findValue in Value class
     *      String[] f - string array of expression that needs to be calculated accoring to the order of operation
     * Returns: String[] f
     * 
     * Taewoo Rim
     * Created: 14/3/2021
     * Modified: 18/3/2021
     */
    public String[] orderOfOperations(Value value, String[] f)
    {
        String[] s;
        if(f[0].equals("("))
        {   
            s = new String[f.length - 1];
            for(int i = 0; i < s.length; i++)
            {
                s[i] = f[i+1];
            }
            f = s;
        }
        // Find "^"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("^"))
            {
                s = new String[f.length-2];
                f[i-1] = Double.toString(Math.pow(value.findValue(f[i-1]), value.findValue(f[i+1])));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
                for(int n = 0; n < s.length; n++)
                {
                    s[n] = f[n];
                }
                f = s;
                i = 0;
            }
        }
        functions(value,f);
        // Find "/"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("/"))
            {
                s = new String[f.length-2];
                f[i-1] = Double.toString(value.findValue(f[i-1])/value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
                for(int n = 0; n < s.length; n++)
                {
                    s[n] = f[n];
                }
                f = s;
                i = 0;
            }
        }
        // Find "*"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("*"))
            {
                s = new String[f.length-2];
                f[i-1] = Double.toString(value.findValue(f[i-1])*value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
                for(int n = 0; n < s.length; n++)
                {
                    s[n] = f[n];
                }
                f = s;
                i = 0;
            }
        }
        // Find "-"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("-"))
            {
                s = new String[f.length-2];
                f[i-1] = Double.toString(value.findValue(f[i-1])-value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
                for(int n = 0; n < s.length; n++)
                {
                    s[n] = f[n];
                }
                f = s;
                i = 0;
            }
        }
        // Find "+"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i].equals("+"))
            {
                s = new String[f.length-2];
                f[i-1] = Double.toString(value.findValue(f[i-1])+value.findValue(f[i+1]));
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
                for(int n = 0; n < s.length; n++)
                {
                    s[n] = f[n];
                }
                f = s;
                i = 0;
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
     * Modified: 17/3/2021
     */
    public String[] functions(Value value, String[] f)
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
