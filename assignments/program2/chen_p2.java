import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;

class chen_p2
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

		if( !args[0].startsWith("b") && !args[0].startsWith("t"))
		{
			System.out.println("First character of first argument should be b or t");
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
		// read binary - DataInputStream, no byte array to read
		// write binary - ByteBuffer to byte array, BufferedOutputStream to write to byte array

		try
		{
			// put your code to read a binary file and output it as a text file
			byte[] bytes = new byte[1];
			//BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFilename));
			DataInputStream input = new DataInputStream(new FileInputStream(inputFilename));
			//PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFilename));

			while( (input.read(bytes)) > 0)
			{
				//bytearray.add(inn);
				//System.out.println(inn);
				//String str = new String(bytes);
				//output.print(str);
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
	
	private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		System.out.println("convertTextToBinary");

		try
		{
			// put your code to read a text file and output it as a binary file
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>(0);
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputFilename)));
			
			String inn;
			while( (inn = input.readLine()) != null )
			{
				inputLines.add(inn);
				//System.out.println(inn.getBytes());
				output.write(inn.getBytes());
				output.write(System.lineSeparator().getBytes());
			}
			input.close();
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

