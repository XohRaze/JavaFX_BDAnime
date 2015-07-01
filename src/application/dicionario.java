package application;

import java.util.HashMap;
import java.util.Map;



public class dicionario {
	
	public static Map<Integer,Anime> listAnimes = new HashMap<Integer,Anime>();
	
	
	public static void setlistAnimes(Anime anime){
		listAnimes.put(listAnimes.size()+1,anime);
		
	}

}
