import java.util.Arrays;
import java.util.Scanner;

/*
 Author: Angel
Date: Jan. 21, 2016
Class: CSCI 230
Assignment: Homework 1
Task:  focus on understanding recursion through java implementation.
Input:keybaord input is need from the user.
Output: boolean, integer, or an array.depending on the method 

Certification of Authenticity: 

 I certify that this code is my own work, but I received some assistance from:
Paul Ksyer and Bill Manaris.

 */
public class Recursion 
{
	
	/*
	
	Purpose:returns true if item is in list starting at startIndex, 
	false otherwise
	Preconditions:  int[] list, int item which is the item you are look for, int startIndex which cannot be larger than the startIndex
	Postconditions: returns a boolean value 
	*/
	static boolean isMember(int[] list, int item, int startIndex)
	{
		if(startIndex >= list.length)  //if the item is not in the list return false 
		{
			return false;
		}		
		
		/*
		 * check if the starting index is the item we are looking for

		if not increment the starting value (using recursion)

		go through the whole list
		 */
		return item == list[startIndex] || isMember(list, item, startIndex+1); 
		
	}
	
	
	
	 /*
	
	 Purpose: returns the number of items (inclusive) starting from startIndex
	 all the way to the end.
	Preconditions: int[] list, and a int startIndex which should not be greater than the listlength
	Postconditions: returns the number of items in the list.
	 */
	static int numberItems(int[] list, int startIndex) 
	{
		
		if(startIndex == list.length) //base case once the start index be
		{
			return 1;
		}
		numberItems(list, startIndex + 1); //increment the list by adding one to the startindex in the recursive call
		
		return list.length - startIndex ; //return the number of items through subtraction
	}
	
	
	
	 /*
	 
	Purpose: returns the number of items (inclusive) starting from startIndex 
	all the way to the beginning.
	Preconditions: int[] list, int startIndex which should not be larger than the list length
	Postconditions: returns an integer for the number of items.
	 */
	static int numberItemsReverse(int[] list, int startIndex) 
	{
		
		if(startIndex <= 0) // base case return 1 once the start index reaches 0
		{
			return 1;
		}
		numberItemsReverse(list, startIndex -1); //recursive call and decrement the start index
		return startIndex + 1; //return startIndex
	}
	
	
	
	/* 
	Purpose: returns a count of how many times item appears in list (inclusive)
	starting from startIndex.
	Preconditions: int [] list, int item the item you are searching for, int startIndex
	Postconditions: returns an integer
	 */
	static int countItem(int[] list, int item, int startIndex) 
	{
	
	
		if(startIndex == list.length) //base case once the start index reaches the length of the list return 0
		{
			 return 0;
		}
		if(list[startIndex] == item)  // check the startindex with the item you are looking for
		{
			return 1 + countItem(list,item,startIndex + 1); // if the start index and the item are the same add 1 and increment the recursive call
		}
		else
			return 0 + countItem(list,item,startIndex + 1);// if they are not the same only add the incremented recursive call.
			
	
	
	}
	
	 /*
	Purpose: returns a new array containing the list items in reverse order. 
	The original list should remain unaltered.
	Preconditions: int[] list
	Postconditions: retruns an array of integers
	 */
	
			
	
	static int[] reverseList(int[] list)
	{
		int[] newList = new int[list.length]; //make new list for final return
		int[] decremList = Arrays.copyOf(list, list.length-1); 

		
		if(decremList.length == 0  ) // if the length of the list is 0 there is nothing to do return the list
		{
			return decremList;
		}

			int last = list[list.length-1]; // get the last item in the list

			
			
			int[] revList = reverseList(decremList); //save the reverse list using the recursive call
			

		
			for(int k = 1; k < newList.length-1;k++) // copy the values into the new list 
			{
				newList[k] = revList[k-1];
			}
			newList[0] = last;// set the last item as the first index in the new list
			
			
//			String newListPrint = Arrays.toString(newList);
//			System.out.println(newListPrint);
			return newList;
			
			
	}
	
	
	
	public static void main(String [ ] args)
	{
		Scanner sc = new Scanner(System.in);
//		System.out.println("Please choose a method 1-5");
		String input = sc.nextLine();
		int methodInput = Integer.parseInt(input);// integer which will determine which method to run
		
		if(methodInput == 1)
		{

			String line = sc.nextLine();
			String[] splitLine = line.split(" ");// split the list on each space
			int[] list = new int[splitLine.length -1];// makes a list based on items in the string array
			
			for(int i =0; i< splitLine.length-1; i++) // assigns values to the index of the list from string array
			{
				list[i] = Integer.parseInt(splitLine[i]);// converts values from string array to integers
			}
			int item = sc.nextInt();
			int startIndex = sc.nextInt();
			isMember( list, item, startIndex);
			System.out.print(isMember( list, item, startIndex));
		}
		else if(methodInput == 2)
		{
			String line = sc.nextLine();
			String[] splitLine = line.split("  ");
			int[] list = new int[splitLine.length-1];
			
			for(int i =0; i< splitLine.length-1; i++)
			{
				list[i] = Integer.parseInt(splitLine[i]);
			}
			
			int startIndex = sc.nextInt();
			numberItems( list,  startIndex);
			System.out.println(numberItems( list,  startIndex));
		}
		else if(methodInput == 3)
		{
			String line = sc.nextLine();
			String[] splitLine = line.split(" ");
			int[] list = new int[splitLine.length-1];
			
			for(int i =0; i< splitLine.length-1; i++)
			{
				list[i] = Integer.parseInt(splitLine[i]);
			}
		
			int startIndex = sc.nextInt();
			numberItemsReverse( list,  startIndex);
			System.out.println(numberItemsReverse( list,  startIndex));
		}
		else if(methodInput == 4)
		{
			String line = sc.nextLine();
			String[] splitLine = line.split(" ");
			int[] list = new int[splitLine.length-1];
			
			for(int i =0; i< splitLine.length-1; i++)
			{
				list[i] = Integer.parseInt(splitLine[i]);
			}
			int item = sc.nextInt();
			int startIndex = sc.nextInt();
			countItem( list, item,  startIndex);
			System.out.println(countItem( list, item,  startIndex));
		}
		else if(methodInput == 5)
		{
			String line = sc.nextLine();
			String[] splitLine = line.split(" ");
			int[] list = new int[splitLine.length-1];
			
			for(int i =0; i< splitLine.length-1; i++)
			{
				list[i] = Integer.parseInt(splitLine[i]);
			}
			reverseList( list);
			System.out.println(reverseList( list));
		}
		else 
		{
			System.out.print("invalid input");
		}
		
		
		
		
		
		
		
		
		
		
//		if(methodInput ==1)
//		{
////		System.out.println("is member \n");
//			
////		System.out.println("Enter length of array.");
//		int arrayLength = sc.nextInt();
//		int[] list = new int[arrayLength];
////		System.out.println("Enter elements.");
//		for(int i = 0; i <arrayLength;i++ )
//		{
//			list[i] = sc.nextInt();
//		}
//		
////		System.out.println("What item(int) are you looking for?");
//		int item = sc.nextInt();
////		System.out.println("What index in the array do you want to start?");
//		int startIndex = sc.nextInt();
//		
////		System.out.println(isMember( list, item, startIndex));
//		isMember( list, item, startIndex);
//		
//		}
//		else if(methodInput == 2)
//		{
////			System.out.println("number of items \n");
//			
////			System.out.println("Enter length of array.");
//			int arrayLength = sc.nextInt();
//			int[] list = new int[arrayLength];
////			System.out.println("Enter elements.");
//			for(int i = 0; i <arrayLength;i++ )
//			{
//				list[i] = sc.nextInt();
//			}
//			
////			System.out.println("What index in the array do you want to start?");
//			int startIndex = sc.nextInt();
//			
////			System.out.println(numberItems( list,  startIndex));
//			numberItems( list,  startIndex);
//		}
//		else if(methodInput == 3)
//		{
////			System.out.println("number of items reverse \n");
//					
////			System.out.println("Enter length of array.");
//			int arrayLength = sc.nextInt();
//			int[] list = new int[arrayLength];
////			System.out.println("Enter elements.");
//			for(int i = 0; i <arrayLength;i++ )
//			{
//				list[i] = sc.nextInt();
//			}
//			
////			System.out.println("What index in the array do you want to start?");
//			int startIndex = sc.nextInt();
//			
////			System.out.println(numberItemsReverse( list,  startIndex));
//			numberItemsReverse( list,  startIndex);
//		}
//		else if(methodInput == 4)
//		{
////			System.out.println("count item \n");
//			
////			System.out.println("Enter length of array.");
//			int arrayLength = sc.nextInt();
//			int[] list = new int[arrayLength];
////			System.out.println("Enter elements.");
//			for(int i = 0; i <arrayLength;i++ )
//			{
//				list[i] = sc.nextInt();
//			}
//			
////			System.out.println("What item(int) are you looking for?");
//			int item = sc.nextInt();
////			System.out.println("What index in the array do you want to start?");
//			int startIndex = sc.nextInt();
//			
////			System.out.println(countItem( list, item,  startIndex));
//			
//			countItem( list, item,  startIndex);
//		}
//		else if(methodInput == 5)
//		{
////			System.out.println("reverse list \n");
//			
////			System.out.println("Enter length of array.");
//			int arrayLength = sc.nextInt();
//			int[] list = new int[arrayLength];
////			System.out.println("Enter elements.");
//			for(int i = 0; i <arrayLength;i++ )
//			{
//				list[i] = sc.nextInt();
//			}
//			
////			System.out.println(reverseList( list));
//			reverseList( list);
//		}else
//			System.out.println("I said enter 1-5!! ");
//		

	}
}
