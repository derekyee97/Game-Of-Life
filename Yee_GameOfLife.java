/*************************************************************************
*	author: Derek Yee
*	Program 6: Game Of Life
*	date last modified:6/3/2016
*	purpose: The class to initialize the gameboard of the Game Of Life
*
*
**************************************************************************/
import java.util.Scanner;
import java.io.*;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Yee_GameOfLife 
{
	private Scanner s=new Scanner(System.in);
	private char[][] charArray;
	private char[][] tempArray;
	private int row,column,i=0,counterTempish=0;   //i is whati s going to be used to keep track of a valid or invalid file.
	private char[] tempish;
	private File file;
	private Scanner fileReader;
	private int a=0,counter=0,recurssiveChecker=1,printerCounter=1;
	public Yee_GameOfLife()     //constructor of Game Of Life to set the data of gameboard in a 2d array. Loops until a file is found.
	{
		System.out.println("Welcome to the game of life program!");
		System.out.println("Please enter the file name containing the game board: ");
		do
		{
			try{
			i=0;
			String fileName=s.nextLine();
			file=new File(fileName);
			fileReader=new Scanner(file);
			column=fileReader.nextInt();
			row=fileReader.nextInt();
			charArray=new char[row][column];
			}
			catch(FileNotFoundException e)
			{
				System.out.println("The file was not found, please re-enter the file name.");
				i=1;
			}
		}
		while(i==1);
		tempish=new char[column*row];   //setting array to store in 2d array
		while(fileReader.hasNext())
		{
			
			tempish[a]=fileReader.next().charAt(0);
			a++;   
			
		}
		for(int j=0;j<row;j++)
		{	
			for(int k=0;k<column;k++)
			{
				charArray[j][k]=tempish[counterTempish];
				counterTempish++;
			}
			
		}
		//System.out.println("How many generations would you like to compute?");
		//numOfGen=s.nextInt();

	}
	//====================================================================================================
	//method: getColumn()
	//purpose: To return the number of columns on the gameboard.
	
	public int getColumn()
	{
		return column;
	}
	//method: getRow()
	//pirpose: To return the number of rows on the gamboard.	
	
	public int getRow()
	{
		return row;
	}
	//method: getCell()
	//purpose: To return a specific location of the game board/2d array. 

	public int getCell(int col,int roww)
	{
		if(col>column||roww>row||col<0||roww<0)
		{
		return 0;
		}
		else
		{
			return charArray[roww][col];
		}		
	}
	

	//method:setCell()
	//purpose: To  retrive a specific space in the 2d array, and change the input.
	
	public void setCell(int col,int roww, int value)
	{
		char a=(char)value;
		charArray[roww][col]=a;
	}
	//====================================================================================================
	//====================================================================================================
	//method: computeNextGeneration
	//purpose: To show the cells after one generation at a time, will recursively call itself till prints out number of "generations".
	public void computeNextGeneration(int generation)
	{
		tempArray=new char[row][column];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				tempArray[i][j]=charArray[i][j];      //making copy of array
			}
		}
		//tempArray=charArray.clone();
		for(int a=1;a<row-1;a++)
		{
			for(int b=1;b<column-1;b++)
			{
				counter=0;                      //counter to keep track of how many are alive.
				if(charArray[a][b]=='X')
				{
					if(charArray[a-1][b-1]=='X')
					counter++;
					if(charArray[a-1][b]=='X')
					counter++;
					if(charArray[a][b-1]=='X')
					counter++;
					if(charArray[a+1][b+1]=='X')
					counter++;
					if(charArray[a][b+1]=='X')
					counter++;
					if(charArray[a+1][b]=='X')
					counter++;
					if(charArray[a-1][b+1]=='X')
					counter++;
					if(charArray[a+1][b-1]=='X')
					counter++;
					switch(counter)                              //logic to determine what to do for the "cells"
					{
						case 1:
							tempArray[a][b]='0';
							break;
						
						case 2:
						case 3:
							tempArray[a][b]='X';
							break;
						case 4:
							tempArray[a][b]='0';
							break;
						default:
							tempArray[a][b]='0';
					}
				}
				else
				{
					if(charArray[a-1][b-1]=='X')
					counter++;
					if(charArray[a-1][b]=='X')
					counter++;
					if(charArray[a][b-1]=='X')
					counter++;
					if(charArray[a+1][b+1]=='X')
					counter++;
					if(charArray[a][b+1]=='X')
					counter++;
					if(charArray[a+1][b]=='X')
					counter++;
					if(charArray[a-1][b+1]=='X')
					counter++;
					if(charArray[a+1][b-1]=='X')
					counter++;
					if(counter==3)                                //revives a dead cell if there are 3 neighbors. 
					{
						tempArray[a][b]='X';
					}
				}

			}
		}

		System.out.println("Printing generation: "+recurssiveChecker);
		recurssiveChecker++;
		print();
		
			for(int i=0;i<row;i++)
			{
			for(int j=0;j<column;j++)
			{
				charArray[i][j]=tempArray[i][j];                  //"updating gameboard" 
			}
			}
		//System.out.println("Printing generation: "+recurssiveChecker);
		//recurssiveChecker++;
		//print();
		if(generation==1)
		{
			return;
		}
		generation--;
		computeNextGeneration(generation);
		
		
	
	}
	//====================================================================================================
	//====================================================================================================	
	//purpose: a function to print out the 2d array. 
	public void print()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				System.out.print(charArray[i][j]);
				
			}
		System.out.println();	
		}
		System.out.println();
	}
	//====================================================================================================
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
