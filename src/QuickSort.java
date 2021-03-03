public class QuickSort {

	private int array[];
	private int length;
	private int compare;
	private long timeUsed = 0;
	long beginTime, endTime;
	
	// This method sorts an array and internally calls quickSort 
	public void sort(int inputArr[]){
		
		this.array = inputArr;
        this.length = inputArr.length;
        this.compare = 0;
        timeUsed = 0;
        
        
		
        beginTime = System.nanoTime();
        quickSort(0, length - 1);
        endTime = System.nanoTime();
        setTimeUsed(endTime - beginTime);
	}
	
	public void quickSort(int left,int right){
		
		int pivot_pos;
	    if (left >= right) 
	        return;
	    pivot_pos = partition(left, right);
	    quickSort(left, pivot_pos - 1);//left part
	    quickSort(pivot_pos + 1, right);//right part
	}
	
	//partition array
	public int partition(int low,int high){
		int i, last_small, pivot;
	    int mid = (low+high)/2;

	    swap(low, mid);
	    pivot = array[low];//set pivot value
	    last_small = low;//smallest
	    
	    for (i = low+1; i <= high; i++,compare++)	
   	     if (array[i] < pivot)//if current value smaller than pivot
   	    	 swap(++last_small, i);//swap lastsmall next with i 
	    swap(low, last_small);//swap back pivot with lastsmall
	   return last_small;

	}
	
	// basic swap operation
	public void swap(int left,int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public int getCompare() {
		return compare;
	}

	public long getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(long timeUsed) {
		this.timeUsed = timeUsed;
	}

}
