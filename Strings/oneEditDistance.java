

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() ==0 && t.length() ==0) return false;
        if(s.length() > t.length()) return isOneEditDistance(t, s);
        if(s.length()==0) return (t.length()-s.length()==1);
        
        int i=0, j=0, counter=0;
        
        while(i < s.length() && j <t.length()){
            if(s.charAt(i) != t.charAt(j)){
                counter++;
                if(counter > 1) return false;
                if(t.length()!=s.length())i--;
            }
            i++;
            j++;
        }
        
        return ((counter==1 && t.length()-s.length()==1) || t.length()-s.length()+counter==1);
    }
}