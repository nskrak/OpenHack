package OpenHack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Taker {
	public static void main(String[] args)throws IOException{
		/*
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
		System.out.println("####");
		*/
		// ^---- OLD NEW / IN PROGRESS ---v
		Map bikePumps = new HashMap<String, Bikepump>();
		DataWeb dw = new DataWeb();
		bikePumps = dw.fetchPumps();
		
		System.out.println("#### Print all Bikepumps ####\n");
		
			Iterator<Bikepump> itr = bikePumps.keySet().iterator();
		
			while (itr.hasNext()) {
				Bikepump bikePump = (Bikepump) bikePumps.get(itr.next());
				System.out.println(bikePump.getLatitude());
			}
		
		// mapTest();
		
	}
	
	
	public static void mapTest(){
		
		Map bikeP = new HashMap<String, Object>();
		
		Map attributes = new HashMap<String, Object>();
		attributes.put("Longitude", 12);
		attributes.put("Latitude", 23);
		attributes.put("Description", "A pump dude");

		
		bikeP.put("Pump A", attributes);
		
		attributes.put("Longitude", 44);
		attributes.put("Latitude", 68);
		attributes.put("Description", "Another pump dude");
		
		bikeP.put("Pump B", attributes);

		System.out.println(bikeP);
		
		System.out.println("#####");
		

		
		
		
	}
}
