import java.io.*;
public class StringPermutation{

	static BufferedWriter output;

	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new FileReader("inputs\\StringPermutation_input.txt"));
			output = new BufferedWriter(new FileWriter("inputs\\StringPermutation_output.txt"));
			String line = "";
			while((line = br.readLine()) != null){
				line = line.trim();
				permutation(line);
			}
			output.close();
		}
		catch(IOException ex){}
	}

	static void permutation(String str){
		permutation(str, "");
	}

	static void permutation(String str, String prefix){

		try{
			if(str.length() == 0){
				output.write(prefix + "\n");
			}
			else{
				for(int i = 0 ; i < str.length() ; i++){
					String rem = str.substring(0, i) + str.substring(i+1);
					permutation(rem, prefix + str.charAt(i));
				}
			}
		}
		catch(IOException ex){}
	}
}