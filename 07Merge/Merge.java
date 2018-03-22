public class Merge{
    //private int[] temp;

    public static void mergesort(int[] data, int start, int end){
	//Finding half of data
	if (start>=end){
	    return ;
	}
	/*
	for (int count=start; count<end; count++){
	    temp[count]=data[count];
	}
	*/
	//	System.out.println(toString(data)+"\n"+toString(temp)+"\n");
	int mid= ((end-start)/2)+start;
	//	System.out.println(mid);
	
	mergesort(data, start, mid);
	mergesort(data, mid+1, end);
	merge(data, start, mid, end);
    }
    
    public static void merge(int[] data, int start, int mid, int end){
	int[] tempOne=new int[mid-start+1];
	int[] tempTwo=new int[end-mid];

	for (int ca=0; ca<tempOne.length; ca++)
            tempOne[ca] = data[start+ca];
        for (int da=0; da<tempTwo.length; da++)
            tempTwo[da] = data[mid+1+da];

	//System.out.println("Working...");
	int c=0;
	int d=0;
	int e=start;

	while (c<mid-start+1 && d<end-mid){
	    if (tempOne[c]<=tempTwo[d]){
		data[e]=tempOne[c];
		c++;
	    }else{
		data[e]=tempTwo[d];
		d++;
	    }e++;
	}
	while (c<mid-start+1){
	    data[e]=tempOne[c];
	    c++;
	    e++;
	}
	
	while (d<end-mid){
	    data[e]=tempTwo[d];
	    d++;
	    e++;
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
	int[] ary= {23,1274,231,324,23,23,9112,19,10};
	int[] temp= new int[2];
	mergesort(ary, 0, ary.length-1);
	System.out.println(toString(ary));
    }
}
