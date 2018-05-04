public class RunningMedian{
    MyHeap<Double> bHeap;
    MyHeap<Double> sHeap;

    int size;
    public static void main(String[] args){
	RunningMedian test = new RunningMedian();
	test.add(10.0);
	test.add(2.0);
	test.add(-15.0);
	test.add(13.0);
	test.add(12.0);
	test.add(13.0);
	test.add(20.0);
	test.add(5.0);
	System.out.println(test.getMedian());
    }
    @SuppressWarnings("unchecked")
    public RunningMedian(){
	bHeap = new MyHeap(false);
	sHeap = new MyHeap();
    }
    public void add(Double element){
	if(bHeap.size() == 0 && sHeap.size() == 0){
	    sHeap.add(element);
	}
	else if(element > sHeap.peek()){
	    bHeap.add(element);
	    rebalance();
	}
	else{
	    sHeap.add(element);
	    rebalance();
	}
	size++;
    }
    public void rebalance(){
	if(sHeap.size() - bHeap.size() > 1){
	    bHeap.add(sHeap.remove());
	}
	else if(bHeap.size() - sHeap.size() > 1){
	    sHeap.add(bHeap.remove());
	}
    }
    public Double getMedian(){
	if(bHeap.size() > sHeap.size()){
	    return bHeap.peek();
	}
	else if(sHeap.size() > bHeap.size()){
	    return sHeap.peek();
	}
	else{
	    return (sHeap.peek() + bHeap.peek())/2;
	}
    }
    public int size(){
	return size;
    }
}
