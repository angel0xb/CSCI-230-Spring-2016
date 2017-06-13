import java.util.Arrays;
import java.util.Scanner;

/*
Author: Angel Rodriguez
Date: April 27, 2016
Class: CSCI 230
Assignment: Homework 5
Task: Studying the time complexity of different sorting algorithms and when is the best to use each.
Output: int[], string,

Certification of Authenticity: 
 I certify that this code is entirely my own work. 

 */
public class compareSorts {
	
	/*
	 Purpose:swap two indexes in an array
	Preconditions: none
	Postconditions:  the two indexes are swapped.
	 */
	private static void swap(int[] arr,int i, int j ) {
		   int t = arr[i];
		   arr[i] = arr[j];
		   arr[j] = t;
		
		}
	
	/*
	 Purpose: sort array using the merge sort algorithm
	Preconditions: give a list.
	Postconditions:  array is now sorted
	 */
	  public static void mergesort(int [] a)
	    {
		  //insertion sort is quicker when list size is lower than 80
		  if(a.length < 80)
		  {
			  insertionSort(a);
		  }
	        // create space for temp array used during merging
	        int [] temp = new int[a.length];  
	        
	        // ...and, sort it recursively
	        mergesort(a, temp, 0, a.length-1);   
	    }
	    
	    private static void mergesort(int [] a, int [] temp, int left, int right)
	    {
	        if (left < right)   // more remaining to sort?
	        {
	            int center = (left + right) / 2;
	            
	            mergesort(a, temp, left, center);    // sort left part
	            mergesort(a, temp, center+1, right); // sort right part
	            
	            // copy partially sorted a[] to temp[]
	            for (int i = left; i <= right; i++)
	                temp[i] = a[i];
	            
	            // merge the two partially sorted parts back into a[]
	            int i1 = left;      // index into left sorted part
	            int i2 = center+1;  // index into right sorted part
	            
	            for (int current = left; current <= right; current++)
	            {
	                if (i1 == center+1)   // left list exhausted?
	                {
	                    // copy next item from right list into a[]
	                    a[current] = temp[i2];
	                    i2++;   // and point to next item in right list (if any)
	                }
	                else if (i2 > right)  // right list exhausted?
	                {
	                    // copy next item from left list into a[]
	                    a[current] = temp[i1];
	                    i1++;   // and point to next item in left list (if any)
	                }
	                // or, if both lists still have items, find the smallest
	                // next item (from left or right) and copy it in a[]
	                else if (temp[i1] < temp[i2])    // left item is smaller?
	                {
	                    a[current] = temp[i1];
	                    i1++;   // and point to next item in left list (if any)
	                }
	                else    // right item is smaller
	                {
	                    a[current] = temp[i2];
	                    i2++;   // and point to next item in right list (if any)
	                }
	            }
	            
	        }
	    }
		/*
		 Purpose: sort array using the quicksort algorithm
		Preconditions: give a list.
		Postconditions:  array is now sorted
		 */
	    public static void quicksort(int[] a)
	    {
	    	  //insertion sort is quicker when list size is lower than 25
	    	if(a.length < 25)
	    	{
	    		insertionSort(a);
	    	}
	    	quicksort(a,0,a.length-1);
	    	
	    }
	    private static void quicksort(int [] a, int left, int right) 
	    {
	        if (left < right)    // more remaining to sort?
	        {
	           // pick value at middle index as pivot
	           int pivot = a[ (left+right)/2 ];
	           
	           // get partitions
	           int i = left;
	           int j = right;

	           // create partitions by moving larger items to right,
	           // and smaller items to left partition
	           while (i < j) 
	           {
	               // keep moving i until we find an item that belongs
	               // on the other side
	               while (a[i] < pivot)
	                  i++;
	               // now, i points to first item >= pivot value
	            
	               // keep moving j until we find an item that belongs
	               // on the other side
	               while (a[j] > pivot)
	                  j--;
	               // now, j points to first item <= pivot value
	            
	               if (i <= j)  // haven't crossed yet
	               {
	                  swap(a, i, j);
	                  i++;
	                  j--;
	               }
	           }
	           // now, the two partitions have been created
	           
	           // sort them
	           quicksort(a, left, j);
	           quicksort(a, i, right);
	           
	        }
	    }
		/*
		 Purpose: sort array using the insertion sort algorithm
		Preconditions: give a list.
		Postconditions:  array is now sorted
		 */
	    public static void insertionSort(int[]a){
	    	for(int separator = 1; separator< a.length;separator++)
	    	{
	    	int valueToInsert = a[separator];//value to insert into part
	    	int j = separator - 1;//last item in list
	    	
	    	while(j >= 0 && valueToInsert<a[j])
	    	{
	    		a[j+1] = a[j];//shift items to right creating empty slot for value to insert
	    		j--;//points to previous sorted value
	    	}
	    	a[j+1] = valueToInsert;// insert it
	    	}
	    }
	    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		// number of input lines taken
		int methodInput = Integer.parseInt(line); //method that should be ran

		
		if(methodInput < 0)
		{
			int listSize = (int)(Math.random()*100 +10);//get a random list size 10-100
//			int listSize = 45;
			int[] list = new int[listSize];//construct an empty list with random size
			
			System.out.println("\n list size: "+ listSize +"\n");
			
			for (int i1=0; i1<list.length; i1++)
			{
		        int n = (int)(Math.random()*1000 + 0); //fill list with random values from 0-1000
		        list[i1] = n;//fill list with random values from 0-1000
			}
			
			methodInput = Math.abs(methodInput); //get absolute value for method
			
			if(methodInput == 1)
			{
				for(int i =0; i < list.length;i++)//print out list
				{
					System.out.print(list[i] + " ");
				}
				System.out.println();
				long startTime = System.nanoTime();   // start timing

				insertionSort(list);

				long endTime = System.nanoTime();    // end timing
				double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
				
				for(int i =0; i < list.length;i++)//print out sorted list
				{
					System.out.print(list[i] + " ");
				}
				System.out.println();
				
				System.out.println("Sorting by insertionsort took " + runtimeInMilliseconds +" milliseconds...");
			}
			
			if(methodInput == 2)
			{
				for(int i =0; i < list.length;i++)//print out list
				{
					System.out.print(list[i] + " ");
				}
				System.out.println();
				long startTime = System.nanoTime();   // start timing

				mergesort(list);
				

				long endTime = System.nanoTime();    // end timing
				double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
				
				for(int i =0; i < list.length;i++)//print out sorted list
				{
					System.out.print(list[i] + " ");
				}
				System.out.println();
				System.out.println("Sorting by mergesort took " + runtimeInMilliseconds +" milliseconds...");
				
			}
			
			if(methodInput == 3)
			{
				for(int i =0; i < list.length;i++)//print out list
				{
					System.out.print(list[i] + " ");
				}
				System.out.println("end of list");
				System.out.println();
				long startTime = System.nanoTime();   // start timing

				quicksort(list); 
				
				long endTime = System.nanoTime();    // end timing
				
				for(int i =0; i < list.length;i++)//print out sorted list
				{
					System.out.print(list[i] + " ");
				}
				System.out.println();
				
				double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
				
				System.out.println("Sorting by quicksort took " + runtimeInMilliseconds +" milliseconds...");
			}
			
			if(methodInput > 3)
			{
				//save list into 3 different list to be sorted with different methods 
				int[] list1 = list;
				int[] list2 = list;
				int[] list3 = list;
				
				for(int i =0; i < list.length;i++)//print out list
				{
					System.out.print(list1[i] + " ");
				
				}
				System.out.println();
				
				long startTime = System.nanoTime();   // start timing

				insertionSort(list1); 
				
				long endTime = System.nanoTime();    // end timing
				
				for(int i =0; i < list1.length;i++)//print out sorted list
				{
					System.out.print(list1[i] + " ");
				}
				System.out.println();
				
				double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
				
				System.out.println("Sorting by insertionsort took " + runtimeInMilliseconds +" milliseconds...");
				System.out.println();
				
				long startTime2 = System.nanoTime();   // start timing
				
				mergesort(list2); 
				
				long endTime2 = System.nanoTime();    // end timing
				
				for(int i =0; i < list2.length;i++)//print out sorted list
				{
					System.out.print(list2[i] + " ");
				}
				System.out.println();
				
				double runtimeInMilliseconds2 = (double)(endTime2 - startTime2) / 1000000.0;
				
				System.out.println("Sorting by mergesort took " + runtimeInMilliseconds2 +" milliseconds...");
				System.out.println();
				
				long startTime3 = System.nanoTime();   // start timing
				
				quicksort(list3); 
				
				long endTime3 = System.nanoTime();    // end timing
				
				for(int i =0; i < list3.length;i++)//print out sorted list
				{
					System.out.print(list3[i] + " ");
				}
				System.out.println();
				
				double runtimeInMilliseconds3 = (double)(endTime3 - startTime3) / 1000000.0;
				
				System.out.println("Sorting by quicksort took " + runtimeInMilliseconds3 +" milliseconds...");
			}
			
			//End of negative method
		}
		
		if(methodInput == 1)
		{
			String size = sc.nextLine();// next line contains the size
			String[] sizeSplit = size.split(" "); 
			int listSize = Integer.parseInt(sizeSplit[0]);//save the size of list
			int[] list = new int[listSize];//construct the list
			
			if(listSize <=1)//if list size is <= 1 then there is nothing to sort
			{
				throw new Exception(" give me soemthing I can sort!");
			}
			
			String vals = sc.nextLine();//next line contains the values that will be inserted to list
			String[] arrVals = vals.split(" ");//values now array of strings
			for(int i1 = 0; i1 < arrVals.length;i1++)
			{
				list[i1] = Integer.parseInt(arrVals[i1]); //fill list with values from input
			}
			
			for(int i =0; i < list.length;i++)//print out list
			{
				System.out.print(list[i] + " ");
			}
			System.out.println();
			long startTime = System.nanoTime();   // start timing

			insertionSort(list);

			long endTime = System.nanoTime();    // end timing
			double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
			
			for(int i =0; i < list.length;i++)//print out sorted list
			{
				System.out.print(list[i] + " ");
			}
			System.out.println();
			
			System.out.println("Sorting by insertionsort took " + runtimeInMilliseconds +" milliseconds...");
			
		}
		if(methodInput == 2)
		{
			String size = sc.nextLine();// next line contains the size
			String[] sizeSplit = size.split(" "); 
			int listSize = Integer.parseInt(sizeSplit[0]);//save the size of list
			int[] list = new int[listSize];//construct the list
			if(listSize <=1)//if list size is <= 1 then there is nothing to sort
			{
				throw new Exception(" give me soemthing I can sort!");
			}
			
			String vals = sc.nextLine();//next line contains the values that will be inserted to list
			String[] arrVals = vals.split(" ");//values now array of strings
			for(int i1 = 0; i1 < arrVals.length;i1++)
			{
				list[i1] = Integer.parseInt(arrVals[i1]); //fill list with values from input
			}
			
			for(int i =0; i < list.length;i++)//print out list
			{
				System.out.print(list[i] + " ");
			}
			System.out.println();
			long startTime = System.nanoTime();   // start timing

			mergesort(list);
			

			long endTime = System.nanoTime();    // end timing
			double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
			
			for(int i =0; i < list.length;i++)//print out sorted list
			{
				System.out.print(list[i] + " ");
			}
			System.out.println();
			System.out.println("Sorting by mergesort took " + runtimeInMilliseconds +" milliseconds...");
			
		}
		//any input method that is 3 or greater will do quick sort
		if(methodInput == 3)
		{
			String size = sc.nextLine();// next line contains the size
			String[] sizeSplit = size.split(" "); 
			int listSize = Integer.parseInt(sizeSplit[0]);//save the size of list
			int[] list = new int[listSize];//construct the list
			
			if(listSize <=1)//if list size is <= 1 then there is nothing to sort
			{
				throw new Exception(" give me soemthing I can sort!");
			}
			
			String vals = sc.nextLine();//next line contains the values that will be inserted to list
			String[] arrVals = vals.split(" ");//values now array of strings
			
			for(int i1 = 0; i1 < arrVals.length;i1++)
			{
				list[i1] = Integer.parseInt(arrVals[i1]); //fill list with values from input
			}
			
			for(int i =0; i < list.length;i++)//print out list
			{
				System.out.print(list[i] + " ");
			}
			System.out.println();
		
			long startTime = System.nanoTime();   // start timing

			quicksort(list); 
			
			long endTime = System.nanoTime();    // end timing
			
			for(int i =0; i < list.length;i++)//print out sorted list
			{
				System.out.print(list[i] + " ");
			}
			System.out.println();
			
			double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
			
			System.out.println("Sorting by quicksort took " + runtimeInMilliseconds +" milliseconds...");
			
		}
	if(methodInput > 3)//if input method is greater than 3 run all three sorts
	{
		String size = sc.nextLine();// next line contains the size
		String[] sizeSplit = size.split(" "); 
		int listSize = Integer.parseInt(sizeSplit[0]);//save the size of list
		int[] list = new int[listSize];//construct the list
		
		String vals = sc.nextLine();//next line contains the values that will be inserted to list
		String[] arrVals = vals.split(" ");//values now array of strings
		
		for(int i1 = 0; i1 < arrVals.length;i1++)
		{
			list[i1] = Integer.parseInt(arrVals[i1]); //fill list with values from input
		}
		
		//save list into 3 different list to be sorted with different methods 
		int[] list1 = list;
		int[] list2 = list;
		int[] list3 = list;
		
		for(int i =0; i < list.length;i++)//print out list
		{
			System.out.print(list1[i] + " ");
		
		}
		System.out.println();
		
		long startTime = System.nanoTime();   // start timing

		insertionSort(list1); 
		
		long endTime = System.nanoTime();    // end timing
		
		for(int i =0; i < list1.length;i++)//print out sorted list
		{
			System.out.print(list1[i] + " ");
		}
		System.out.println();
		
		double runtimeInMilliseconds = (double)(endTime - startTime) / 1000000.0;
		
		System.out.println("Sorting by insertionsort took " + runtimeInMilliseconds +" milliseconds...");
		System.out.println();
		
		long startTime2 = System.nanoTime();   // start timing
		
		mergesort(list2); 
		
		long endTime2 = System.nanoTime();    // end timing
		
		for(int i =0; i < list2.length;i++)//print out sorted list
		{
			System.out.print(list2[i] + " ");
		}
		System.out.println();
		
		double runtimeInMilliseconds2 = (double)(endTime2 - startTime2) / 1000000.0;
		
		System.out.println("Sorting by mergesort took " + runtimeInMilliseconds2 +" milliseconds...");
		System.out.println();
		
		long startTime3 = System.nanoTime();   // start timing
		
		quicksort(list3); 
		
		long endTime3 = System.nanoTime();    // end timing
		
		for(int i =0; i < list3.length;i++)//print out sorted list
		{
			System.out.print(list3[i] + " ");
		}
		System.out.println();
		
		double runtimeInMilliseconds3 = (double)(endTime3 - startTime3) / 1000000.0;
		
		System.out.println("Sorting by quicksort took " + runtimeInMilliseconds3 +" milliseconds...");
	}
	    
	}

}
