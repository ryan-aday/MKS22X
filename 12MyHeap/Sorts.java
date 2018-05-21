import java.util.*;

public class Sorts{
    
    public static void main(String[]args){
    }
    
    public static void sort(int[] ary){
	for (int i=ary.length-1; i>=0; i--){
	    pushDown(i,ary,ary.length);
	}
	for (int i=0; i<ary.length; i++){
	    int max=ary[0];
	    int index=ary.length-1-i;
	    ary[0] = ary[index];
	    pushDown(0,ary,index);
	    ary[index] = max;
	}
    }

    public static void pushUp(int index, int[] data){
	int parentIndex = (index-1)/2;
	if (data[index] > data[parentIndex]){
	    swap(index,parentIndex,data);
	    pushUp(parentIndex,data);
	}
    }
    
    private static void pushDown(int index, int[] data, int size){
	int L = 2*index + 1;
	int R = 2*index + 2;
	int swapIndex = index;
	if (L < size && data[swapIndex] < data[L]){
	    swapIndex=L;
	}
	if (R<size && data[swapIndex] < data[R]){
	    swapIndex=R;
	}
	if (swapIndex == index){
	    return;
	}
	swap(index,swapIndex,data);
	pushDown(swapIndex,data,size);
    }
    
    public static void swap(int one, int two, int[] data){
	int temp = data[one];
	data[one] = data[two];
	data[two] = temp;
    }
}
