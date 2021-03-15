/**
 * Write a description of class Formula here.
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 14/3/2021
 */
public class Arithmetic
{
    public Arithmetic(String[] formula, double[] values)
    {
        String[] s = OrderOfOperations(formula, values);
        System.out.println(s[0]);
    }
    
    /**
     * OrderOfOperations
     * Does calculations according to the order of operation.
     * Arguments:
     *      String[] f - 
     *      double[] v - 
     * Returns: String[]
     * 
     * Taewoo Rim
     * Created: 14/3/2021
     * Modified: 14/3/2021
     */
    public String[] OrderOfOperations(String[] f, double[] v)
    {
        String[] Chunk = new String[f.length];
        int placeHolder = 0;
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
                OrderOfOperations(Chunk, v);
                f[placeHolder] = f[placeHolder+1];
                for(int n = i-1; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                }
            }
        }
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "^")
            {
                f[i-1] = Double.toString(Math.pow(v[i-1], v[i+1]));
                v[i-1] = Math.pow(v[i-1], v[i+1]);
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                    v[n] = v[n+2];
                }
            }
        }
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "/")
            {
                f[i-1] = Double.toString(v[i-1]/v[i+1]);
                v[i-1] = v[i-1]/v[i+1];
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                    v[n] = v[n+2];
                }
            }
        }
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "*")
            {
                f[i-1] = Double.toString(v[i-1]*v[i+1]);
                v[i-1] = v[i-1]*v[i+1];
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                    v[n] = v[n+2];
                }
            }
        }
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "-")
            {
                f[i-1] = Double.toString(v[i-1]-v[i+1]);
                v[i-1] = v[i-1]-v[i+1];
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                    v[n] = v[n+2];
                }
            }
        }
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] == "+")
            {
                f[i-1] = Double.toString(v[i-1]+v[i+1]);
                v[i-1] = v[i-1]+v[i+1];
                for (int n = i; n < f.length - 2; n++)
                {
                    f[n] = f[n+2];
                    v[n] = v[n+2];
                }
            }
        }
        return f;
    }
}
