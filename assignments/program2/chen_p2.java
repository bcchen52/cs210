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
import java.nio.*;

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
			//ByteBuffer buffer = ByteBuffer.wrap(bytes);
			//BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFilename));
			DataInputStream input = new DataInputStream(new FileInputStream(inputFilename));
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
			//BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFilename));
			//DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFilename));

			int blocks;
			blocks = input.readInt();
			char indicator;
			int length = 0;
			String array; 
			
			for( int i = 0; i < blocks ; i++ )
			{
				indicator = input.readChar();
				System.out.println(indicator);
				if( indicator == 'i' ){
					output.write("int\t" + Integer.toString(input.readInt()));
					//output.write(Integer.toString(input.readInt()));
				} 	
				else if( indicator == 'l' ){
					output.write("long\t" + Long.toString(input.readLong()));
				} 
				
				else if( indicator == 'h' ){
					output.write("short\t" + Short.toString(input.readShort()));
				}
				else if( indicator == 'f' ){
					output.write("float\t" + Float.toString(input.readFloat()));

				}
				else if( indicator == 'd' ){
					output.write("double\t" + Double.toString(input.readDouble()));
				}
				else if( indicator == 'b' ){
					array = "long array\t";
					length = input.readInt();
					for( int k = 0; k < length; k++ )
					{
						array += Long.toString(input.readLong());
						if( k < length - 1 )
						{
							array += ",";
						}
					}
					output.write(array);
				}

				else if( indicator == 's' ){
					array = "string\t";
					length = input.readInt();
					for( int k = 0; k < length; k++ )
					{
						array += input.readChar();
					}
					output.write(array);
				}
				else if( indicator == 'g' ){
					array = "float array\t";
					length = input.readInt();
					for( int k = 0; k < length; k++ )
					{
						array += Float.toString(input.readFloat());
						if( k < length - 1 )
						{
							array += ",";
						}
					}
					output.write(array);
				}
				if( i < length - 1)
				{
					output.write("\n");
				}
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
	
	private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		System.out.println("convertTextToBinary");

		try
		{
			// put your code to read a text file and output it as a binary file
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>(0);
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFilename));
			byte[] bytes = new byte[8];
			ByteBuffer buffer = ByteBuffer.wrap(bytes);

			String inn;
			String[] split;
			char b_type;
			boolean length_needed;
			int length;
			int blocks = 0;
			while( (inn = input.readLine()) != null )
			{
				inputLines.add(inn);
				blocks ++;
			}
			//System.out.println(blocks);

			buffer.putInt(0, blocks);
			for( int i = 0; i < 4; i++)
			{
				output.write(buffer.get(i));			
			}

			for( int j = 0; j < inputLines.size(); j++)
			{
				inn = inputLines.get(j);
				split = inn.split("\t");
				b_type = 'a';
				length = 0;
				length_needed = false;

				if( split[0].equals("int") ){
					b_type = 'i';
					length = 4;
				} else if( split[0].equals("long") )
				{
					b_type = 'l';
					length = 8;
				} else if( split[0].equals("short") )
				{
					b_type = 'h';
					length = 2;
				} else if( split[0].equals("float") )
				{
					b_type = 'f';
					length = 4;
				} else if( split[0].equals("double") )
				{
					b_type = 'd';
					length = 8;
				} else if( split[0].equals("long array") )
				{
					b_type = 'b';
					length_needed = true;
				} else if( split[0].equals("string") )
				{
					b_type = 's';
					length_needed = true;
				} else if( split[0].equals("float array") )
				{
					b_type = 'g';
					length_needed = true;
				} 

				buffer.putChar(0, b_type);
				for( int i = 0; i < 2; i++)
				{
					output.write(buffer.get(i));
				}

				if( length_needed )
				{
					String[] split_list = new String[0];
					if( split[0].equals("string") )
					{
						length = split[1].length();
					} else 
					{	
						split_list = split[1].split(",");
						length = split_list.length;
					}

					buffer.putInt(0, length);
					for( int i = 0; i < 4; i++)
					{
						int hi = buffer.get(i);
						output.write(buffer.get(i));			
					}

					for( int k = 0; k < length; k++ )
					{
						if( b_type == 's' )
						{
							buffer.putChar(0, split[1].charAt(k));
							for( int i = 0; i < 2; i++)
							{
								int hi = buffer.get(i);
								output.write(buffer.get(i));			
							}
						}
						if( b_type == 'g' )
						{
							buffer.putFloat(0, Float.parseFloat(split_list[k]));
							for( int i = 0; i < 4; i++)
							{
								int hi = buffer.get(i);
								output.write(buffer.get(i));			
							}
						}
						if( b_type == 'b')
						{
							buffer.putLong(0, Long.parseLong(split_list[k]));
							for( int i = 0; i < 8; i++)
							{
								int hi = buffer.get(i);
								output.write(buffer.get(i));			
							}
						}
					}

				} else {
					if ( b_type == 'i' ){
						buffer.putInt(0, Integer.parseInt(split[1]));
					} else if ( b_type == 'h')
					{
						buffer.putShort(0, Short.parseShort(split[1]));
					} else if ( b_type == 'l')
					{
						buffer.putLong(0, Long.parseLong(split[1]));
					} else if ( b_type == 'f')
					{
						buffer.putFloat(0, Float.parseFloat(split[1]));
					} else if ( b_type == 'd')
					{
						buffer.putDouble(0, Double.parseDouble(split[1]));
					}

					for( int i = 0; i < length; i++)
					{
						int hi = buffer.get(i);
						output.write(buffer.get(i));	
					}
				}
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

