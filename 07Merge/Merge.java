public class Merge{
    //private int[] temp;

    public static void mergesort(int[] data, int[] temp, int start, int end){
	//Finding half of data
	if (start>=end){
	    return ;
	}
	
	for (int count=start; count<end+1; count++){
	    temp[count]=data[count];
	}
	System.out.println(toString(data)+"\n"+toString(temp)+"\n");
	int mid= ((end-start)/2)+start;
	//	System.out.println(mid);
	
	mergesort(temp, data, start, mid);
	mergesort(temp, data, start, end);
	merge(data, temp, start, mid, end);
    }
    
    public static void merge(int[] data, int[] temp, int start, int mid, int end){
	System.out.println("Working...");
	int c=start;
	int d=mid+1;

	while (c<=mid && d<=end){
	    for(int count=start; count<=end; count++){
		if (data[c]>=data[d]){
		    temp[count]=data[c];
		    c++;
		    System.out.println(c);
		}else{
		    temp[count]=data[d];
		    d++;
		    System.out.println(c);

		}
	    }data=temp;
	}
	
	/*while (c<mid && d<end){
	    if (data[c]>data[c+1]){
		//swap(data, c, c+1);
		temp[c-start]=data[c];
	    }
	    if (data[d]>data[d+1]){
		swap(data, d, d+1);
		temp[d-start]=data[d];
	    }
	    if (data[d]<data[c]){
		swap(data, c, d);
		temp[c-start]=data[c];
	    }
	    c++;
	    d++;
	}
	data=temp;
	*/
	/*
	int min;
	for (int c=start; c<end+1; c++){
	    temp[c]=data[c];
	}
	for (int count=start; count<end; count++){
	    min= count;
	    for (int counts=count+1; counts<data.length; counts++){
		if (data[counts]<data[min]){
		    min=counts;
		}
	    }swap(temp, count, min);
	}
	*/
	/*
	for (int count=1; count<temp.length; count++){
	    int min=temp[count];
	    int comp=count-1;
	    while(comp >=0  && temp[comp]>min){
		temp[comp+1]=temp[comp];
		comp--;
	    }
	    temp[comp+1]=min;
	}
	for (int d=start; d<end+1; d++){
	    data[d]=temp[d-start];
	}
	*/
    }

    public static String toString(int[] i){
	String str = "";
	for (int count=0; count<i.length; count++){
	    str+=i[count]+ " ";
	}
	return str+"\n";
    }
    
    public static void swap(int[] data, int i, int j){
	int temp=data[i];
	data[i]=data[j];
	data[j]=temp;
    }

    public static void main(String[] args){
	int[] ary= {86,	70};
	int[] temp= new int[2];
	mergesort(ary, temp, 0, 1);
	System.out.println(ary);
    }
}
