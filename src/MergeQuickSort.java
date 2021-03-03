import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;


public class MergeQuickSort {
     
    private int array[];
    private int length;
    private int mergeArray1[];
    
    private int compare;
    private long timeUsed = 0;
    long beginTime, endTime = 0;
	
    public static void main(String a[]){
         
    	// variables
    	
    	int size[] = {2000,4000,6000,8000,10000};
    	
        int randomArray1[] = new int[size[0]];
        int randomArray2[] = new int[size[1]];
		int randomArray3[] = new int[size[2]];
		int randomArray4[] = new int[size[3]];
		int randomArray5[] = new int[size[4]];
		
		int randomArraySpare1[] = new int[size[0]];
        int randomArraySpare2[] = new int[size[1]];
		int randomArraySpare3[] = new int[size[2]];
		int randomArraySpare4[] = new int[size[3]];
		int randomArraySpare5[] = new int[size[4]];
		
		int ascendArray1[] = new int[size[0]];
		int ascendArray2[] = new int[size[1]];
		int ascendArray3[] = new int[size[2]];
		int ascendArray4[] = new int[size[3]];
		int ascendArray5[] = new int[size[4]];
		
		int descendArray1[] = new int[size[0]];
		int descendArray2[] = new int[size[1]];
		int descendArray3[] = new int[size[2]];
		int descendArray4[] = new int[size[3]];
		int descendArray5[] = new int[size[4]];
		
		int descendArraySpare1[] = new int[size[0]];
        int descendArraySpare2[] = new int[size[1]];
		int descendArraySpare3[] = new int[size[2]];
		int descendArraySpare4[] = new int[size[3]];
		int descendArraySpare5[] = new int[size[4]];
		
		
		// initialization
		for(int i = 0 ; i< ascendArray1.length;i++)
		{
			ascendArray1[i] = i+1;
		}
		for(int i = 0 ; i< ascendArray2.length;i++)
		{
			ascendArray2[i] = i+1;
		}
		for(int i = 0 ; i< ascendArray3.length;i++)
		{
			ascendArray3[i] = i+1;
		}
		for(int i = 0 ; i< ascendArray4.length;i++)
		{
			ascendArray4[i] = i+1;
		}
		for(int i = 0 ; i< ascendArray5.length;i++)
		{
			ascendArray5[i] = i+1;
		}
		
		for(int i = descendArray1.length ; i > 0 ;i--)
		{
			descendArray1[descendArray1.length - i] = i;
		}
		for(int i = descendArray2.length ; i > 0;i--)
		{
			descendArray2[descendArray2.length - i] = i;
		}
		for(int i = descendArray3.length ; i > 0;i--)
		{
			descendArray3[descendArray3.length - i] = i;
		}
		for(int i =  descendArray4.length ; i>0;i--)
		{
			descendArray4[descendArray4.length - i] = i;
		}
		for(int i = descendArray5.length ; i > 0;i--)
		{
			descendArray5[descendArray5.length - i] = i;
		}
		
		for(int i = 0 ; i< randomArray1.length;i++)
		{
			randomArray1[i] = randomize(0,randomArray1.length);
		}
		for(int i = 0 ; i< randomArray2.length;i++)
		{
			randomArray2[i] = randomize(0,randomArray2.length);
		}
		for(int i = 0 ; i< randomArray3.length;i++)
		{
			randomArray3[i] = randomize(0,randomArray3.length);
		}
		for(int i = 0 ; i< randomArray4.length;i++)
		{
			randomArray4[i] = randomize(0,randomArray4.length);
		}
		for(int i = 0 ; i< randomArray5.length;i++)
		{
			randomArray5[i] = randomize(0,randomArray5.length);
		}
		
		
		//writing into file
		PrintWriter writer;
		try {
			writer = new PrintWriter("DataSetRecord.txt", "UTF-8");
			writer.println(Arrays.toString(ascendArray1));
			writer.println(Arrays.toString(descendArray1));
			writer.println(Arrays.toString(randomArray1));
			writer.println(Arrays.toString(ascendArray2));
			writer.println(Arrays.toString(descendArray2));
			writer.println(Arrays.toString(randomArray2));
			writer.println(Arrays.toString(ascendArray3));
			writer.println(Arrays.toString(descendArray3));
			writer.println(Arrays.toString(randomArray3));
			writer.println(Arrays.toString(ascendArray4));
			writer.println(Arrays.toString(descendArray4));
			writer.println(Arrays.toString(randomArray4));
			writer.println(Arrays.toString(ascendArray5));
			writer.println(Arrays.toString(descendArray5));
			writer.println(Arrays.toString(randomArray5));
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//spare copy
		System.arraycopy( randomArray1, 0, randomArraySpare1, 0, randomArray1.length );
		System.arraycopy( randomArray2, 0, randomArraySpare2, 0, randomArray2.length );
		System.arraycopy( randomArray3, 0, randomArraySpare3, 0, randomArray3.length );
		System.arraycopy( randomArray4, 0, randomArraySpare4, 0, randomArray4.length );
		System.arraycopy( randomArray5, 0, randomArraySpare5, 0, randomArray5.length );
		
		System.arraycopy( descendArray1, 0, descendArraySpare1, 0, descendArray1.length );
		System.arraycopy( descendArray2, 0, descendArraySpare2, 0, descendArray2.length );
		System.arraycopy( descendArray3, 0, descendArraySpare3, 0, descendArray3.length );
		System.arraycopy( descendArray4, 0, descendArraySpare4, 0, descendArray4.length );
		System.arraycopy( descendArray5, 0, descendArraySpare5, 0, descendArray5.length );
		
		//System.out.println(Arrays.toString(randomArraySpare1));
        MergeQuickSort merges1[] = new MergeQuickSort[15];
        
       //size 2k
        int w = 0;
        for (int i = 0; i< 15;i++)
        {
        	merges1[i] = new MergeQuickSort();
        }
        //System.out.println("Before mergesort asc : "+Arrays.toString(ascendArray1));
        //System.out.println("Before mergesort des: "+Arrays.toString(descendArray1));
        //System.out.println("Before mergesort ran: "+Arrays.toString(randomArray1));
        try {
            Thread.sleep(100);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        merges1[w].sort(ascendArray1);// solve inconsistency in nanotime by running once
        merges1[w].sort(ascendArray1);
        w++;
        merges1[w].sort(ascendArray2);
        w++;
        merges1[w].sort(ascendArray3);
        w++;
        merges1[w].sort(ascendArray4);
        w++;
        merges1[w].sort(ascendArray5);
        w++;
        merges1[w].sort(descendArray1);
        w++;
        merges1[w].sort(descendArray2);
        w++;
        merges1[w].sort(descendArray3);
        w++;
        merges1[w].sort(descendArray4);
        w++;
        merges1[w].sort(descendArray5);
        w++;
        
        merges1[w].sort(randomArray1);
        w++;
        merges1[w].sort(randomArray2);
        w++;
        merges1[w].sort(randomArray3);
        w++;
        merges1[w].sort(randomArray4);
        w++;
        merges1[w].sort(randomArray5);
        w++;
        
        //System.out.println("After mergesort asc: "+Arrays.toString(ascendArray1));
        //System.out.println("After mergesort des: "+Arrays.toString(descendArray1));
        //System.out.println("After mergesort ran: "+Arrays.toString(randomArray1));
        //System.out.println("Before quicksort asc : "+Arrays.toString(ascendArray1));
        //System.out.println("Before quicksort des: "+Arrays.toString(descendArraySpare1));
        //System.out.println("Before quicksort ran: "+Arrays.toString(randomArraySpare1));
		 QuickSort qs[] = new QuickSort[15];
		 int q = 0;
	      
		 	qs[q] = new QuickSort();
	        qs[q].sort(ascendArray1);// solve inconsistency in nanotime by running once
	        
	        qs[q].sort(ascendArray1);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(ascendArray2);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(ascendArray3);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(ascendArray4);
	        q++;

	        qs[q] = new QuickSort();
	        qs[q].sort(ascendArray5);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(descendArraySpare1);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(descendArraySpare2);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(descendArraySpare3);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(descendArraySpare4);
	        q++;

	        qs[q] = new QuickSort();
	        qs[q].sort(descendArraySpare5);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(randomArraySpare1);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(randomArraySpare2);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(randomArraySpare3);
	        q++;
	        
	        qs[q] = new QuickSort();
	        qs[q].sort(randomArraySpare4);
	        q++;

	        qs[q] = new QuickSort();
	        qs[q].sort(randomArraySpare5);
	        q++;
	        
	        //System.out.println("After quicksort asc : "+Arrays.toString(ascendArray1));
	        //System.out.println("After quicksort des: "+Arrays.toString(descendArraySpare1));
	        //System.out.println("After quicksort ran: "+Arrays.toString(randomArraySpare1));
	        
	        System.out.println("Size\t| CPU (μs)\t| Comparisons \t| Sorting Type \t| Data Type");
	        for(int i = 0 ; i < 5; i++)
	        {
	        	System.out.println(size[i%5]+"\t| "+merges1[i].getTimeUsed()/1000 +"\t\t|"+merges1[i].getCompare() +"\t\t| MergeSort \t| Ascending ");
	        	System.out.println(size[i%5]+"\t| "+qs[i].getTimeUsed()/1000 +"\t\t|"+qs[i].getCompare() +"\t\t| QuickSort \t| Ascending ");
	        	System.out.println(size[i%5]+"\t| "+merges1[i+5].getTimeUsed()/1000 +"\t\t|"+merges1[i+5].getCompare() +"\t\t| MergeSort \t| Descending ");
	        	System.out.println(size[i%5]+"\t| "+qs[i+5].getTimeUsed()/1000 +"\t\t|"+qs[i+5].getCompare() +"\t\t| QuickSort \t| Descending ");
	        	System.out.println(size[i%5]+"\t| "+merges1[i+10].getTimeUsed()/1000 +"\t\t|"+merges1[i+10].getCompare() +"\t\t| MergeSort \t| Random ");
	        	System.out.println(size[i%5]+"\t| "+qs[i+10].getTimeUsed()/1000 +"\t\t|"+qs[i+10].getCompare() +"\t\t| QuickSort \t| Random ");
	        	System.out.println("----------------------------------------------------------------------------------------------------");
	        }
	        
    } 	
    static int randomize(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

	public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.mergeArray1 = new int[length];
        this.compare = 0;
        
        
		
        beginTime = System.nanoTime();
        mergeSort(0, length - 1);
        endTime = System.nanoTime();
        setTimeUsed(endTime - beginTime);
    }
 
    private void mergeSort(int n, int m) {
         
        if (n < m) {
            int mid = n + (m - n) / 2;
            mergeSort(n, mid);//left
            mergeSort(mid + 1, m);//right
            merge(n, mid, m);//merge
        }
    }
 
    private void merge(int n, int mid, int m) {
 
        for (int i = n; i <= m; i++) {
            mergeArray1[i] = array[i]; // copy array to aux . now aux = array
        }
        int i = n; // first list
        int j = mid + 1;
        int k = n; // counter for aux list;
        while (i <= mid && j <= m) { // if within 1st and 2nd range 
        	compare++;
            if (mergeArray1[i] <= mergeArray1[j]) {//1st element in first half into aux
            	
                array[k] = mergeArray1[i];
                i++;
            } else {//1st element in 2nd half in aux
                array[k] = mergeArray1[j];
                j++;
            }
            k++;
        }
        while (i <= mid) { // combine remaining into aux
            array[k] = mergeArray1[i];
            k++;
            i++;
        }
 
    }

	public int getCompare() {
		return this.compare;
	}

	public long getTimeUsed() {
		return this.timeUsed;
	}

	public void setTimeUsed(long timeUsed) {
		this.timeUsed = timeUsed;
	}
    
    
}
