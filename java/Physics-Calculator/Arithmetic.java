/**
 * Write a description of class Formula here.
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 15/3/2021
 */
public class Arithmetic
{
    public Arithmetic(Formula f, Value v)
    {
        orderOfOperations(f.getToken(), v.getValue());
    }
    
    /**
     * OrderOfOperations
     * Does calculations according to the order of operation.
     * Arguments:
     *      String[] f - tokenized formula
     *      String[] s - symbols
     *      double[] v - values of symbols
     * Returns: String[] f
     * 
     * Taewoo Rim
     * Created: 14/3/2021
     * Modified: 15/3/2021
     */
    public String[] orderOfOperations(String[] f, double[] v)
    {
        Value value = new Value(f,v);
        String[] Chunk = new String[f.length];
        int placeHolder = 0;
        
        // Find brackets and do order of operations
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "(")
            {
                placeHolder = i;
            }
            else if(f[i] == ")")
            {
                for(int count = i - placeHolder; placeHolder < i; count++)
                {
                    Chunk[count] = f[placeHolder];
                    i--;
                }
                orderOfOperations(Chunk, v);
                f[placeHolder] = f[placeHolder+1];
                for(int n = i-1; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        // Find "^"
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "^")
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
            if(f[i] == "*")
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
            if(f[i] == "*")
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
            if(f[i] == "*")
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
            if(f[i] == "+")
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
}
