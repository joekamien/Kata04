import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		printMinRow("weather.dat", 1, 2);
		printMinRow("football.dat", 6, 8);
	}
	
	public static void printMinRow(String filename, int col1, int col2) throws IOException{
		DataHandler dh = new DataHandler (filename);
		int rowNum = dh.calcMinDiff(col1, col2);
		System.out.println(dh.rowToString(rowNum));
	}

}
