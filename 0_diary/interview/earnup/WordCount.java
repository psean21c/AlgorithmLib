import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCount {


	static Map<String, Integer> dictionary = new HashMap<String, Integer>();

	public WordCount() {}
	
	// remove all other non alphabetic characters ( ! - .)
	static String[] lineValidator(String[] line) {
		for (int i = 0; i < line.length; i++) {
			line[i] = line[i].replaceAll("[^a-zA-Z]", "");
		}
		return line;
	}

	
	void readWordsInFile(File file) {

		try {

			FileInputStream fstream = new FileInputStream(file);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			String[] wordArray = null;

			while ((strLine = br.readLine()) != null) {

				if (strLine.length() > 0) {

					wordArray = strLine.trim().split("\\s+");
					String[] newWordArray = lineValidator(wordArray);

					for (String word : newWordArray) {
						if (dictionary.containsKey(word)) {
							dictionary.put(word, dictionary.get(word) + 1);
						} else {
							dictionary.put(word, 1);
						}
					}
				}
			}

	        //printMap(dictionary);			
	        List<Entry<String, Integer>> sortedWords = sortedWordByCount(dictionary);
	        printList(sortedWords);			
	        br.close();
		} catch (IOException e) {
			System.out.println("file finder-:exception");

		}
	}

    static <K, V> void printList(List<Entry<K, V>> lst) {
        for(Entry<K, V> l:lst){
            System.out.println( l.getValue() + "\t\t" + l.getKey());
        	
        }
        System.out.println("-------------------------------------");
    }

	
    static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println( entry.getValue() + "\t\t" + entry.getKey());
        }
        System.out.println("-------------------------------------");
    }
    
	// Sort keys(String) by values in descending order
	static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortedWordByCount(Map<K, V> map) {
		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());
		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> word1, Entry<K, V> word2) {
				return word2.getValue().compareTo(word1.getValue());
			}
		});
		return sortedEntries;
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
            System.out.println("no arguments were given.");
		}
		
		File file = new File(args[0]);
		
		WordCount wordCount = new WordCount();
		wordCount.readWordsInFile(file);

	}

}
