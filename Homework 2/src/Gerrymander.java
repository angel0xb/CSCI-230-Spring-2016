import java.util.Arrays;
import java.util.Scanner;
/*
Author: Angel Rodriguez
Date: February 9, 2016
Class: CSCI 230
Assignment: Homework 2
Task:  focus on understanding recursion through java implementation. Work on implementing 2D arrays.
Input:keybaord input is need from the user.
Output: boolean, integer, or an array.depending on the method 

Certification of Authenticity: 
 I certify that this code is entirely my own work. 

 */

public class Gerrymander {

	
/*
 Purpose: returns true if there is '*' in the left cell.
Preconditions: Enter a 2D array, row and col for index you are looking at.
Postconditions: returns boolean true if there is '*' in left cell otherwise return false.
 */
	
static boolean checkLeft(char[][] array, int row, int col)
{
	try{
	if(array[row][col-1]== '*') //checks the if the left cell is '*'.
	{
		return true;
	}
	return false;
	}
	catch(IndexOutOfBoundsException e)
	{
		return false;
	}
	
}




/*
Purpose: returns true if there is '*' in the right cell.
Preconditions: Enter a 2D array, row and col for index you are looking at.
Postconditions: returns boolean true if there is '*' in right cell otherwise return false.
*/

static boolean checkRight(char[][] array, int row, int col)
{
	try{
	if(array[row][col+1]== '*')// checks for '*' in right cell
	{
		return true;
	}
	return false;
	}
	catch(IndexOutOfBoundsException e)
	{
		return false;
	}
	
}



/*
Purpose: returns true if there is '*' in the cell above.
Preconditions: Enter a 2D array, row and col for index you are looking at.
Postconditions: returns boolean true if there is '*' in the cell above otherwise return false.
*/

static boolean checkTop(char[][] array, int row, int col)
{
	try{
	if(array[row-1][col]== '*')// checks the cell above for '*'
	{
		return true;
	}
	return false;
	}
	catch(IndexOutOfBoundsException e)
	{
		return false;
	}
	
}




/*
Purpose: returns true if there is '*' in the cell below.
Preconditions: Enter a 2D array, row and col for index you are looking at.
Postconditions: returns boolean true if there is '*' in the cell below otherwise return false.
*/
static boolean checkBot(char[][] array, int row, int col)
{
	try{
	if(array[row+1][col ]== '*')// checks cell below for '*'
	{
		return true;
	}
	return false;
	}
	catch(IndexOutOfBoundsException e)
	{
		return false;
	}
	
}




/*
Purpose: returns true if there is '*' in the given cell.
Preconditions: Enter a 2D array, row and col for index you are looking at.
Postconditions: retruns boolean true if there is '*' in cell otherwise return false.
*/
static boolean checkIndex(char[][] array, int row, int col)
{
	try{
		if(array[row][col ]== '*')// checks for '*' in cell
		{
			return true;
		}
		return false;
	}
	catch(IndexOutOfBoundsException e)
	{
		return false;
	}
	
}






/*
Purpose: replaces all '*' adjacent to the index with 'a'.
Preconditions: 2D array, row and col number for the index.
Postconditions: returns an array with 'a' in all adjacent cells to the index if they contain '*'
*/
static char[][] adjacentAsteriks(char[][] array, int row,int col )
// adds 'a' next to all adjacent aterisks  
{
	if( array[row][col] == ' ' || row < 0 || col < 0 || col > array[0].length ||  row > array.length  ) //base case there is no '*'
	{
		return array;	
	}
	
	if( checkIndex(array,row,col)) // checks the index for '*'
	{
		array[row][col] = 'a'; // replace '*' with 'a'
		
		if(checkLeft(array,row,col) == true)// if the left cell contains '*' recursive call with left cell as the index
		{
			adjacentAsteriks(array, row,col-1);
		}
		
		
		if(checkRight(array,row,col) == true)// if the right cell contains '*' recursive call with right cell as the index
		{
			adjacentAsteriks(array, row,col+1);
		}
		
		
		if(checkTop(array,row,col) == true)// if the cell above contains '*' recursive call with the cell above as the index
		{
			adjacentAsteriks(array, row-1,col);
		}
		
		
		if(checkBot(array,row,col) == true)// if the cell below contains '*' recursive call with the cell below as the index
		{
			adjacentAsteriks(array, row+1,col);
		}
		
		
	
		
	}
	return array;
	
}




/*
Purpose: removes all 'a'
Preconditions:2D array
Postconditions: returns the list with no 'a'
*/
static char[][] removeA(char[][] array)
{
	for(int row = 0; row< array.length;row++)
	{
		for(int col = 0; col < array[row].length;col++) // iterate through all rows and columns
		{
			if(array[row][col] == 'a') // replaces all 'a' with empty space.
			{
				array[row][col] = ' ';
			}
		}
	}
	return array;
	
}





/*
Purpose: tells you if there are any 'a' in a 2D array.
Preconditions: takes in a 2D array.
Postconditions: returns true if there are any 'a' and false if there are not any
*/
static boolean containsA(char[][] array)
{
	for(int row = 0; row< array.length;row++)
	{
		for(int col = 0; col < array[row].length;col++) // iterate through rows and columns
		{
			if(array[row][col] == 'a')
			{
				return true;
			}
		}
	}
	return false;
	
}





/*
Purpose: tells you whether the 1D array contains '*'
Preconditions: takes in 1D array
Postconditions: returns true if there is a '*' in the list false otherwise
*/
static boolean oneDContainsAsterik(char[] array)
{
	for(int i = 0; i < array.length;i++) // iterate through list
	{
		if(array[i] == '*')// if there is a '*' return true
			return true;
	}
	return false;
}





/*
Purpose: tells you whether the 2D array contains '*'
Preconditions: takes in 2D array
Postconditions: returns true if there is a '*' in the list false otherwise
*/
static boolean containsAsterik(char[][] array)
{
	for(int row = 0; row< array.length;row++)
	{
		for(int col = 0; col < array[row].length;col++)// iterate through 2D array
		{
			if(array[row][col] == '*') // return true if there is '*'
			{
				return true;
			}
		}
	}
	return false;
	
}




/*
Purpose: turns a 2D array into a 1D array.
Preconditions: takes in a 2D array.
Postconditions: returns a 1D array filled with the elements in the 2d array
*/
static char[] oneDemArray(char[][] array)
{
	 char[] oneDArray = new char[array.length*array[0].length];// make an array the size of the 2D array
	 
     for(int i = 0; i < array.length; i++) {
    	 
         char[] row = array[i];
         
         for(int j = 0; j < row.length; j++) {
        	 
             char cell = array[i][j];
             oneDArray[i*row.length+j] = cell; // copy values into one D array
         }
     }
     return oneDArray;
}







/*
Purpose: turns a 1D array into a 2D array.
Preconditions: takes in a 1D array and the amount of rows and columns
Postconditions: returns a 2D array filled with the elements in the 1d array
*/
public static char[][] twoDemArray( char[] array,int rows ,int cols ) {
    if (array.length != rows*cols)
    {
        throw new IllegalArgumentException("Invalid array length");
    }

    char[][] twoD = new char[rows][cols];
    for ( int i = 0; i < rows; i++ )
    {
        System.arraycopy(array, i*cols, twoD[i], 0, cols); // copy elements into the 2d array
    }
    return twoD;
}





/*
Purpose: adds element in 1D array
Preconditions: takes in an array, char you want to add to array, and index where in the array you want to add
Postconditions: returns the array with new element added.
*/
static char[] addElement(char[] original, char added, int index ) {
	
	if(index+1 > original.length)
	{
	int increase = index+1 - original.length;// gets the amount you want to increase the size of the array by
    char[] result = Arrays.copyOf(original, original.length + increase);//copy list with space needed
    result[index] = added; //add item
    
    return result;
	}

	
	
	char[] result =Arrays.copyOf(original, original.length ); // copy list
    result[index] = added;//add item
    
    return result;
}






/*
Purpose: converts 1d index into a 2d index
Preconditions: index you are looking  at and the number of columns
Postconditions: returns a string that contains the "rows,columns"
*/
static String getIndex(int oneDIndex,int col)
{
	int c = oneDIndex % col;// get columns
	int r = oneDIndex / col;//get rows
	return r + "," + c;
}




/*
Purpose: returns the number of districts in 2D grid
Preconditions: takes in 1D array, index and number of rows and cols.
Postconditions: returns the number of districts
*/
static int countDistrictsRecursive(char[] oneDArray,int index,int rows,int cols)
{
	String[] string = (getIndex(index,cols)).split(",");
	int indexRow = Integer.parseInt(string[0]);//get the rows
	int indexCol = Integer.parseInt(string[1]);//get the cols
	
	if(oneDContainsAsterik(oneDArray) == false)// if there are no'*' return 0
	{
		return 0;
	}
	
	if(containsA(adjacentAsteriks(twoDemArray(oneDArray,rows,cols),indexRow,indexCol)))//if there are any 'a' add 1, increment index recursive call  
	{
		
		return 1 + countDistrictsRecursive(oneDemArray(removeA(adjacentAsteriks(twoDemArray(oneDArray,rows,cols),indexRow,indexCol))),index+1,rows, cols);
	}
	
	
	return 0 + countDistrictsRecursive(oneDArray,index +1,rows,cols); //return the number of districts.
}



	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int methodInput = Integer.parseInt(input);//get the input
		
		
		if(methodInput == 1)//first input
		{
			String rowCols = sc.nextLine();
			String[] splitRowCols = rowCols.split(" "); 
			int rows = Integer.parseInt(splitRowCols[0]);//get rows
			int cols = Integer.parseInt(splitRowCols[1]);//get cols
			
			char[] array = new char[rows * cols];//create array from row and cols
	
			
			String asteriks = sc.nextLine();
			String[] splitAsteriks = asteriks.split(" ");

			
			int index = 0;
			
				while(Integer.parseInt(splitAsteriks[index]) !=  -1) // go through the list until you get a -1
				{
					
//					
					
				int addAsterik = Integer.parseInt(splitAsteriks[index]);
				array = addElement(array,'*', addAsterik);// add '*' base on input value

				index++;
				
			}
			
			sc.close();
			 System.out.println(countDistrictsRecursive(array,0,rows,cols));
			
			 
		}
		else
		{
			System.out.println("no extra credit :(");
		}
		
		
			
		
	}

}
