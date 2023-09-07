




class chen_lab2
{
	public static void main(String[] args)
	{
		// put some code here to check for three commandline arguments

		if( args.length != 3)
		{
			System.out.println("Enter 3 arguments");
			System.exit(0);
		}
		
		// put some code here to check that the first commandline argument starts with "b" or "t"

		if( !args[0].startsWith("b") && !args[0].startsWith("a"))
		{
			System.out.println("First character of first argument should be b or a");
			System.exit(0);
		}
		
		if( args[0].startsWith("b") )
		{
			convertBinaryToText(args[1], args[2]);
		}
		else
		{
			convertTextToBinary(args[1], args[2]);
		}
	}
	
	private static void convertBinaryToText(String inputFilename, String outputFilename)
	{
		System.out.println("convertBinaryToText");
		try
		{
			// put your code to read a binary file and output it as a text file
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		System.out.println("convertTextToBinary");
		try
		{
			// put your code to read a text file and output it as a binary file
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>(0);
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
			
			String inn;
			while( (inn = input.readLine()) != null )
			{
				inputLines.add(inn);
			}
			input.close()

			/*
			for( i = 0; i < inputLines.length; i++)
			{
				inputLines(i)
			}
			*/

			//java.io.FileOutputStream input = new java.io.FileOutputStream(outputFilename, true);
			java.io.BufferedOutputStream output = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outputFilename));

			for( i = 0; i < inputLines.length; i++)
			{
				output.write(inputLines[i].getBytes());
				output.write(System.lineSeperator().getBytes())
			}

			output.flush();
			output.close();


		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}

