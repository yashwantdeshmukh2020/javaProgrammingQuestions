import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map.Entry;
import java.util.Scanner;
 /**
  * 
  * @author Yashwant
  *write a code to scan a text file using File I/O. 
  *provideUniqueList Of words
  *provide list of words with repetitive count from file
  *Make use of Java Collection Framework
  */
public class FileProcessorUtil {
	private static Logger log = Logger.getLogger(FileProcessorUtil.class.getName());
     
    public Map<String, Integer> processFile(String fileName, List<String> distinctWordList){
 
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();       
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, " .,;:\"");
                while(st.hasMoreTokens()){
                    String tmp = st.nextToken().toLowerCase();
                    if(wordMap.containsKey(tmp)){
                        wordMap.put(tmp, wordMap.get(tmp)+1);
                    } else {
                        wordMap.put(tmp, 1);
                        distinctWordList.add(tmp);
                    }
                }
            }
        } catch (FileNotFoundException e) {
        	log.log(Level.SEVERE , e.getMessage());
        } catch (IOException e) {
        	log.log(Level.SEVERE , e.getMessage());
        } finally{
        	try {
        		if (br != null)
        			br.close();
        	} catch (Exception e) {
        		log.log(Level.SEVERE , e.getMessage());
        	}
        }	
        return wordMap;
    }
     
    public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap){
         
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return list;
    }
     
    public static void main(String a[]){
    	FileProcessorUtil fpu = new FileProcessorUtil();
        List<String>  wordList=new ArrayList<String>();
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter complete File Path");
        String fileName = sc.nextLine();
        //Sample input - F:/CreditSuisse.txt
        Map<String, Integer> wordMap = fpu.processFile(fileName, wordList);
        //To sort in desecending order - most repeated word First
        List<Entry<String, Integer>> list = fpu.sortByValue(wordMap);
   
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
       for (String distinctWord : wordList) {
			System.out.println(distinctWord);
		}
    }
}