private class MyLinkedList implelemts Iterable<AnyType>{
    private Node first;
    private Node current;
    private Node last;
    private int length;
    //Node[] listboi;
    

    public MyLinkedList(){
	first=null;
	current=first;
	length=0;
    }
    
    public boolean isEmpty(){
	return head==null;
    }

    public boolean add(int value){
	if (isEmpty()){
	    first=new Node(value, null, null);
	    last=first;
	}
	current=new Node(value, last, null);
    }

    public String toString(){
	for (int c=0; c<length-1; c++){
	    System.out.println(get(c).toString()+" ");
	}
    }
    
    public AnyType get(int n){
	if (first==null){
	    throw new IndexOutOfBoundsException();
	}
	if (first==null){
	    throw new NoSuchElementException();
	}
	Node<AnyType> temp=first;
	for (int c=0; c<n; c++){
	    temp=temp.getNext();
	    if (temp==null){
		throw new IndexOutOfBoundsException();
	    }
	}
	return temp.getData();
    }

    public void set(int index,int value){
       	if (index>size() || index<0){
	    throw new IndexOutOfBoundsException();
	}
	listboi[index]=value;
    }

    public int size(){
	return length;
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
}
