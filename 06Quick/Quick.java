import java.util.*;
public class Quick{
    public static int[] partition (int[] data, int start, int end){
	int pindex = start + (int) (Math.random()*(end - start));
	int pivot = data[pindex];
	int l=start;
	int i=start;
	int g=end;
	
	while (g>=i){
	    if(data[i]==pivot){
		i++;
	    }
	    else if (data[i]>pivot){
		swap(data,i,g);
		g--;
		    }
	    else{
		swap(data,i,l);
		l++;
		i++;
	    }
		}
	int[] ans={l, i};
	return ans;
	
    }
    
    public static int quickselect(int[] data, int n){
	int start=0;
	int end=data.length-1;
	int[] ans=partition(data, start, end);
	int low=ans[0];
	int up=ans[1];

	while (!(n>=low && n<up)){
	    if (n<low){
		end=low-1;
	    }
	    else{
		start=up;
	    }
	    ans=partition(data, start, end);
	    low=ans[0];
	    up=ans[1];
	}
	
	return data[low];
    }
    
    public static void quicksort(int[] data){
	quicksort(data, 0, data.length-1);
    }
    
    public static void quicksort(int[] data, int start, int end){
	if (start<end){
	    int[] ans = partition(data, start, end);
	    quicksort(data, start, ans[0]-1);
	    quicksort(data, ans[1], end);
	}
    }
    
    

    public static void swap(int[] ary, int a, int b){
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }

    /*
    //Sort testing code
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;
    private static final int EMPTY = 4;

    private static String name(int i){
	if(i==0)return "Increassing";
	if(i==1)return "Decreassing";
	if(i==2)return "Normal Random";
	if(i==3)return "Random with Few Values";
	if(i==4)return "size 0 array";
	return "Error stat array";

    }

    private static int create(int min, int max){
	return min + (int)(Math.random()*(max-min));
    }

    private static int[]makeArray(int size,int type){
	int[]ans =new int[size];
	if(type == STANDARD){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-1000000,1000000);
	    }
	}
	if(type == INCREASE){
	    int current = -5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current += 10;
	    }
	}
	if(type == DECREASE){
	    int current = 5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current -= 10;
	    }
	}
	if(type == SMALL_RANGE){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-5,5);
	    }
	}
	if(type == EMPTY){
	    ans = new int[0];
	}
	return ans;
    }

    public static void main(String[]args){
		int size = 1000000;

		for (int type = 0; type <= 4; type++){

			int [] start = makeArray(size,type);
			int [] result = Arrays.copyOf(start,start.length);
			Arrays.sort(result);
		    
			long startTime = System.currentTimeMillis();
			Quick.quicksort(start);
			long elapsedTime = System.currentTimeMillis() - startTime;
			// /System.out.print(Arrays.toString(start));
			if(Arrays.equals(start,result)){
			    System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
			}
			else{
			    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
			}
		}
    }
    */
}

