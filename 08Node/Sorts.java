import java.util.*;
import java.util.Arrays;

public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if (data.size()>0){
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[]pos=new MyLinkedListImproved[10];
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[]neg=new MyLinkedListImproved[10];
	    for(int c=0; c< 10; c++){
		pos[c] = new MyLinkedListImproved<Integer>();
		neg[c] = new MyLinkedListImproved<Integer>();
	    }
	    int max = data.get(data.max());
	    int min = data.get(data.min());
	    int passes;
	    if(Math.abs(max)>=Math.abs(min)){
		passes=(int)(Math.log10(max));
	    }
	    else{
		passes=(int)(Math.log10(min*-1));
	    }
	    for(int d=0; d<passes; d++){
		for(Integer e : data){
		    if(e>-1){
			int index=(int)((e/ Math.pow(10,d))% 10);
			pos[index].add(e);
		    }
		    else{
			int index= (int)((e*-1/Math.pow(10,d))% 10);
			neg[index].add(e);
		    }
		}
		data.clear();
		for(int f=neg.length-1; f>0; f--){
		    data.concat(neg[f]);
		}
		for(int g=0; g<pos.length;g++){
		    data.concat(pos[g]);
		}
	    }
	}
    }


    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	radixsort(data);

	//return ;
    }

    public static void main(String[] args){
	/*	@SuppressWarnings("unchecked")
	    MyLinkedListImproved a = new MyLinkedListImproved();
	a.add(12);
	a.add(-23);
	a.add(23);
	a.add(102);
	a.add(232);
	System.out.println(a.toString());

	//radixsort(a);
	System.out.println(a.toString());
	*/
	}
}
    
