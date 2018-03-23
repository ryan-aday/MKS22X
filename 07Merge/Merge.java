public class Merge{
    //private int[] temp;

    public static void mergesort(int[] data){
	mergeSort(data, 0, data.length-1);
    }

    public static void mergeSort(int[] data, int start, int end){
	if (start>=end){
	    return ;
	}

	if (end-start<=69){
	    insertionSort(data, start, end);
	}

	int mid= ((end-start)/2)+start;
	
	mergeSort(data, start, mid);
	mergeSort(data, mid+1, end);
	merge(data, start, mid, end);
    }
    
    public static void merge(int[] data, int start, int mid, int end){
	int[] tempOne=new int[mid-start+1];
	int[] tempTwo=new int[end-mid];

	for (int ca=0; ca<tempOne.length; ca++)
            tempOne[ca] = data[start+ca];
        for (int da=0; da<tempTwo.length; da++)
            tempTwo[da] = data[mid+1+da];

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
    }

    public static void insertionSort(int[] data, int start, int end){
	for (int count=start; count<=end; count++){
	    int min=data[count];
	    int comp=count-1;
	    while(comp >=0  && data[comp]>min){
		data[comp+1]=data[comp];
		comp--;
	    }
	    data[comp+1]=min;
	}
    }


    public static String toString(int[] i){
	String str = "";
	for (int count=0; count<i.length; count++){
	    str+=i[count]+ " ";
	}
	return str+"\n";
    }

    public static void main(String[] args){
	//	int[] ary= {23,1274,231,324,23,23,9112,19,10};
	//mergesort(ary);
	//System.out.println(toString(ary));
    }
}
