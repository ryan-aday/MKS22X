import java.util.*;

public class Quick{
    public static int partition(int[]data, int start, int end){
	Random rand = new Random();
	int pivotI=rand.nextInt(end - 1)+start;
	int pivot=data[pivotI];
	swap(data,pivotI,start);
	int s=start+1;
	int l=end-1;
	while (s<=l){
	    System.out.println(pivot);
	    System.out.println(toString(data));
	    if (data[s] <= pivot){
		s++;
	    }
	    else if (data[s]>pivot){
		swap(data,s,l);
		l--;
	    }
	}
	swap(data,s,l);
	return l;
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

    public static int quickSelect(int[] data, int k){
	return quickHelp(data, k, 0, data.length-1);
    }

    public static int quickHelp(int [] data, int given, int start, int end){
	int pivot=partition(data, start, end);
	while (pivot !=given){
	    if (pivot>given){
		return quickHelp(data, given, start, pivot);
	    }
	    if (pivot<given){
		return quickHelp(data, given, pivot+1, end);
	    }
	}return data[pivot];
    }

    public static void quickSort(int[] a){
	sortHelp(a, 0, a.length - 1);
    }

    public static void sortHelp(int[] a, int start,int end){
        if (start<end){
	    int pivot = partition(a,start,end);
	    sortHelp(a, pivot+1,end);
	    sortHelp(a, start, pivot-1);
	}
    }

    public static void main(String[] args){}

}

