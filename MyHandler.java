import java.io.*;
import java.net.*;

import java.util.concurrent.Executors;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

class MyHandler implements HttpHandler {

  private EveryDetector evr;

  public void setDetector(EveryDetector everyword) {
        this.evr = everyword;
  }
  
  public void handle(HttpExchange exchange) throws IOException {
    String requestMethod = exchange.getRequestMethod();
    if (requestMethod.equalsIgnoreCase("GET")) {
      Headers responseHeaders = exchange.getResponseHeaders();
      responseHeaders.set("Content-Type", "text/plain");
      exchange.sendResponseHeaders(200, 0);
      OutputStream responseBody = exchange.getResponseBody();            
      String s = "{\"error\":\"true\",\"message\":\"Only post is accepted\"}";      
      responseBody.write(s.getBytes());
     
      responseBody.close();
    } else if (requestMethod.equalsIgnoreCase("POST")) {
      Headers responseHeaders = exchange.getResponseHeaders();
      responseHeaders.set("Content-Type", "text/plain");
      exchange.sendResponseHeaders(200, 0);
      OutputStream responseBody = exchange.getResponseBody();
      
      
      String s = "";
      /*******************/
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
          InputStream inputStream = exchange.getRequestBody();
          if (inputStream != null) {           
             s = evr.detectLanguage( new InputStreamReader(inputStream,"UTF-8") );                      
          } else {
            s = "";
          }
        } catch (IOException ex) {
          s = "";
        } finally {
          if (bufferedReader != null) {
           try {
            bufferedReader.close();
           } catch (IOException ex) {
                s = "";
           }
          }
        }
      /*******************/
      
      if (!s.isEmpty()){ 
            
             Map<String,String> mp=new HashMap<String, String>();
             mp.put("error", "false");
             mp.put("result", s);
             responseBody.write(JSON.encode(mp).getBytes());
            
      } else {
            s = "{\"error\":\"true\",\"message\":\"Could not process\"}";
            responseBody.write(s.getBytes()); 
      }
      
           
      responseBody.close();
    }
  }
}