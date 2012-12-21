import java.io.InputStream;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import org.xml.sax.InputSource;

import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;


// Language detect librarys
import com.cybozu.labs.langdetect.*;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;


import java.io.*;
import java.net.*;


import java.util.concurrent.Executors;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

class ExampleProgram {
 
  public static void main(String[] args) throws Exception {
  
    EveryDetector evr = new EveryDetector();
    InetSocketAddress addr = new InetSocketAddress("127.0.0.1",8080);
    HttpServer server = HttpServer.create(addr, 0);

    MyHandler hndl = new MyHandler();
    hndl.setDetector(evr);
    
    MyHandlerExtractContent hnd2 = new MyHandlerExtractContent();
    hnd2.setDetector(evr);
    
    MyHandlerDetectLanguage hnd3 = new MyHandlerDetectLanguage();
    hnd3.setDetector(evr);
    
    server.createContext("/",hndl);
    server.createContext("/extractcontent",hnd2);
    server.createContext("/detectlanguage",hnd3);
    server.setExecutor(Executors.newCachedThreadPool());
    server.start();
    System.out.println("Server is listening on port 8080" );
    
    
  }
}
