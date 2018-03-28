private class MyLinkedList{
    Node first;
    Node last;
    int length;
    Node[] listboi;
    

    public MyLinkedList(){
	listboi=new Node[10];
	length=0;
    }
    
    public String toString(){
	for (int c=0; c<length-1; c++){
	    System.out.println(get(c).toString()+" ");
	}
    }
    
    public Node get(int n){
	if (n>size() || n<0){
	    throw new IndexOutOfBoundsException();
	}
	return listboi[n];
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
	
    }

    public boolean remove(int index){}
}
