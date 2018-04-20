import java.io.IOException;

public class Taker {
	public static void main(String[] args)throws IOException{
		Object[][] xy = DataWeb.coords();
		double[][] corr = new double[xy.length][xy[0].length];
		String s;
		double d;
		for(int i = 0; i < xy.length; i++){
			for(int j = 0; j < xy[0].length; j++){
			s = xy[i][j].toString();
			d = Double.parseDouble(s);
			corr[i][j] = d;
			}
		}
		
		for(int i = 0; i < xy.length; i++){
			System.out.println("");
			for(int j = 0; j < xy[0].length; j++){
				System.out.print(corr[i][j] + " ");
				
			}
		}
		
	}
}
