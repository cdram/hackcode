public class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1.0;
        if(n <0){
            x = 1/x;
            n = Math.abs(n);
        }
        double temp = myPow(x, n/2);
        return (n%2==0)?temp*temp:temp*temp*x;
    }
}