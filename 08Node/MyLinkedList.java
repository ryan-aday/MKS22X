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
	first=new Node();
	last=new Node();
	length=0;
    }

    //Misc Functions

    public String toString(){
	String a="";
	for (int c=0; c<length; c++){
	    a= a+get(c)+" ";
	}return a;
    }
    
    public boolean isEmpty(){
	return first==null || length==0;
    }

    public int size(){
	return length;
    }

    //Add Functions
    public boolean add(int value){
	if (isEmpty()){
	    first.setNext(last);
	    last.setPrev(first);
	    first.setValue(value);
	    length++;
	}else if (length==1){
	    last.setValue(value);
	    length++;
	}else{
	    Node next=new Node();
	    last.setNext(next);
	    next.setPrev(last);
	    last=next;
	    last.setValue(value);
	    length++;
	}return true;
    }
    
    //get, set methods

    public int get(int n){
	if (size()>0 && n>=0 && n<length){
	    return getNode(n).getValue();
	}else throw new IndexOutOfBoundsException();
    }

    public int set(int n, int value){
	if (size()>0 && n>=0 && n<size()){
	    Node c=getNode(n);
	    int t=c.getValue();
	    c.setValue(value);
	    return t;
	}else throw new IndexOutOfBoundsException();
    }

    public int indexOf(int value){
	if (size()==1){
	    if (first.getValue()==value){
		return 0;
	    }   
	}else {
	    Node c=first;
	    int t=0;
	    for (int d=0; d<size()-1; x++){
		if (c.getValue()==value){
		    return d;
		}
		c=c.getNext();
		t++;
	    }
	    if (c.getValue()==value){
		return t;
	    }
	}return -1;
    }
    
    private Node getNode(int n){
	Node c=first;
	for(int d=0; d<n; d++){
	    c=c.getNext();
	}return c;
    }

}
