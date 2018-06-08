import java.util.*;
import java.util.Arrays;

public class MyHeap <T extends Comparable<T>> {
    private int size;
    private T[] data;
    private boolean max;
    
    private static final int cap=10;

    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[])new Comparable[cap];
	max=true;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean check){
	max=check;
	data=(T[])new Comparable[cap];
    }



    public T peek() {
        return data[0];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        T[] temporary = data;

        data = (T[]) new Comparable[data.length * 2];

        for (int index = 0; index < temporary.length; index++) {
            data[index] = temporary[index];
        }
    }
    
    private void swap(int f, int s) {
        T temp = data[f];
        
        data[f] = data[s];
        data[s] = temp;
    }

    public void add(T addition) {
	int position = size;
	
        if (size == data.length) {
            expand();
        }
        
        data[size] = addition;
        size++;
        
        int parent = (position - 1) / 2;
	
        if (max) {
            while (parent >= 0 && data[position].compareTo(data[parent]) > 0) {
                swap(parent, position);
                position = parent;
                parent = (position - 1) / 2;
            }
        }
        
        else {
            while (parent >= 0 && data[position].compareTo(data[parent]) < 0) {
                swap(parent, position);
                position = parent;
                parent = (position - 1) / 2;
            }
        }
    }
    
    public T remove() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        
        else {
            T deletion = data[0];
            int position = 0;
            
            int f = 2 * position + 1;
            int s = 2 * position + 2;
            
            while (f < size || s < size) {
                if (max) {
                    // System.out.println("First: " + first + " Second: " + second);
		    
                    if (f < s && s < size) {
                        if (data[f].compareTo(data[s]) > 0) {
                            swap(position, f);
                            position = f;
                        }
			
                        else {
                            swap(position, s);
                            position = s;
                        }
                    }
                    
                    else {
                        swap(position, f);
                        position = f;
                    }
                }
                
                else {
                    if (f < size && s < size) {
                        if (data[f].compareTo(data[s]) < 0) {
                            swap(position, f);
                            position = f;
                        }
			
                        else {
                            swap(position, s);
                            position = s;
                        }
                    }
                    
                    else {
                        swap(position, f);
                        position = f;
                    }
                }
                
                f = 2 * position + 1;
                s = 2 * position + 2;
            }
            
            while (position < size - 1) {
                swap(position, position + 1);
                position++;
            }
            
            data[position] = null;
            size--;
            return deletion;
        }
    }
}
