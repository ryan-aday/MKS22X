
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {

        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File(args[0]);// can be a path like: "/full/path/to/file.txt" 
        
        //inf stands for the input file
        Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
            String line = inf.nextLine();
            System.out.println(line);//hopefully you can do other things with the line
        }       
    }   
}
