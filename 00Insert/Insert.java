public class Insert{
    public static void insertionSort(int[] data){
	intsort(data, 0, data.length-1);
    }

    public static void intsort(int[] data, int start, int end){
	if (start>=end){
	    return ;
	}

	int mid= ((end-start)/2)+start;
	
	intsort(data, start, mid);
	//inHelp(data, start, mid);
	intsort(data, mid+1, end);
	//inHelp(data, mid+1, end);
	inHelp(data, start, end);
    }

    public static void inHelp(int[] data, int start, int end){
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
	//	int[] ary= {23,1274,231,324,23,23,9112,19,100};
	//insertionSort(ary);
	//System.out.println(toString(ary));
    }
}
