import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

public class MergeQuickSort{
    int[] arr ;
	int s= 100;
    private static int compare;
    private long timeUsed = 0;
    long beginTime, endTime = 0;
	
    public static void main(String[]args){
       
        Random rd = new Random(); // creating Random object
        int[] arr = new int[1000];
        
        for (int i = 0; i < arr.length; i++) {
           arr[i] = rd.nextInt(); // storing random integers in an array
        }

        PrintWriter writer;
		try {
			writer = new PrintWriter("DataSetRecord.txt", "UTF-8");
			
			writer.println(Arrays.toString(arr));
			
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//spare copy

		
		
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
        
        merges1[w].sort(arr);
        w++;

       

        System.out.println("\t| "+merges1[0].getTimeUsed()/1000 + "\t\t|"+merges1[0].getCompare() + "\t\t| MergeSort + insertionsort \t| Random ");
		
    }

    public void sort(int arr2[]) {
        this.arr= arr2;
        this.compare = 0;
		
		
        beginTime = System.nanoTime();
        mergeSort(arr,0,arr.length,s);
        endTime = System.nanoTime();
        setTimeUsed(endTime - beginTime);
    }


static void mergeSort(int arr1[],int first, int last,int s){
    //termination reached when a segment of size 1 reached -lb+1=ub
    if (first-last>s) {
        int mid = first + (first - last) / 2;
        mergeSort(arr1,first, mid,s);//left
        mergeSort(arr1,mid + 1, last,s);//right
        merge(arr1,first, mid, last);//merge
    }
    else{
        insertionSort(arr1,first, last);
    }
}

static void merge (int arr1[],int p, int q, int r){
    //p<=q<=r
    int i =p; int j = q; 
    //use temp array to store merged sub-sequence
    int temp[] = new int[r-p]; int t = 0; 
    while(i<q && j<r){
		compare++;
   
        if(arr1[i]<=arr1[j]){
            temp[t] =arr1[i]; 
            i++;t++;
        }
        else{
            temp[t] = arr1[j];
            j++;
            t++;
        }

        //tag on remaining sequence
        while(i<q){
            temp[t]=arr1[i];
            i++;
            t++;

        }
        while(j<r){
            temp[t]=arr1[j];
            j++;
            t++;
        }
        //copy temp back to f
        i=p;t=0;
        while(t<temp.length){
            arr1[i]=temp[t];
            i++;
            t++;
        }
        }
}

public static void insertionSort(int array[], int n, int b){
    for (int i = 1; i < n; i++, compare++){
    int j = i;
    int B = array[i];
    while ((j > 0) && (array[j-1] > B)){
    array[j] = array[j-1];
    j--;
    }
    array[j] = B;
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