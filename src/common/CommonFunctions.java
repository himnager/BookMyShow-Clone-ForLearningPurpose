package common;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonFunctions 
{
	public static boolean isIntInsideArray(int arr[],int notobematched )
	{
		return IntStream.of(arr).anyMatch(myValue -> myValue == notobematched);
	}
	public  static int[] stringArrToIntArray(String[] arr) {
		try
		{
	    return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
		}
		catch(NumberFormatException nfe)
		{
			int arr1[]= {0};
			return arr1;
		}
	}
}
