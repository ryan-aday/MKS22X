import java.util.*;

public class part{
    public static int partition(int[]data, int start, int end){
	Random rand = new Random();
	int pivotIndex = rand.nextInt(end - 1);
	int pivot = data[pivotI];
	swap(data,pivotI,start);
	int s=start+1;
	int l=end - 1;
	while (s<=large){
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

    public static void main(String[] args){}

}

