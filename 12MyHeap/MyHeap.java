import java.util.*;

public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private int size;
    private boolean isMax;
    
    public static void main(String[]args){
    }
    
    public MyHeap(){
	this(true);
    }
    
    @SuppressWarnings("unchecked")
	public MyHeap (boolean value) {
	if (value) {
	    isMax = true;
	}
	else {
	    isMax = false;
	}
	data = (T[]) new Comparable[10];
	size = 0;
    }
    
    public String toString() {
	String str = "[";
	for (int i=0; i<size; i++){
	    str+=data[i];
	    if (i != size-1){
		str+= ",";
	    }
	}
	return str+"]";
    }
    
    public int size() {
	return size;
    }
    
    private void swap(int one, int two){
	T temp = data[one];
	data[one] = data[two];
	data[two] = temp;
    }

    @SuppressWarnings("unchecked")
	private void resize() {
	T[] temp = (T[]) new Comparable[size*2];
	for (int i=0; i<data.length; i++){
	    temp[i] = data[i];
	}
	data=temp;
    }
    
    public T peek(){
	if (size == 0){
	    return null;
	}
	else {
	    return data[0];
	}
    }
    
    public void add(T elm) {
	if (size == data.length){
	    resize();
	}
	if (size == 0) {
	    data[0]=elm;
	}
	else {
	    data[size]=elm;
	    pushUp(size);
	}
	size++;
    }
    
    public T remove() {
	if (size == 0){
	    return null;
	}
	T removedElem = peek();
	data[0] = data[size-1];
	size--;
	pushDown(0);
	return removedElem;
    }
    
    private void pushUp(int index){
	int parent=(index-1)/2;
	if (isMax && data[index].compareTo(data[parent]) > 0 ||
	    !isMax && data[index].compareTo(data[parent]) < 0){
	    swap(index,parent);
	    pushUp(parent);
	}
    }
    
    private void pushDown(int index){
	int L = 2*index + 1;
	int R = 2*index + 2;
	if (L >= size){return;}
	if (R >= size){
	    if (canPushDown(index,L)){
		swap(index,L);
		pushDown(L);
	    }
	}
	else if (canPushDown(index, L)){
	    if (hasPriorityOver(L, R)){
		swap(index, L);
		pushDown(L);
	    }
	    else {
		swap(index, R);
		pushDown(R);
	    }
	}
	else if (canPushDown(index, R)){
	    swap(index, R);
	    pushDown(R);
	}
    }
    
    public boolean canPushDown(int parent, int child){
	return isMax && data[parent].compareTo(data[child]) < 0 ||
	    !isMax && data[parent].compareTo(data[child]) > 0;
    }
    
    public boolean hasPriorityOver(int child1, int child2){
	return isMax && data[child1].compareTo(data[child2]) >= 0 ||
	    !isMax && data[child1].compareTo(data[child2]) <= 0;
    }
}
