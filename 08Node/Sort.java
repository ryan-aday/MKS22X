import java.util.*;
import java.util.Arrays;

public class Sort{
    
    public static void radixsort(MyLinkedListImproved<Integer> data)
    {
	//sudo code
	/*
	  -make "buckets" for data needed
	*/

	@SuppressWarnings("unchecked")		
	ArrayList<LinkedList<Integer>> d=new ArrayList<Integer> [10];


	
	//	@suppressWarnings("unchecked")MyLinkedListImproved<Integer>[] b=new MyLinkedListImproved[10];
	for(int c=0; c<((Integer)data.max()/(Math.pow(10,(Math.log(data.size())*10.0/10.0)))); c++){
	    for(Integer elem : data){
		b[(elem / (int)Math.pow(10.0, c)) % 10].add(elem);
	    }
	    data.clear();
	    for(int i = 0; i < b.length; i++){
		data.extend(b[i]);
	    }
	}
    }   
    public static void main(String[] args){
	MyLinkedListImproved a=new MyLinkedListImproved<Integer>();
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
    }

}
    
