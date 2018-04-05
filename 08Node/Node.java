public class Node{
    Node next, prev;
    int data;

   public Node(int d,Node next,Node prev){
        data = d;
	this.next = next;
	this.prev = prev;
    }

    public void setPrev(Node pre){
	prev=pre;
    }

    public void setNext(Node nex){
	next=nex;
    }

    public Node getNext(){
	return next;
    }
    
    public Node getPrev(){
	return prev;
    }

    public int getValue(){
	return data;
    }

    public void setValue(int val){
	data=val;
    }

    public String toString(){
	String str = "";
	str += this.getValue();
	return str;
    }
}
