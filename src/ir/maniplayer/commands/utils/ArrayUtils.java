package ir.maniplayer.commands.utils;
public class ArrayUtils {

	public static String[] removeFromStart(String[] array, int count)
	{
		String[] result = new String[array.length - count];
		
		int k = 0;
		for(int i = count; i < array.length; i++)
		{
			result[k] = array[i];
			k++;
		}
		
		return result;
	}
	
	public static boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
}
