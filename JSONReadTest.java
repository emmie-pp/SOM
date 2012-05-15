
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.*;


public class JSONReadTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		try {
			JsonReader reader = 
				new JsonReader(new BufferedReader(new FileReader("user.json")));
			//Type listType = new TypeToken<LinkedList<Doc>>() {}.getType();
			//LinkedList<Doc> docs= gson.fromJson(reader, listType);			
			Type listType = new TypeToken<Doc[]>() {}.getType();									
			Doc[] docs= gson.fromJson(reader, listType);			
			 Doc first = docs[0];
			 System.out.println(first.toString());       
			 
		} catch (IOException ex) {
		  ex.printStackTrace();
		}
	}
	class Doc {
		private String docID;
		private HashMap<String, String[]> terms;
		
		@Override
		public String toString (){
			String val = "docID: " + docID + "\n";
			val += "terms :" ;
			int tnum = terms.size();
			for (String term: terms.keySet()) {
				val += "term:" + term + "\n";
				for (String attr :terms.get(term)){
					val += ("\t" + attr + "\n"); 
				}
			}
			return val;
		}
	}
}
