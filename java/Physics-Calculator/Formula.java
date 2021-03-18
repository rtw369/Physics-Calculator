/**
 * Takes a string and tokenize it
 *
 * Name: Taewoo Rim
 * Created: 14/3/2021
 * Modified: 14/3/2021
 */
public class Formula
{
    private String[] tokens;
    
    public Formula(String s)
    {
        tokens = s.split(" ");
    }
    
    /**
     * getToken
     * Gets tokenized string array of formula
     * Arguments:
     *      String s - formula string
     * Returns: String[] tokens
     * 
     * Name: Taewoo Rim
     * Created: 15/3/2021
     * Modified: 15/3/2021
     */
    public String[] getToken()
    {
        return tokens;
    }
}
