
/*
    Find if two strings are one edit away (insert / remove / replace one character)
*/

import java.io.*;
public class OneEditAway{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        String s1 = first.length() < second.length() ? first : second ;
        String s2 = first.length() < second.length() ? second : first ;

        if(OneEditAway(s1,s2))
            System.out.println("One Edit Away");
        else
            System.out.println("Not one Edit Away");
    }

    static boolean OneEditAway(String s1, String s2){
        if(s2.length() - s1.length() >= 2)
            return false;

        int index1 = 0 , index2 = 0;
        boolean diff = false;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(diff){
                    return false;
                }
                diff = true;

                if(s1.length() == s2.length()){
                    index1++;
                }
            }
            else{
                index1++;
            }
            index2++;
        }
        return true;
    }
}
