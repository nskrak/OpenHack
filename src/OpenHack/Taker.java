

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Taker {
	public static void main(String[] args)throws IOException{
		
		Map bikePumps = new HashMap<String, Bikepump>();
		DataWeb dw = new DataWeb();
		bikePumps = dw.fetchPumps();
		
		System.out.println("#### Print all Bikepumps ####\n");
		
		Iterator<Bikepump> itr = bikePumps.keySet().iterator();
		
		while (itr.hasNext()) {
			Bikepump bikePump = (Bikepump) bikePumps.get(itr.next());
			System.out.println(bikePump.getDescription());
		}
		
		/* Skriva ut för parking */
		
		Map parkLots = new HashMap<String, Parkings>();
		parkLots = dw.fetchParks();
		
		System.out.println("#### Print all ParkingLots ####\n");
			
		Iterator<Parkings> itr2 = parkLots.keySet().iterator();
		
		while (itr2.hasNext()) {
			Parkings parkLot = (Parkings) parkLots.get(itr2.next());
			System.out.println(parkLot.toString());
		}
	}
}
