public class IsInSums{
    
    public static void main(String[]args){
	IsInSums a=new IsInSums();
	System.out.println(a.IsInSums(3,6));
    }

    public boolean IsInSums(int n, int target){
	return SumsHelp(n, target, 0);
    }

    public boolean SumsHelp(int n, int target, int total){

	if (total> target){
	    return false;
	}
	if (total==target){
	    return true;
	}
	if (n>0){
	    return SumsHelp(n-1, target, total+n)||SumsHelp(n-1, target, total);
	}
	return false;
    }
}

    
