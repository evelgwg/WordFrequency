import java.util.List;

class Main{
  public static void main(String[] args){
	CountingWords testCase = new CountingWords(); // Instance with function testCase

	// Testcase
	List<WordFrequencyImp> listFrequency = testCase.calculateMostFrequentNWords("Hi, my name is Evelien. This is a testcase for the technical assignment WordFrequency.", 3); 
	
	WordFrequencyImp thisWord; 
	for (int i = 0; i < listFrequency.size(); i++) {
		thisWord = listFrequency.get(i);
		System.out.println("word: " + thisWord.getWord() + ", frequency: " + thisWord.getFrequency());
	}
  }
}