import java.util.LinkedList;
import java.util.*;

public class Eval{
    public static double eval(String data){
        String[] edata=data.split(" ");
	Stack<Double> s=new Stack<Double>();
	if (edata.length==1){
	    return Double.parseDouble(edata[0]);
	}
	for (String x:edata){
	    if (checkOperator(x)){
		s.push(calc(s.pop(),s.pop(),x));
	    }
	    else{
		s.push(Double.parseDouble(x));
	    }
	}
	return s.peek();
    }

    public static double calc(double sec,double fir,String op){
	if (op.equals("+")){
	    return fir+sec;
	}
	else if (op.equals("-")){
	    return fir-sec;
	}
	else if (op.equals("*")){
	    return fir*sec;
	}
	else if (op.equals("/")){
	    return fir/sec;
	}
	else if (op.equals("%")){
	    return fir%sec;
	}
	else {
	    throw new UnsupportedOperationException();
	}
    }

    public static class Stack<T> extends LinkedList<T>{
	public void push(T value){
	    add(value);
	}

	public T pop(){
	    return remove(size() - 1);
	}

	public T peek(){
	    return get(size() - 1);
	}
    }

    public static boolean checkOperator(String data){
	String str="+-*/%";
	return str.contains(data);
    }

    public static void main(String[] args){
	String str = "1 2 +";
	System.out.println(Eval.eval(str));
    }
}
