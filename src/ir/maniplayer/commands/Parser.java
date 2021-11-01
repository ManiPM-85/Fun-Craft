package ir.maniplayer.commands;

import java.util.*;
import ir.maniplayer.commands.utils.*;

public class Parser 
{	
	private Stack<Character> stackChar;
	private Stack<Integer> stackInt;
	
	private int jpx;
	
	private Scanner input;
	
	public Parser() 
	{
		this.stackChar = new Stack<Character>();
		this.stackInt = new Stack<Integer>();
		this.input = new Scanner(System.in);
		this.jpx = 0;
	}
	
	public void parse(String[] line)
	{
		switch(line[0])
		{
		case "say":
			this.sayCommand(ArrayUtils.removeFromStart(line, 1));
			break;
		case "execute":
			this.executeCommand(line[1], ArrayUtils.removeFromStart(line, 2));
			break;
		case "take":
			this.takeCommand(line[1]);
			break;
		case "set":
			this.setCommand(line[1], line[2]);
			break;
		case "drop":
			this.dropCommand(line[1]);
			break;
		case "push":
			this.pushCommand(line[1], line[2]);
			break;
		case "add":
			this.addCommand(line[1]);
			break;
		case "sub":
			this.subCommand(line[1]);
			break;
		case "mul":
			this.mulCommand(line[1]);
			break;
		case "div":
			this.divCommand(line[1]);
			break;
		case "mod":
			this.modCommand(line[1]);
			break;
		case "swap":
			this.swapCommand(line[1]);
			break;
		case "dup":
			this.duplicateCommand(line[1]);
			break;
		case "tell":
			this.tellCommand(line[1], line[2]);
			break;
		case "exit":
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	public void sayCommand(String[] args)
	{
		for(int i = 0; i < args.length; i++)
		{
			System.out.print(args[i]);
			System.out.print(' ');
		}
		
		System.out.print('\n');
	}
	
	public void takeCommand(String firstArg)
	{
		if(firstArg.equals("@i"))
		{
			this.stackInt.push(Integer.parseInt(this.input.nextLine()));
		}
		else if(firstArg.equals("@a"))
		{
			this.stackChar.push((char)Integer.parseInt(this.input.nextLine()));
		}
		else if(firstArg.equals("jpx"))
		{
			this.jpx = Integer.parseInt(this.input.nextLine());
		}
	}
	
	public void setCommand(String firstArg, String secondArg) {
		if(firstArg.equals("jpx"))
		{
			this.jpx = Integer.parseInt(secondArg);
		}
		if(firstArg.equals("@i"))
		{
			if(secondArg.equals("peek"))
			{
				this.jpx = this.stackInt.peek();
			}
			else if(secondArg.equals("pop"))
			{
				this.jpx = this.stackInt.pop();
			}
		}
	}
	
	public void dropCommand(String firstArg)
	{
		if(firstArg.equals("@i"))
		{
			this.stackInt.pop();
		}
		else if(firstArg.equals("@a"))
		{
			this.stackChar.pop();
		}
	}
	
	public void pushCommand(String firstArg, String secondArg)
	{
		if(firstArg.equals("@i"))
		{
			if(secondArg.equals("jpx"))
				this.stackInt.push(this.jpx);
			else
				this.stackInt.push(Integer.parseInt(secondArg));
		}
		else if(firstArg.equals("@a"))
		{
			if(secondArg.equals("jpx"))
				this.stackChar.push((char)this.jpx);
			else
				this.stackChar.push((char)Integer.parseInt(secondArg));
		}
	}
	
	public void addCommand(String firstArg) {
		if(firstArg.equals("@i"))
		{
			StackUtils.addTwoInt(stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.addTwoChar(stackChar);
		}
	}
	
	public void subCommand(String firstArg) {
		if(firstArg.equals("@i"))
		{
			StackUtils.subTwoInt(stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.subTwoChar(stackChar);
		}
	}
	
	public void mulCommand(String firstArg) {
		if(firstArg.equals("@i"))
		{
			StackUtils.mulTwoInt(stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.mulTwoChar(stackChar);
		}
	}
	
	public void divCommand(String firstArg) {
		if(firstArg.equals("@i"))
		{
			StackUtils.divTwoInt(stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.divTwoChar(stackChar);
		}
	}
	
	public void modCommand(String firstArg) {
		if(firstArg.equals("@i"))
		{
			StackUtils.modTwoInt(stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.modTwoChar(stackChar);
		}
	}
	
	public void swapCommand(String firstArg) {
		if(firstArg.equals("@i"))
		{
			StackUtils.swapInt(this.stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.swapChar(this.stackChar);
		}
	}
	
	public void duplicateCommand(String firstArg)
	{
		if(firstArg.equals("@i"))
		{
			StackUtils.duplicateInt(this.stackInt);
		}
		else if(firstArg.equals("@a"))
		{
			StackUtils.duplicateChar(this.stackChar);
		}
	}
	
	public void tellCommand(String firstArg, String secondArg)
	{
		if(firstArg.equals("@i"))
		{
			if(secondArg.equals("pop"))
			{
				System.out.println(this.stackInt.pop());
			}
			else if(secondArg.equals("peek"))
			{
				System.out.println(this.stackInt.peek());
			}
		}
		else if(firstArg.equals("@a"))
		{
			if(secondArg.equals("pop"))
			{
				System.out.println(this.stackChar.pop());
			}
			else if(secondArg.equals("peek"))
			{
				System.out.println(this.stackChar.peek());
			}
		}
		else if(firstArg.equals("jpx"))
		{
			if(secondArg.equals("ai"))
				System.out.println((int)this.jpx);
			if(secondArg.equals("ac"))
				System.out.println((char)this.jpx);
		}
	}

	public void executeCommand(String firstArg, String[] otherArgs) {
		if(firstArg.equals("run"))
		{
			this.parse(otherArgs);
		}
		else if(firstArg.equals("if"))
		{
			if(otherArgs[0].equals("@i"))
			{
				if(otherArgs[1].equals("pop"))
				{
					if(StackUtils.cnzPop(this.stackInt))
					{
						this.parse(ArrayUtils.removeFromStart(otherArgs, 2));
					}
				}
				else if(otherArgs[1].equals("peek"))
				{
					if(StackUtils.cnzPeek(this.stackInt))
					{
						this.parse(ArrayUtils.removeFromStart(otherArgs, 2));
					}
				}
			}
			else if(otherArgs[0].equals("jpx"))
			{
				if(this.jpx != 0)
				{
					this.parse(ArrayUtils.removeFromStart(otherArgs, 1));
				}
			}
		}
		else if(firstArg.equals("loop"))
		{
			if(otherArgs[0].equals("inf"))
			{
				if(this.jpx != 0)
				{
					while(true)
					{
						this.parse(ArrayUtils.removeFromStart(otherArgs, 1));
					}
				}
			}
			else if(ArrayUtils.isStringInt(otherArgs[0]))
			{
				if(this.jpx > 0)
				{
					int c = this.jpx;
					for(this.jpx = 0; this.jpx < Integer.parseInt(otherArgs[0]); this.jpx++)
					{
						this.parse(ArrayUtils.removeFromStart(otherArgs, 1));
					}
					this.jpx = c;
				}
			}
		}
	}
	
}
