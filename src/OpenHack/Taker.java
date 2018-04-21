

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
	}
}
