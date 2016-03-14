/*
    Basic String compression using the counts of repeated characters
*/

import java.io.*;
public class StringCompression{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String compressed = compress(s);
        if(s.length() > compressed.length()){
            System.out.println("Original String : " + s);
            System.out.println("Compressed String : " + compress(s));
        }
        else
            System.out.println("String cannot be compressed.");
    }

    static String compress(String s){
        if(s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == prev){
                count++;
            }
            else{
                sb.append(prev + "" + Integer.toString(count));
                if(sb.length() >= s.length())
                    return s;
                count = 1;
                prev = s.charAt(i);
            }
        }
        sb.append(prev + "" + Integer.toString(count));
        if(sb.length() >= s.length())
            return s;
        return sb.toString();
    }
}
