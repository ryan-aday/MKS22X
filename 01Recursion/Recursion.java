import java.lang.Math;

public class Recursion{
    public static void main(String[] args){
	Recursion d= new Recursion();

	//fact Tests
	System.out.println(d.fact(0));
	System.out.println(d.fact(1));
	System.out.println(d.fact(2));
	System.out.println(d.fact(10));
	System.out.println(d.fact(16));
	//System.out.println(d.fact(17)); //fact bugs out after 16

	//fib Tests
	//System.out.println(d.fib(-1)); //Error test case	
	System.out.println(d.fib(0));
	System.out.println(d.fib(1));
	System.out.println(d.fib(2));
	System.out.println(d.fib(4));
	System.out.println(d.fib(10));

	//sqrt Tests
	System.out.println(d.sqrt(4));	
	System.out.println(d.sqrt(9));
	System.out.println(d.sqrt(16));
	System.out.println(d.sqrt(100));
	System.out.println(d.sqrt(1214));
	System.out.println(d.sqrt(1234));

	
    }
			

    //1.1 Factorial
    public int fact(int n){
	if (n==0){
	    return 1;
	}
	if (n==1){
	    return 1;
	}
	if (n>0 && n<17){
	    return n*fact(n-1);
	}
	throw new IllegalArgumentException();
    }

    //1.2 Fibonacci O(n)
    public int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}

	if (n==0){
	    return 0;
	}
	if (n==1){
	    return 1;
	}	  

	
	int[] data=new int[n+1];	    
	data[0]=0;
	data[1]=1;

	for (int count=2; count<n+1; count++){
	    data[count]=data[count-1]+data[count-2];
	}
	return data[n];
    }

    public double sqrt(double n){
	double divisor=100000;
	double root=n;

	if (n==0){
	    return 0;
	}

	if (n==1){
	    return 1;
	}
	
	while(root*root>(n*1.0000001) || root*root<(n*.9999999)){
	    root=sqHelp(n,root);
	}

	while ((int)(root*divisor)==0){
	    divisor=divisor*10;
	}

	int a=(int)(root*divisor);
	double b=(double)a/divisor;
	    
	return b;
    }

    public double sqHelp(double n, double check){
	if (check>n || check<=0){
	    throw new IllegalArgumentException();
	}
	//System.out.println((n/check+check)/2);
	return (n/check+check)/2;
    }
}
