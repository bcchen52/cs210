class chen_p1
{
	// constructor for the class
	public chen_p1()
	//public static void main(String[] args)
	{
		
	}
	
	// method to sort an array of int values using selection sort
	public int[] selectionSort(int lowerBound, int upperBound, int[] values)
	//private static void selectionSort(int lowerBound, int upperBound, int[] values)
	
	{
		int[] smallest = new int[2];
		for( int i = lowerBound; i<=upperBound; i++)
		{
			smallest[0] = i;
			smallest[1] = values[i];

			for( int k = i; k<=upperBound; k++)
			{
				if( values[k] < smallest[1])
				{
					smallest[0] = k;
					smallest[1] = values[k];
					
				}
			}
			
			if( smallest[0] != i)
			{
				values[smallest[0]] = values[i];
				values[i] = smallest[1];
			}
			
			
		}
		
		return values;
		

	}



	// method to return the number of array elements > testValue with indices in 
	// [lowerBound, upperBound] using a for loop to examine the array elements
	public int forLoopTest(int[] values, int lowerBound, int upperBound, int testValue)
	{
		int count = 0;
		for( int i=lowerBound; i<=upperBound; i++){
			if( values[i] > testValue)
			{
				count ++;
			}
		}
		return count;
	}
	

	// method to return the number of array elements <= testValue with indices in 
	// [lowerBound, upperBound) using a while loop to examine the array elements
	public int whileLoopTest(int[] values, int lowerBound, int upperBound, int testValue)
	{
		int count = 0;
		int i = lowerBound;
		while( i < upperBound){
			if( values[i] <= testValue)
			{
				count ++;
			}
			i++;
		}
		return count;
	}
	

	// method to return the number of array elements in (testValue1, testValue2) 
	// or (testValue2, testValue1) with indices in [lowerBound, upperBound] using
	// a do-while loop to examine the array elements
	public int doWhileLoopTest(int[] values, int lowerBound, int upperBound, int testValue1, int testValue2)
	{
		int count = 0;
		int i = lowerBound;
		int upper;
		int lower;
		if( testValue1 > testValue2)
		{
			upper = testValue1;
			lower = testValue2;
		} 
		else 
		{
			lower = testValue1;
			upper = testValue2;
		}
		while( i <= upperBound){
			if( values[i] < upper && values[i] > lower)
			{
				count ++;
			}
			i++;
		}
		return count;
	}
	

	// method to return the number of array elements that match the switch cases 
	// [0, 3, 6, 9, 12, 15, 18, 21, 24, 27] and the default case with indices in 
	// (lowerBound, upperBound)
	public int[] switchTest(int[] values, int lowerBound, int upperBound)
	{
		int[] count = new int[]{0,0,0,0,0,0,0,0,0,0,0};
		for( int i = lowerBound+1; i < upperBound; i++)
		{
			switch (values[i])
			{
				case 0:
					count[0] = count[0] + 1;
					break;
				case 3:
					count[1] = count[1] + 1;
				case 6:
					count[2] = count[2] + 1;
					break;
				case 9:
					count[3] = count[3] + 1;
				case 12:
					count[4] = count[4] + 1;
					break;
				case 15:
					count[5] = count[5] + 1;
				case 18:
					count[6] = count[6] + 1;
					break;
				case 21:
					count[7] = count[7] + 1;
				case 24:
					count[8] = count[8] + 1;
					break;
				case 27:
					count[9] = count[9] + 1;
				default:
					count[10] = count[10] + 1;
					break;
			}
		}
		return count;
	}
	
}
