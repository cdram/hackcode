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