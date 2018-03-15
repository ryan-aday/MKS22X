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

    public static int quickHelp(int [] data, int i, int start, int end){
	int pivot=partition(data, start, end);
	/*while (pivot!=given){
	    if (pivot>given){
		return quickHelp(data, given, start, pivot);
	    }
	    if (pivot<given){
		return quickHelp(data, given, pivot+1, end);
	    }
	}return data[pivot];
	*/
	/*if (data.length!=1 && start=end-1){
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
	    }*/
    }

    public static void quickSort(int[] a){
	sortHelp(a, 0, 0, a.length - 1);
    }

    public static void sortHelp(int[] data, int start,int end){
	int pivot=partition(data, start, end);
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
    }

    public static void main(String[] args){}

}

