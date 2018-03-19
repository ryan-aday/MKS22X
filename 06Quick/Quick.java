import java.util.*;
public class Quick{
    public static void  partition(int[]data, int start, int end){
	if (start>=end){
	    return ;
	}
	Random rand = new Random();

	//	System.out.println("Start: "+start+" End:  "+end);
	int pivotI=rand.nextInt(end-start)+start;
	//	System.out.println("Random Index: "+pivotI);

	int pivot=data[pivotI];
	//	System.out.println("Random Elm: "+pivot);	

	swap(data, pivotI, start);
	
	int i=start;
	int le=start;
	int ge=end;
		
	while (i<=ge){
	    if (data[i]==pivot){
		i++;
		//	System.out.print(toString(data));
		//	System.out.print(le+" "+ge+"\n");
	    }else if (data[i]>pivot){
		swap(data, i, ge);
		ge--;
		//	System.out.print(toString(data));
		//	System.out.print(le+" "+ge+"\n");
	    }else{
		swap(data, i, le);
		i++;
		le++;
		//	System.out.print(toString(data));
		//	System.out.print(le+" "+ge+"\n");		    
	    }
	}

	//	System.out.println("I: "+i+" Pivot: "+pivotI+"\n");
	if(le>0){     
	    partition(data, start, le-1);
	}partition(data, ge+1, end);
    }

    public static String toString(int[] i){
	String str = "";
	for (int count=0; count<i.length; count++){
	    str+=i[count]+ " ";
	}
	return str+"\n";
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
	partition(data, start, end);
	return data[i];
    }

    public static void quicksort(int[] data){
	    sortHelp(data, 0, data.length-1);
    }

    public static void sortHelp(int[] data, int start,int end){
        if (start>=end){
	    return;
	}
	
	Random rand = new Random();

	//	System.out.println("Start: "+start+" End:  "+end);
	int pivotI=rand.nextInt(end-start)+start;
	//	System.out.println("Random Index: "+pivotI);

	int pivot=data[pivotI];
	//	System.out.println("Random Elm: "+pivot);	

	swap(data, pivotI, start);
	
	int i=start;
	int le=start;
	int ge=end;
		
	while (i<=ge){
	    if (data[i]==pivot){
		i++;
		//	System.out.print(toString(data));
		//	System.out.print(le+" "+ge+"\n");
	    }else if (data[i]>pivot){
		swap(data, i, ge);
		ge--;
		//	System.out.print(toString(data));
		//	System.out.print(le+" "+ge+"\n");
	    }else{
		swap(data, i, le);
		i++;
		le++;
		//	System.out.print(toString(data));
		//	System.out.print(le+" "+ge+"\n");		    
	    }
	}

	//	System.out.println("I: "+i+" Pivot: "+pivotI+"\n");
	if (le>0){
	    sortHelp(data, start, le-1);
	}sortHelp(data, ge+1, end);
    }


    public static void main(String[] args){
	  /*
	int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(quickselect(ary,3));
	//	quicksort(ary);
        ///partition(ary, 0, ary.length-1);
	//System.out.println(toString(ary));
	*/  
	/*
	int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
	quicksort(test);
	System.out.println(toString(test));
	*/
	}
}

