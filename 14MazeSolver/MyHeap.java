import java.util.*;

public class MyHeap <T extends Comparable<T>> {
    private int size;
    private T[] data;
    private boolean max;

    public MyHeap(){
	this(true);
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean check){
	if (check){
	    max=true;
	}
	else {
	    max=false;
	}
	data=(T[])new Comparable[10];
    }

    private void swap(int a, int b){
        T temp=data[a];
	data[a]=data[b];
	data[b]=temp;
    }

    public int size(){
	return size;
    }

    private void pushUp(int index){
	int og=(index-1)/2;
	if (max &&data[index].compareTo(data[og])>0 ||
	    !max&&data[index].compareTo(data[og]) < 0){
	    swap(index,og);
	    pushUp(og);
	}
    }

    public void add(T value){
	if (size()==data.length){
	    resize();
	}
	if (size == 0) {
	    data[0]=value;
	}else{
	    data[size()]=value;
	    pushUp(size());
        }size++;
    }

    private void pushDown(int index){
	int L=2*index + 1;
	int R=2*index + 2;
	if (L>=size){
	    return;
	}
	if (R>=size){
	    if (canPushDown(index,L)){
		swap(index,L);
		pushDown(L);
	    }
	}
	else if (canPushDown(index,L)){
	    if (hasPriorityOver(L,R)){
		swap(index,L);
		pushDown(L);
	    }
	    else {
		swap(index,R);
		pushDown(R);
	    }
	}
    }

    public boolean canPushDown(int parent, int val){
	return max && data[parent].compareTo(data[val])<0 ||
	    !max && data[parent].compareTo(data[val])>0;
    }
    
    public boolean hasPriorityOver(int c1, int c2){
	return max && data[c1].compareTo(data[c2])>=0 ||
	    !max && data[c1].compareTo(data[c2])<=0;
    }

    public T remove(){
	if (size==0){
	    return null;
	}
	T value=peek();
	data[0]=data[size-1];
        size--;
	pushDown(0);
	return value;
    }

    public T peek(){
	if (size==0){
	    return null;
	}else{
	    return data[0];
	}
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp=(T[])new Comparable[size*2];
	for(int c=0; c<size(); c++){
	    temp[c] = data[c];
	}
	data=temp;
    }

    public String toString() {
	String str="[";
	for (int i=0; i<size; i++){
	    str+=data[i];
	    if (i != size-1){
		str+=",";
	    }
	}
	return str+"]";
    }

    public static void main(String[] args){}
}
