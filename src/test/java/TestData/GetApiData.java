package TestData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetApiData {
	  String code="";
	public  String getContenxtWeb(String urlS) {
	   
	
		String pagina = "", devuelve = "";
	  
	    URL url;
	    try {
	    
	    	url = new URL(urlS);
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
	    	System.out.println("here is");
	    	  System.out.println(conexion.getResponseCode());
	        code=Integer.toString(conexion.getResponseCode());
	        System.out.println("Response of api is"+code);
	        
	        if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK || conexion.getResponseCode() == HttpURLConnection.HTTP_CREATED ) {
	            BufferedReader reader = new BufferedReader(
	                    new InputStreamReader(conexion.getInputStream()));
	            String linea = reader.readLine();
	          //  System.out.println("this is linea"+linea);
	            while (linea != null) {
	                pagina += linea;
	                linea = reader.readLine();
	            }
	            reader.close();

	            devuelve = pagina;
	        } else {
	        	 conexion.disconnect();
	            return code;
	        }
	        conexion.disconnect();
//	        System.out.println("Response:"+devuelve);
	        return code;
	       
	    } catch (Exception ex) {
	        return code;
	    }
	}
}
