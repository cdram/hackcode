public class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1.0;
        if(n <0){
            x = 1/x;
            n = Math.abs(n);
        }
        double ret = 1.0;
        while(n > 0){
            if(n%2!=0) ret *= x;
            x *= x;
            n>>=1;
        }
        
        return ret;
    }
}