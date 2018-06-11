 import java.util.*;
 
public class RunningMedian{
    public MyHeap<Double> sH;
    public MyHeap<Double> bH;

    public RunningMedian(){
	sH = new MyHeap<>();
	bH = new MyHeap<>(false);
    }

    public void add(Double d){
      if (sH.size() == 0 && bH.size() ==0) sH.add(d);
      else{
        if (d > sH.peek()){
          bH.add(d);
          if (bH.size() - sH.size() > 1) sH.add(bH.remove());
        }
        else{
          sH.add(d);
          if (sH.size() - bH.size() > 1) bH.add(sH.remove());
        }
      }
    }

    public double getMedian(){
	if (sH.size() > bH.size()){
	    return sH.peek();
	}
	if (bH.size() > sH.size()){
	    return bH.peek();
	}
	return (sH.peek() + bH.peek()) / 2;
    }

    public static void main(String[] args){
      RunningMedian R = new RunningMedian();
      ArrayList<Double> A = new ArrayList<>();
      double[] list = {2,4,6,2,7,2,4,6,3.2,76.46,83.2,7.2, 3.2, 4.5, 5.5,3.2,6.7};
      //double[] list = {0,1,2,3,4,5,6,7,8,9,10};
      for (double x: list){
	  test(R, A, x);
      }
    } 

    

    public String toString(){
      return "[" + sH.toString() + "] " + "[" + bH + "]";
    }

    public static void test(RunningMedian k, ArrayList<Double> w, double num){
      System.out.println("adding: " + num);
      k.add(num);
      System.out.println("R: " + k);
      w.add(num);
      Collections.sort(w);
      System.out.println("A: "  + w);
      String ans = "" + w.get(w.size() / 2);
      if (w.size() != 0 && w.size() % 2 == 0){
        ans =  "" + (w.get((w.size() - 1)/2 ) + w.get(w.size()/2)) / 2;
      }
      System.out.println("R-med: " + k.getMedian() + "A-med: " + ans);
      System.out.println();
  }    
}
