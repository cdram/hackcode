/***
    Given a string, determine if a permutation of the string could form a palindrome.
    For example, "code" -> False, "aab" -> True, "carerac" -> True.
    
    Hint:
    Consider the palindromes of odd vs even length. What difference do you notice?
    Count the frequency of each character.
    If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
***/
public class Solution {
    public boolean canPermutePalindrome(String s) {
      int[] arr = new int[256];
      Arrays.fill(arr, 0);
      int counter = 0;
      int val = -1;
      for(int i=0;i<s.length();i++){
          val = (int)s.charAt(i);
          if(arr[val] > 0){
              arr[val]--;
              counter--;
          }else{
              arr[val]++;
              counter++;
          }
      }
      return (counter<=1);
    }
}
