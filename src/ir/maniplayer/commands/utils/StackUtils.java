package ir.maniplayer.commands.utils;

import java.util.*;

public class StackUtils 
{
	// CHECK IF NOT ZERO BEGIN
	public static boolean cnzPop(Stack<Integer> stackInt)
	{
		int a = stackInt.pop();
		if(a == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static boolean cnzPeek(Stack<Integer> stackInt)
	{
		int a = stackInt.peek();
		if(a == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	// CHECK IF NOT ZERO END
	
	
	// ADDITION	BEGIN
	public static void addTwoInt(Stack<Integer> stackInt)
	{
		int a = stackInt.pop();
		int b = stackInt.pop();
		stackInt.push(a + b);
	}
	
	public static void addTwoChar(Stack<Character> stackChar)
	{
		char a = stackChar.pop();
		char b = stackChar.pop();
		stackChar.push((char) (a + b));
	}
	// ADDITION END
	
	// SUBTRACTION BEGIN
	public static void subTwoInt(Stack<Integer> stackInt)
	{
		int a = stackInt.pop();
		int b = stackInt.pop();
		stackInt.push(b - a);
	}
	
	public static void subTwoChar(Stack<Character> stackChar)
	{
		char a = stackChar.pop();
		char b = stackChar.pop();
		stackChar.push((char) (b - a));
	}
	// SUBTRACTION END
	
	// MULTIPLICATION BEGIN
	public static void mulTwoInt(Stack<Integer> stackInt)
	{
		int a = stackInt.pop();
		int b = stackInt.pop();
		stackInt.push(a * b);
	}
		
	public static void mulTwoChar(Stack<Character> stackChar)
	{
		char a = stackChar.pop();
		char b = stackChar.pop();
		stackChar.push((char) (a * b));
	}
	// MULTIPLICATION END
	
	// DIVITION BEGIN
	public static void divTwoInt(Stack<Integer> stackInt)
	{
		int a = stackInt.pop();
		int b = stackInt.pop();
		stackInt.push((int)(b / a));
	}
		
	public static void divTwoChar(Stack<Character> stackChar)
	{
		char a = stackChar.pop();
		char b = stackChar.pop();
		stackChar.push((char)(int)(b / a));
	}
	// DIVITION END
	
	// MODULATION BEGIN
	public static void modTwoInt(Stack<Integer> stackInt)
	{
		int a = stackInt.pop();
		int b = stackInt.pop();
		stackInt.push((int)(b % a));
	}
			
	public static void modTwoChar(Stack<Character> stackChar)
	{
		char a = stackChar.pop();
		char b = stackChar.pop();
		stackChar.push((char)(int)(b % a));
	}
	// MODULATION END
	
	// DUPLICATION BEGIN
	public static void duplicateInt(Stack<Integer> stackInt)
	{
		int a = stackInt.peek();
		stackInt.push(a);
	}
	
	public static void duplicateChar(Stack<Character> stackChar)
	{
		char a = stackChar.peek();
		stackChar.push(a);
	}
	// DUPLICATION END
	
	// SWAPING BEGIN
	public static void swapInt(Stack<Integer> stackInt)
	{
		int[] stackValues = new int[stackInt.size()];
		for(int i = 0; i < stackValues.length; i++)
		{
			stackValues[i] = stackInt.pop();
		}
		
		for(int i = 0; i < stackValues.length; i++)
		{
			stackInt.push(stackValues[i]);
		}
	}
	
	
	public static void swapChar(Stack<Character> stackChar)
	{
		char[] stackValues = new char[stackChar.size()];
		for(int i = 0; i < stackValues.length; i++)
		{
			stackValues[i] = stackChar.pop();
		}
		
		for(int i = 0; i < stackValues.length; i++)
		{
			stackChar.push(stackValues[i]);
		}
	}
	// SWAPING END
}
