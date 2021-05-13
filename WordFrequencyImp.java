//WordFrequency interface
interface WordFrequency {
	public String getWord();
	public int getFrequency();
	public int compareTo(WordFrequencyImp otherWordFrequency);
}

//create class WordFrequency
class WordFrequencyImp implements WordFrequency, Comparable<WordFrequencyImp>{
	private String word;
	private int frequency;
	
	//create constructor
	WordFrequencyImp(String word, int frequency){
		this.word = word;
		this.frequency = frequency;
	}
	
	//return word and frequency	
	public String getWord(){
		return this.word;
	}
	public int getFrequency(){
		return this.frequency;
	}
	
	@Override  // Override the 'regular' way of comparing things 
	public int compareTo(WordFrequencyImp otherWordFrequency){
		if (this.frequency > otherWordFrequency.frequency){
			return -1;
		} else if (this.frequency < otherWordFrequency.frequency){
			return 1;
		} else {
			return this.word.compareTo(otherWordFrequency.getWord()); // sort based on alphabetic order if frequencies are equal
		}
	}
}