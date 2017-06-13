import java.util.Scanner;
/*
Author: Angel Rodriguez
Date: March 1, 2016
Class: CSCI 230
Assignment: Homework 3
Task: construct a DNA structure through designing and implementing a linked-list ADT in Java.
Output: boolean, integer, or String .depending on the method 

Certification of Authenticity: 
 I certify that this code is entirely my own work. 

 */

public class DNA {
	/*
	 Purpose: construct a Nucleotide which functions similar to a node.
	Preconditions:
	Postconditions:  Nucleotide with base, next and across attributes.
	 */
private class Nucleotide{
	Character base;
	Nucleotide next;
	Nucleotide across;
}
Nucleotide leftHelix;
Nucleotide rightHelix;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
int numElements; //logical length of list
/*
Purpose: construct DNA which functions similarly to a linked list
Preconditions: none
Postconditions:  constructs a list of Nucleotides
*/
public DNA()
{
	this.leftHelix = new Nucleotide(); // Beginning of the left list
	this.leftHelix.next = null; //dummy header Nucleotide for leftHelix
//	this.leftHelix.across = null;
	
	this.rightHelix = new Nucleotide();// Beginning of the right list
	this.rightHelix.next = null;//dummy header Nucleotide for rightHelix
	
	Nucleotide acrossLeft = this.leftHelix.across;
	Nucleotide acrossRight = this.rightHelix.across ;
	
	this.rightHelix.across = this.leftHelix; //link the two Nucs to each other
	this.leftHelix.across = this.rightHelix;
	
	this.numElements = 0; // logical length of list
}



/*
Purpose: construct DNA which functions similarly to a linked list
Preconditions: none
Postconditions:  constructs a list of Nucleotides
*/
public void insert( int index, String basePair) throws Exception
{
	//check if index is valid
	if(index < 0 || index > numElements)
	{
		throw new IndexOutOfBoundsException();
	}
	//check to see if base pair is valid
	if(validBasePair(basePair) == false)
	{
		throw new Exception("invalid base pair");
	}
	
	//create and populate a two new nucleotide since they must be in pairs
	
	Nucleotide leftNuc = new Nucleotide();
	leftNuc.base = basePair.charAt(0);
	
	Nucleotide rightNuc = new Nucleotide(); 
	rightNuc.base = basePair.charAt(1) ;
	
	Nucleotide pLeft = this.leftHelix; //initialize pointers for list traversal
	Nucleotide pRight = this.rightHelix;
	for(int i= -1; i < index - 1;i++)
	{
		pLeft = pLeft.next;
		pRight = pRight.next;
	}
	//insert the item
	leftNuc.next = pLeft.next;
	rightNuc.next = pRight.next;
	
	pLeft.next = leftNuc;
	pRight.next = rightNuc;
	this.numElements++; //increment number of elements
}


/*
Purpose: removes item at given index, returns base pair that is removed
Preconditions: must be greater than zero and less than the length of the DNA
Postconditions: index given is removed and length is decreased by 1
*/
String remove(int index) throws Exception
{
	
	//check if valid
	if(index < 0 || index > numElements)
	{
		throw new IndexOutOfBoundsException();
	}
	Nucleotide pLeft = this.leftHelix; //initialize pointers for list traversal
	Nucleotide pRight = this.rightHelix;
	
	for(int i = 0; i < index;i++) //traverse through the list
	{
		pLeft = pLeft.next;
		pRight = pRight.next;
	}
	
	Nucleotide tempLeft = pLeft.next; // Nucleotides to be removed
	Nucleotide tempRight = pRight.next;
	
	pLeft.next = tempLeft.next;
	pRight.next = tempRight.next;
	
	tempLeft.next = null; //break the link
	tempRight.next = null;
	this.numElements = this.numElements-1;//reduce size by 1
	
	//return base pair removed
	return Character.toString(tempLeft.base) + Character.toString(tempRight.base);
}



/*
Purpose: print items in the DNA
Preconditions: start index and end index must be given
Postconditions: prints items in the list
*/
void print(int startIndex, int endIndex) throws Exception
{
	//check if index is ok
	
	if( startIndex > endIndex)
	{
		int temp = startIndex;
		startIndex = endIndex;
		endIndex = temp;
	}
	if(startIndex < 0 || endIndex < 0 || startIndex > numElements  || endIndex > numElements  )
	{
		throw new IndexOutOfBoundsException();
	}
 //index will be the amount of times we want to increment
	
	Nucleotide pLeft = this.leftHelix.next;
	Nucleotide pRight = this.rightHelix.next;
	
	if(isEmpty() == false)
	{
	for(int i= startIndex; i < endIndex  ;i++) //endIndex is excluded
	{
	System.out.print( pLeft.base  ); // print the left and then the right helix character
	System.out.print( pRight.base  ); // print the left and then the right helix character
	pLeft = pLeft.next;// move to the next index
	pRight = pRight.next;
	}
	System.out.println("");
	}
	else
		System.out.print("");
}


/*
Purpose: makes the list empty
Preconditions: none
Postconditions: empty list
*/
void clear()
{
//	this.leftHelix =null;
	this.leftHelix.next = null;
//	this.rightHelix = null;
	this.rightHelix.next = null;
	this.numElements = 0;
}


/*
Purpose: returns true if list is empty and false if it is not
Preconditions: none
Postconditions: 
*/
boolean isEmpty()
{
	return this.numElements == 0;
}


/*
Purpose: give the size of the list
Preconditions: none
Postconditions: returns the size of the list
*/
int getLength()
{
	return this.numElements;
}


/*
Purpose: searches list for a base pair
Preconditions: base pair must be given
Postconditions:  returns the index the base pair is found at
*/
int find(String basePair) throws Exception
{
	//check to see if base pair is valid
	if(validBasePair(basePair) == false)
	{
		throw new Exception("invalid base pair");
	}
	Nucleotide pLeft = this.leftHelix.next;
	Nucleotide pRight = this.rightHelix.next;
	
	int count = 0;
	
	
	//checks to see if the characters are equal to the one we are searching for 
	while(pLeft.base != basePair.charAt(0) || pRight.base != basePair.charAt(1)) 
	{
		if(count == this.numElements -1	)
		{
			return -1;
		}
		count++;
		pLeft = pLeft.next;// move to the next index
		pRight = pRight.next;
		
	}
	
	return count ;
	
}

/*
Purpose: gives all items in the left Helix
Preconditions: none
Postconditions:  returns items in left Helix
*/
void printLeft()
{
	Nucleotide pLeft = this.leftHelix.next;

	// prints base until end of list
	while(pLeft != null) 
	{
		System.out.print(pLeft.base);
		pLeft = pLeft.next;
	}
	System.out.println("");
}


/*
Purpose: gives all items in the right Helix
Preconditions: none
Postconditions:  returns items in right Helix
*/
void printRight()
{
	Nucleotide pRight = this.rightHelix.next;

	while(pRight != null)
	{
		System.out.print(pRight.base);
		pRight = pRight.next;
	}
	System.out.println("");
}


/*
Purpose: checks to see if given base pairs are valid
Preconditions: string basePair must be given
Postconditions:  returns a boolean 
*/
static boolean validBasePair(String basePair)
{
	
	String[] split = basePair.split("");
	if(split[0].equals("A")  && split[1].equals("T"))
	{
		return true;
	}
	if(split[0].equals("T")  && split[1].equals("A"))
	{
		return true;
	}
	if(split[0].equals("C")  && split[1].equals("G"))
	{
		return true;
	}
	if(split[0].equals("G")  && split[1].equals("C"))
	{
		return true;
	}
	else{
		return false;
	}
}

/*
Purpose: prints item at index 
Preconditions: index an helix must be given
Postconditions:  returns base pair if helix is zero start at left if helix is 1 start at right
*/
void printBasePair(int index,int helix) throws Exception
{
	//check if valid
	if(index < 0 || index > numElements)
	{
		throw new IndexOutOfBoundsException();
	}
	if(helix > 1)
	{
		throw new Exception("helix out of bounds");
	}
	Nucleotide pLeft = this.leftHelix.next;
	Nucleotide pLeftAcross = pLeft.across;
	Nucleotide pRight = this.rightHelix.next;
	Nucleotide pRightAcross = pRight.across;
	
	for(int i =0; i< index - 1; i++)
	{
		pLeft = pLeft.next;
		pLeftAcross = pLeftAcross.next;
		pRight = pRight.next;
		pRightAcross = pRightAcross.next;
	}
	
	if(helix == 0)
	{
		System.out.print(pLeft.base);
	
//		System.out.println(pLeftAcross);
		System.out.println(pRight.base);
	}
	if(helix == 1)
	{
		System.out.print(pRight.base);
//		System.out.println(pRight.across);
		System.out.println(pLeft.base);
	}
	else
	{
	//error	
	}
}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DNA m = new DNA();
		
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		// number of input lines taken
		int numOfLines = Integer.parseInt(line);
		for(int i = 0; i < numOfLines;i++)
		{
		String methodLine = sc.nextLine();
		String[] splitMethodLine = methodLine.split(" ");
		
		int methodInput = Integer.parseInt(splitMethodLine[0]); //method that should be ran
		
	
		
		if(methodInput == 1)
		{
			int index = Integer.parseInt(splitMethodLine[1]);
			String basePair = splitMethodLine[2];
			
			try
			{
			m.insert(index, basePair);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		if(methodInput == 2)
		{
			int index = Integer.parseInt(splitMethodLine[1]);
			try
			{
				
			System.out.println(m.remove(index));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(methodInput == 3)
		{
			int startIndex = Integer.parseInt(splitMethodLine[1]);
			int endIndex = Integer.parseInt(splitMethodLine[2]);
			
			try
			{
			m.print(startIndex, endIndex);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(methodInput == 4)
		{
			m.clear();
		}
		if(methodInput == 5)
		{
			m.isEmpty();
		}
		if(methodInput == 6)
		{
			System.out.println(m.getLength());
		}
		if(methodInput == 7)
		{
			String basePair = splitMethodLine[1];
			try
			{
			System.out.println(m.find(basePair));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(methodInput == 8)
		{
		m.printLeft();	
		}
		if(methodInput == 9)
		{
			m.printRight();
		}
		if(methodInput == 10)
		{
			int index = Integer.parseInt(splitMethodLine[1]);
			int helix = Integer.parseInt(splitMethodLine[2]);
			
			try
			{
				m.printBasePair(index, helix);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		}
		
		

	}

}
