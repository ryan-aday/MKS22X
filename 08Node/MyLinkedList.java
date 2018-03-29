public class MyLinkedList{
    private Node first;
    private Node current;
    private Node last;
    private int length;
    //Node[] listboi;
    
    public static void main(String[]args){
	MyLinkedList a=new MyLinkedList();
	System.out.println(a.isEmpty());
	System.out.println(a.size());
	a.add(2);
	System.out.println(a.isEmpty());
	a.add(1);
	a.add(0);
		
	System.out.println(a.get(0));
	System.out.println(a.toString());
    }	
    
    
    public MyLinkedList(){
	first=null;
	current=first;
	length=0;
    }
    
    public boolean isEmpty(){
	return first==null;
    }

    public int size(){
	return length;
    }

    public boolean add(int value){
	if (isEmpty()){
	    first=new Node(value, null, null);
	    last=first;
	    length++;
	    return true;
	}
	first=new Node(value, last, null);
	last=first.getNext();
	length++;
	return true;
    }

    public String toString(){
	String a="";
	for (int c=0; c<length; c++){
	    a= a+get(c)+" ";
	}return a;
    }
    
    public int get(int n){
	if (first==null){
	    throw new IndexOutOfBoundsException();
	}
	Node temp=first;
	for (int c=0; c<n-1; c++){
	    temp=temp.getNext();
	}
	if (temp==null){
	    throw new IndexOutOfBoundsException();
	}
	return temp.getValue();
    }


    /*
    public void set(int index,int value){
       	if (index>size() || index<0){
	    throw new IndexOutOfBoundsException();
	}
	listboi[index]=value;
    }



    public boolean add(int index, int value){
	if (index<0){
	    throw new IndexOutOfBoundsException();
	}
	listboi[size()]=value;
	length++;
	return true;
    }

    public boolean remove(int index){
	return true;
    }
    */
}
