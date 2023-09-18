import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.StringTokenizer;

class chen_lab3
{
	public static void main(String[] args)
    {
        //args = input file, output file, y/n

        int charcount = 0;
        int linecount = 0;
        int wordcount = 0;

        java.util.TreeSet<String> uniqueStrings = new java.util.TreeSet<>();
        java.util.ArrayDeque<String> stackOfCurrentStrings = new java.util.ArrayDeque<>();

        String inn;

        try
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));

            while( (inn = input.readLine()) != null )
            {
                java.util.StringTokenizer st = new java.util.StringTokenizer(inn, " ");

                while( st.hasMoreTokens()){
        
                    String next = st.nextToken();

                    char[] currentword = next.toCharArray();

                    uniqueStrings.add(next);

                    char[] reverseword = new char[currentword.length];

                    for( int i = 0; i < currentword.length; i++){
                        reverseword[i] = currentword[currentword.length-1-i];
                        charcount++;
                    }

                    String word = new String(reverseword);

                    stackOfCurrentStrings.addLast(word);

                    wordcount++;
                }

                while( stackOfCurrentStrings.size() > 0)
                {
                    output.print(stackOfCurrentStrings.removeLast());
                    if( stackOfCurrentStrings.size() > 0)
                    {
                        output.print(" ");
                    }
                }

                output.print("\n");

                //output.print(stackOfCurrentStrings);

                stackOfCurrentStrings.clear();

                linecount++;
            }
            output.flush();
            output.close();
        }
        /*
        StringTokenizer to read each line 
        Array deque to write the input file backwards
        String.toCharArray() to flip words
        TreeSet to get unique words
        */
        
        catch(Exception e)
        {
            System.out.println(e.toString());
            System.exit(0);
        }

        java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,###,###,###");
        System.out.println("There are " + linecount + " lines");
        System.out.println("There are " + wordcount + " words");
        System.out.println("There are " + charcount + " characters");
        System.out.println("There are " + uniqueStrings.size() + " unique words");

        if( args.length > 2)
        {
            if( args[2].toUpperCase().startsWith("Y") || args[2].toUpperCase().startsWith("T"))
            System.out.println("ordered unique words");
            {
                for( String word: uniqueStrings)
                {
                    System.out.println(word);
                }
            }
        }
    }
}