import java.util.*;

public class PermutationPalindrome{
	public static void main(String args[]){
		System.out.println(perm_palindrome("abccacc"));

	}

	static boolean perm_palindrome(String str){
		if(str == null || str.isEmpty()){
			return true;
		}

		str = str.toLowerCase();
		str = str.replaceAll("\\s+","");

		int oddCount = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			Character c = new Character(ch);

			if(map.get(c) == null){
				map.put(c, 1);
				oddCount++;
			}
			else{
				int value = map.get(c);
				map.put(c, value + 1);
				if((value + 1) % 2 == 0)
					oddCount--;
				else
					oddCount++;
			}
		}

		if(oddCount > 1){
			return false;
		}

		return true;
	}
}