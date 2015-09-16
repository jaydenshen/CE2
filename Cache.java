import java.util.ArrayList;
import java.util.Collections;


public class Cache {
	
	static ArrayList<String> cache; 
	
	public Cache(){
		
		cache = new ArrayList<String>();
		
		
	}
	public static ArrayList<String> getCache(){
		
		return cache;
	}
	public void addToCache(String information){
		
		cache.add(information);
	}
	
	public void clearCache(){
		
		cache.clear();
	}
	
	public boolean checkValidLine(String lineIndex){
		
		try{
			int deleteLineIndex = Integer.parseInt(lineIndex.replaceAll(
					"\\s+", ""));
			if(deleteLineIndex > cache.size()){
				
				return false;
			}else{
				
				return true;
			}
		}
		catch(NumberFormatException e){
			
			return false;
		}
	}
	
	public void sort(){
		
		Collections.sort(cache);
	}
	
	public String deleteLine(String lineIndex){
		
		int deleteLineIndex = Integer.parseInt(lineIndex.replaceAll(
				"\\s+", "")) - 1;
		String deleteLine = cache.get(deleteLineIndex);
		cache.remove(deleteLineIndex);
		return deleteLine;
	
	}
}
