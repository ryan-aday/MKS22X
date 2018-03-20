public class merge{
    //private int[] temp;

    public static void mergesort(int[] data, int start, int end){
	//Finding half of data
	int[] temp= new int[data.length];
	int mid= ((end-start)/2)+start;
	//	System.out.println(mid);
	
	while (start- end!=0){
	    mergesort(data, start, mid);
	    mergesort(data, mid+1, end);
	}
	merge(data, temp,  start, end);
	data=temp;
    }

    public static void merge(int[] data, int[] temp, int start, int end){
	temp=new int[end-start+1];
	for (int c=start; c<end+1; c++){
	    temp[c-start]=data[c];
	}
	//int c=start;
	//int d=mid+1;
	/*	while (c<mid && d<end){
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
    }

    
    public static void swap(int[] data, int i, int j){
	int temp=data[i];
	data[i]=data[j];
	data[j]=temp;
    }

    public static void main(String[] args){
	int[] ary= {86,	70,	21,	60,	67,
		    34,	31,	56,	83,	69,
		    32,	87,	78,	100,	9,
		    47,	74,	75,	50,	18,
		    37,	61,	71,	16,	40,
		    33,	51,	46,	6,	68,
		    70,	62,	38,	75,	28,
		    16,	76,	63,	32,	70,
		    81,	39,	47,	45,	9,
		    6,	99,	6,	45,	1,
		    36,	35,	9,	42,	28,
		    38,	87,	20,	76,	39,
		    83,	45,	32,	83,	1};
	mergesort(ary, 0, ary.length);
	System.out.println(ary);
    }
}
