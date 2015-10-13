import java.io.*;
import java.util.*;

public class DatParser {
	public static ArrayList<ArrayList<String>> parse(String filepath) throws IOException{
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
		
        String line = null;
        
        while((line = bufferedReader.readLine()) != null) {
        	ArrayList<String> alline = new ArrayList<String>();
            Scanner scanner = new Scanner (line);
            while(scanner.hasNext()){
            	alline.add(scanner.next());
            }
            scanner.close();
            lines.add(alline);
        }
        
        bufferedReader.close();
        
		return lines;
	}
}
