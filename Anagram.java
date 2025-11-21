/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// // Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// // Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");

	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		int len_str1 = str1.length();
		int len_str2 = str2.length();
		boolean is_anagram = true;
		for (int i = 0; i < len_str1; i++){ // loops on all the letters of string1.
			char letter_1 = str1.charAt(i);
			for (int r = 0; r < len_str2; r++){ // loops on the letters of string2.
				char letter_2 = str2.charAt(r);
				if (letter_1 == letter_2){ // checks if letter1 matches any letter from string2.
					is_anagram = true;
					break;
				}else {
					is_anagram = false;
				}
			}if (is_anagram == false){ // if letter1 doesnt match any from string2 break - not an Anagram.
				break;
			}
		}
		return is_anagram;
	}
	

	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int len = str.length();
		String final_string = "";
		for (int i = 0; i< len; i++){
			char letter = str.charAt(i);
			// if capital letter
			if (letter >= 65 && letter <=90) {
				letter = (char) (letter + 32);
				final_string = final_string + letter;
			}
			// if non capital letter
			else if (letter >= 97 && letter <=122){
				final_string = final_string + letter;
			}
		}
		return final_string;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int len = str.length();
		int random_index = (int) ((Math.random() * len)); // gets a randome number in the range if the string.
		String final_word = "";
		char letter = str.charAt(random_index); // gets the letter in the random index.
		str = str.substring(0, random_index) + str.substring(random_index+1); // removes the randomized letter.
		// changes the order of the letter to create an Anagram.
		if (random_index != 0){ 
			final_word = letter + str;
		}
		else {
			final_word = str + letter;
		}
		return final_word;
	} 
}
