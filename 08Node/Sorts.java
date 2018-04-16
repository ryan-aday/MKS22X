import java.util.*;
import java.util.Arrays;

public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data)
    {
	//sudo code
	/*
	  -make "buckets" for data needed
	*/
	int max=data.max();
        int maxdig=data.get(max).toString().length();
	for (int j=0; j<maxdig; j++){
	    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] arr=new MyLinkedListImproved[10];
	    for(int i=0;i<arr.length;i++){
		arr[i]=new MyLinkedListImproved<Integer>();
	    }
	    for(Integer v:data){
		//int i=getDigit(j, v);
		//getDigit(int i,Integer num)
		double n=v%(Math.pow(10,j));
		n=n/(Math.pow(10,j-1));
		//return (int)n;

		arr[(int)n].add(v);
	    }
	    data.clear();
	    for(int i=0;i<arr.length;i++){
		data.extend(arr[i]);
	    }
	}
	
    }


    public static void main(String[] args){
	/*MyLinkedListImproved a=new MyLinkedListImproved<Integer>();
     	a.add(0);
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	MyLinkedListImproved<Integer> b=new MyLinkedListImproved<Integer>();
	b.add(5);
	b.add(6);
	b.add(7);
	b.add(8);
	b.add(9);
	a.extend(b);
	System.out.println(a.toString());
	radixsort(a);
	System.out.println(a.toString());
	*/
    }

}
    
