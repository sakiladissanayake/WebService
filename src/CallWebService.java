import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;



public class CallWebService {

	public static void main(String[] args) {
	}
	
	public String callWebService(String endPoint, String apiTemplate)
	    {
		 String response;
	        try
	        {	  
	            //API Call
	            URL url = new URL(endPoint);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setDoOutput(true);
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/xml");
	            
	            String input = apiTemplate;
	            OutputStream os = conn.getOutputStream();
	            os.write(input.getBytes());
	            os.flush();
	          
	            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	            response = br.readLine();
	            
	            while ((response = br.readLine()) != null)
	            {
	                
	            }
	            conn.disconnect();

	           
	        }
	        catch (Exception e)
	        {     
	            StringWriter errors = new StringWriter();
	            e.printStackTrace(new PrintWriter(errors));
	            response = errors.toString();
	        }
			return response;
	    }

}
