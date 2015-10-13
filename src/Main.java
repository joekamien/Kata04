import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		String filename = "weather.dat";
		Scanner scanner = new Scanner(new File(filename));

		
		int minMonth = -1;
		int minValue = Integer.MAX_VALUE;
		
		while(scanner.hasNextLine()){
			int month, mxt, mnt;
			
			if(scanner.hasNextInt()){
				 month = scanner.nextInt();
			}
			else{
				scanner.nextLine();
				continue;
			}
			if(scanner.hasNextInt()){
				 mxt = scanner.nextInt();
			}
			else{
				scanner.nextLine();
				continue;
			}
			if(scanner.hasNextInt()){
				mnt = scanner.nextInt();
			}
			else{
				scanner.nextLine();
				continue;
			}
			
			int diff = mxt - mnt;
			if (diff < minValue){
				minValue = diff;
				minMonth = month;
			}
			scanner.nextLine();
		}
		scanner.close();
		
		//finished assigning values
		if(minMonth == -1){
			System.out.println("No month with minimum distance found for this data.");
		}
		else{
			System.out.println("Month: " + minMonth);
			System.out.println("Difference: " + minValue);
		}
		
	}

}
