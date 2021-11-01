package ir.maniplayer.commands;

public class Interpreter 
{
		
	private String[] sourceCode;
	
	private String[] currentLine;
	
	private Parser parser;
	
	public Interpreter(String src) 
	{
		this.parser = new Parser();
		this.sourceCode = src.split("\n");
	}
	
	public void analize() 
	{
		for(int i = 0; i < sourceCode.length; i++)
		{
			this.currentLine = sourceCode[i].split(" ");
			this.parser.parse(this.currentLine);
		}
	}
}
