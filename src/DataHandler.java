import java.io.IOException;
import java.util.ArrayList;

public class DataHandler {
	ArrayList<ArrayList<String>> data;
	
	public DataHandler(String filename) throws IOException{
		data = DatParser.parse(filename);
	}
	
	/**
	 * 
	 * @param col1
	 * @param col2
	 * @return an integer signifying the row number with the minimum absolute difference between the values in col1 and col2
	 * returns -1 if no acceptable row found
	 */
	public int calcMinDiff(int col1, int col2){
		int minRow = -1;
		int minVal = Integer.MAX_VALUE;
		
		for(int i = 0; i < data.size(); i++){
			ArrayList<String> currentLine = data.get(i);
			if(currentLine.size() < col1 || currentLine.size() < col2){
				continue;
			}
			
			int currentCol1, currentCol2;
			try{
				currentCol1 = Integer.parseInt(currentLine.get(col1));
				currentCol2 = Integer.parseInt(currentLine.get(col2));
			}
			catch (NumberFormatException e){
				continue;
			}
			
			int diff = Math.abs(currentCol2 - currentCol1);
			if (diff < minVal){
				minRow = i;
				minVal = diff;
			}
		}
		
		return minRow;
	}
	
	public String rowToString(int rowNum){
		String ret = "";
		if(rowNum >= data.size() || rowNum < 0) return ret;
		
		ArrayList<String> row = data.get(rowNum);
		for(int i = 0; i < row.size(); i++){
			ret += row.get(i) + " ";
		}
		
		return ret.trim();
	}
}
