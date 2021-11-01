package ir.maniplayer.commands;

import java.io.*;

import ir.maniplayer.commands.utils.FileUtils;

public class Shell 
{
	public static void main(String[] args) 
	{
		try 
		{
			Interpreter interpreter = new Interpreter(FileUtils.readFile(args[0]));
			interpreter.analize();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
