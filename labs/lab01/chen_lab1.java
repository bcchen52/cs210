import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;


class chen_lab1
{
    public static void main(String[] args)
    {
        // check if command line arguments

        if (args.length == 0)
        {
            System.out.println("no arguments :(");
            System.exit(0);
        }

        String filename = args[0];

        int lineCount = 0;
        int tokenCount = 0;
        int intCount = 0;
        int intSum = 0;
        String[] tokens = new String[args.length-1];
        int[] tokens_counter = new int[args.length-1];

        if (args.length > 1)
        {
            for (int i = 1; i<args.length; i++)
            {
                tokens[i-1] = args[i];
                tokens_counter[i-1] = 0;
            }
        }

        // create Decimal Format

        java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,###,###,###");

        
        try
        {
            // open BufferedReader

            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            String inn;

            while((inn = input.readLine()) != null)
            {
                // System.out.println(inn);
                lineCount ++;

                java.util.StringTokenizer st = new java.util.StringTokenizer(inn);

                while(st.hasMoreTokens())
                {

                    String token = st.nextToken();

                    tokenCount ++;
                    
                    try
                    {
                        int v = Integer.parseInt(token);

                        intCount ++;
                        intSum += v;
                    }
                    catch(Exception e)
                    {
                        
                    }

                    for (int i = 0; i<tokens.length; i++)
                    {
                        if (tokens[i].equalsIgnoreCase(token))
                        {
                            tokens_counter[i] ++;
                        }
                    }

                }
                
            }
            // close the BufferedReader
            input.close();

            // output
            System.out.println("lineCount = " + lineCount);
            System.out.println("tokenCount = " + tokenCount);
            System.out.println("intCount = " + intCount);
            System.out.println("intSum = " + intSum);

            for (int i = 0; i<tokens.length; i++)
            {
                System.out.println(tokens[i] + " = " + tokens_counter[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            System.exit(0);
        }
        
    }
}