public class ReplaceSpace{
	public static void main(String args[]){
		char[] str = "a bbb bj       ".toCharArray();
		System.out.println(str.length);
		String newString = replace(str, 9);
		System.out.println(newString);


	}

	static String replace(char[] strarray, int length){

		int spaceCount = 0;
		for (int i = 0 ; i < length ; i++){
			if(strarray[i] == ' '){
				spaceCount++;
			}
		}

		int lastIndex = length + spaceCount*2 - 1;

		for (int i = length - 1 ; i >= 0 ; i--){
			if(strarray[i] == ' '){
				strarray[lastIndex] = '0';
				strarray[lastIndex - 1] = '2';
				strarray[lastIndex - 2] = '%';
				lastIndex -= 3;
			}
			else{
				strarray[lastIndex] = strarray[i];
				lastIndex--;
			}
		}

		return String.valueOf(strarray);
	}
}