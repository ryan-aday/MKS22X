public class Merge {
    private static void msort(int[] data, int[] temp, int start, int end) {
	if (end-start<11) {  
	    insertionsort(data, start, end);
	}else{
	    int middle=(start+end)/2;
	    if (end>start) {
		msort(temp, data, start, middle);
		msort(temp, data, middle + 1, end);
		merge(data, temp, start, middle, middle + 1, end, start);
	    }
	}
    }

    private static void merge(int[] data, int[] temp, int l,
			      int m, int q, 
			      int h, int counter) {
	while (l<=m && q<=h) {
	    if (temp[l]<temp[q]) {
		data[counter] = temp[l];
		l++;
		counter++;
	    }

	    else { 
		data[counter] = temp[q];
		q++;
		counter++;
	    }
	}
	while (l<=m){
	    data[counter]=temp[l];
	    l++;
	    counter++;
	}

	while (q<=h) {
	    data[counter]=temp[q];
	    q++;
	    counter++;
	}
    }


   public static void mergesort(int[] data) {
        if (data.length>1) {
	    int[] temp = new int[data.length];
	    for (int e=0; e<data.length; e++) {
		temp[e] = data[e];
	    }
            msort(data, temp, 0, data.length - 1);
        }
    }

    private static void insertionsort(int[] data, int start, int end) {
	int s,e;
	
	for (int a=start+1; a<=end; a++) {
	    s=data[a];

	    for (e=a; e>start && s<data[e-1]; e--) {
		data[e]=data[e-1];
	    }

	    data[e] = s;
	}
    }

    private static void swap(int[] data, int a, int b) {
	int storage = data[a];
	data[a] = data[b];
	data[b] = storage;
    }
		    
    private static void print(int[] data) {
        String temp="";
        for (int num: data) {
            temp+=num + " ";
        }
        System.out.println(temp);
    }
}
