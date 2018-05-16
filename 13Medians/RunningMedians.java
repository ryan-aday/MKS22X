public class RunningMedians{
    MyHeap<Double> big;
    MyHeap<Double> small;
    int size;
    
    public static void main(String[] args){}

    @SuppressWarnings("unchecked")
    public RunningMedians(){
    big = new MyHeap(false);
    small = new MyHeap();
    }
    
    public void add(Double element){
	if(big.size()==0 && small.size()==0){
	    small.add(element);
	}
	else if(element>small.peek()){
	    big.add(element);
	    shift();
	}
	else{
	    small.add(element);
	    shift();
	}
	size++;
    }
    
    public Double getMedian(){
	if(big.size()>small.size()){
	    return big.peek();
	}else if(small.size()>big.size()){
	    return small.peek();
	}else{
	    return (small.peek()+big.peek())/2;
	}
    }

    public void shift(){
	if(small.size()-big.size()>1){
	    big.add(small.remove());
	}
	else if(big.size()-small.size()>1){
	    small.add(big.remove());
	}
    }
    
    public int size(){
	return size;
    }
}
