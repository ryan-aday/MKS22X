import java.util.*;
import java.lang.*;

public class Quick{
    public static int partition(int[]data, int start, int end){
	if (data.length<2){
	    return data.length;
	}
	
	Random rand = new Random();
	if (end-start<0){
	    return -1;
	}
	
	int pivotI=rand.nextInt(end-start+1)+start;
	
	int i=pivotI;
	int le=start+1;
	int ge=end;
	
	
	while (i<data.length && i>0 && i>=start  && i<=end && 
	       end<=data.length-1 && start>=0){
	    

	    //System.out.println(pivotI);

	    if (pivotI==le && pivotI==end-1){
		return i;
	    }

	    int pivot=data[pivotI];  //How do I keep getting 12?
	    //System.out.println(data[pivotI]);
	    swap(data,pivotI,start);
	    
	    while (i<=ge && i>=0 && le!=ge-1){
		if (data[i]==pivot){
		    i++;
		}else if (data[i]>pivot){
		    swap(data, i, ge);
		    ge--;
		}else{
		    swap(data, i, le);
		    i++;
		le++;
		}
	    }
	    
	    //System.out.println(i);
	    //System.out.println(le);
	    //System.out.println(ge);
	    
	    partition(data, i, ge);
	    partition(data, le, i-1);
	}return i;
    }

    public static String toString(int[] i){
	String str = "";
	for (int count=0; count<i.length; count++){
	    str+=i[count]+ " ";
	}
	return str;
    }

    public static void swap(int[] data, int start, int end){
	int temp=data[start];
	data[start]=data[end];
	data[end]=temp;
    }

    public static int quickselect(int[] data, int k){
	return quickHelp(data, k, 0, data.length-1);
    }

    public static int quickHelp(int [] data, int i, int start, int end){
	int pivot=partition(data, start, end);
	if (pivot>i){
	    return quickHelp(data, i, start, pivot);
	}
	else if (pivot<i){
	    return quickHelp(data, i, pivot+1, end);    
	}else return data[pivot];
	/*
	if (data.length!=1 && start=end-1){
	    while (i<=gt){
		if (data[i]==data[pivot]){
		    i++;
		}else if (data[i]>data[pivot]){
		    swap(data[i], data[end]);
		    end--;
		}else {
		    swap(data[i], data[start]);
		}
		partition (data, start, i-1);
		partition (data, i+1, end);
	    }
	}
	*/
	
	
    }

    public static void quicksort(int[] a){
	    sortHelp(a, 0, a.length - 1);
    }

    public static void sortHelp(int[] a, int start,int end){
        if (start<end){
	    // int pivot=partition(a,start,end);
	    //sortHelp(a, pivot+1, end);   //Code is no longer viable
	    //sortHelp(a, start, pivot-1);
	    partition(a, start, end);
	}
    }

    public static void main(String[] args){
	int[] ary = new int[]{1, 4, 2};
	    //999,999,999,4,1,0,3,2,999,999,999};
	//System.out.println(quickselect(ary,2));
	quicksort(ary);
	//	System.out.println(partition(ary, 0, ary.length-1));
	System.out.println(toString(ary));
    }

}

