/**************************************************
*	Derek Yee
*	CS140 Intro to CS and Problem Solving
*
*
*	purpose: Driver for the game of life class.
*
*
*
*
*
*
*
****************************************************/
import java.util.Scanner;
import java.io.*;
public class Yee_GameOfLifeDriver
{
	public static void main(String[] args)
	{
		Yee_GameOfLife game=new Yee_GameOfLife();
		Scanner s=new Scanner(System.in);
		int i=0;
		int gen;
		do
		{
			System.out.println("How many Generations would you like to compute?");
			gen=s.nextInt();
			if(gen<0)
			{
				System.out.println("The input can not be negative.");
				i=0;
			}
			else
			i=1;
		}
		while(i==0);
		game.computeNextGeneration(gen);
	}
}

