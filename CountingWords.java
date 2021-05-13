//imports 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

//interface WordFrequencyAlalyzer
interface WordFrequencyAnalyzer{
  public int HighestFrequency(String text); 
  public int FrequencyForWord(String text, String word);
  public List<WordFrequencyImp> calculateMostFrequentNWords (String text, int n);
}

//class CountingWords implements the interface
class CountingWords implements WordFrequencyAnalyzer { 

	public int HighestFrequency(String text){  //find the highest frequency within a string
		HashMap<String, Integer> hashMap = new HashMap<>();
		HashMap.Entry<String,Integer> maxValue = null;
		String[] words = text.toLowerCase().split("\\s+"); 

		for (int i = 0; i < words.length; i++){
			String word = words[i];
			if (hashMap.containsKey(word)){
				int currentCount = hashMap.get(word);
				hashMap.put(word, currentCount + 1);
			} else {
				hashMap.put(word, 1);
			}
		}
		
		for (HashMap.Entry<String,Integer> value:hashMap.entrySet()){
			if (maxValue == null || value.getValue().compareTo(maxValue.getValue()) >0){
				maxValue = value;
			}
		} return maxValue.getValue();
	}

 	public int FrequencyForWord(String text, String word){ 	// Find frequency of given word in string 
		String[] words = text.toLowerCase().split("\\s+");
		word = word.toLowerCase();
		int count = 0;
		for (int i = 0; i < words.length; i++){ //count frequency for given word 
			if (word.equals(words[i])){
				count++; 
			}
		} return count;
	}
	
	public List<WordFrequencyImp> calculateMostFrequentNWords (String text, int n){ //create list of n number of highest frequency values
		HashMap<String, Integer> hashMap = new HashMap<>(); // empty hashmap 
		String[] words = text.toLowerCase().split("\\s+"); 
		
		for (int i = 0; i < words.length; i++){ //turn list into hashmap 
			String word = words[i];
			if (hashMap.containsKey(word)) {
				int currentCount = hashMap.get(word);
				hashMap.put(word, currentCount + 1); 
			} else {
				hashMap.put(word, 1);
			}
		}
		
		List<WordFrequencyImp> listFrequency = new ArrayList<>(); //create empty list
		for (HashMap.Entry<String,Integer> entry:hashMap.entrySet()){ //turn hashmap values into objects and add to empty list 
			WordFrequencyImp wordObject = new WordFrequencyImp(entry.getKey(), entry.getValue());
			listFrequency.add(wordObject);
		}
		Collections.sort(listFrequency); //sort objects in list 
		return listFrequency.subList(0, n); 
	}
	
}