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


public class EveryDetector { 

    public Detector detector;

    public EveryDetector() {
        try {
            DetectorFactory.loadProfile("profiles/");
            
        } catch (LangDetectException e) {
                System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    public String detectLanguage(String filepath)
    {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            InputStreamReader in = new InputStreamReader(fis, "UTF-8");
            String html = ArticleExtractor.INSTANCE.getText(in);
            
            detector = DetectorFactory.create(0.5);
            detector.append(html);                        
            return html+"[SEP_DATA_ITEM]"+detector.getProbabilities();            
        } catch (Exception e) {
        
        }       
        
        return "";
    }
    
    public String detectLanguage(InputStreamReader stremreader)
    {
        try {            
            String html = ArticleExtractor.INSTANCE.getText(stremreader);            
            detector = DetectorFactory.create(0.5);
            detector.append(html);                        
            return html+"[SEP_DATA_ITEM]"+detector.getProbabilities();            
        } catch (Exception e) {
        
        }       
        
        return "";
    }
    
    public String detectLanguageFromText(InputStreamReader stremreader)
    {
        try {     
            detector = DetectorFactory.create(0.5);
            detector.append(stremreader); 
            String html = ""+detector.getProbabilities();                       
            return html;            
        } catch (Exception e) {
        
        }       
        
        return "";
    }
    
    public String extractContent(InputStreamReader stremreader)
    {
        try {            
            String html = ArticleExtractor.INSTANCE.getText(stremreader); 
            return html;            
        } catch (Exception e) {
        
        }       
        
        return "";
    }
    
}