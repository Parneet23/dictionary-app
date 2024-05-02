import java.util.*;
import java.io.*;
public class Dictionary {
    public Dictionary() throws IOException{
            wordWithDef=new HashMap<String, String>();
            iterateFile();
    }
    public void fillDictionary(String key, String value) {
            if(!wordWithDef.containsKey(key)) {
                wordWithDef.put(key, value);
            }
    }
    public void iterateFile() throws IOException{
        BufferedReader buffReader=new BufferedReader(new FileReader("C:\\Users\\dellf\\University\\2nd Sem\\ASP\\Project\\input.txt"));
        String data;
        while((data = buffReader.readLine()) != null) {
            int index=data.indexOf(" ");
            String mapKey=data.substring(0, index);
            String mapValue=data.substring(index+1);
            fillDictionary(mapKey, mapValue);
        }
        buffReader.close();
    }
    public void findInDictionary(String input) throws IOException {
            for(Map.Entry<String, String> iterator : wordWithDef.entrySet()) {
                    if(iterator.getKey().toLowerCase().contains(input.toLowerCase())) {
                        System.out.println("Key: " + iterator.getKey() + " Value: " + iterator.getValue() + " found in Dictionary");
                        return;
                    } 
            }
            System.out.println("Sorry, cannot find " + input + " in dictionary");
    }
    public static void main(String [] args) throws IOException {
        Dictionary dictionary=new Dictionary();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("Enter word you want to search in dictionary else exit if you want to end the program");
            String userInput=sc.next();
            if(userInput.toLowerCase().equals("exit")) {
                System.out.println("Okay, Bye!");
                return;
            }
            dictionary.findInDictionary(userInput);
        }
    }
    HashMap<String, String> wordWithDef;
}