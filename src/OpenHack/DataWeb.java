

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWeb {
    
    public Map fetchPumps() {
    	Map bikePumps = new HashMap<String, Bikepump>();
    	JSONParser parser = new JSONParser();
    	
        // Make a URL to the web page
    	try {
            URL url = new URL("https://helsingborg.opendatasoft.com/api/records/1.0/search/?dataset=cykelpumpar");
            // Get the input stream through URL Connection
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();	
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try {
            	 
                Object obj = parser.parse(br);
                JSONObject jsonObject = (JSONObject) obj;
                
                long nhits = (Long) jsonObject.get("nhits"); 
                int numberOfPumps = (int) nhits;
                
                //JSONArray records = (JSONArray) jsonObject.get("records");
                JSONArray records = (JSONArray) jsonObject.get("records");
                
                for(int i = 0; i < records.size(); i++){
                	Map pump = (Map) records.get(i); //Each individual pump
                	
                	//recordId 
                	String recordId = pump.get("recordid").toString();
                	
                	//Cooridinates
                	Map geometry = (Map) pump.get("geometry");
                	JSONArray coordinates = (JSONArray) geometry.get("coordinates");
                	double longitude = (double) coordinates.get(0);
                    double latitude = (double) coordinates.get(1);
                    
                    
                	//Description
                    Map fields = (Map) pump.get("fields");
                    String description = fields.get("beskrivning").toString();
                    
                    //Create new pumpObject
                    Bikepump bikePump = new Bikepump(longitude, latitude, description);
                    bikePumps.put(recordId, bikePump);
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            } catch (Exception e) {
			// TODO: handle exception
		}
    	return bikePumps;
    }
}