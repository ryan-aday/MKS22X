public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data)
    {
	//sudo code
	/*
	  -make "buckets" for data needed
	*/
	MyLinkedListImproved<Integer>[] b=new MyLinkedListImproved<Integer>[10];
	for(int c=0; c<((Integer)data.max()/(Math.pow(10,(Math.log(data)*10/10)))); c++){
	    for(Integer elem : data){
		b[(elem / Math.pow(10, c)) % 10].add(elem);
	    }
	    data.clear();
	    for(int i = 0; i < b.length; i++){
		data.extend(b[i]);
	    }
	}
    }   
    public static void main(String[] args){
	MyLinkedListImproved<Integer> a=new MyLinkedListImproved<Integer>();
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
    
