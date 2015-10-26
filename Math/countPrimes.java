/***
	Count Primes O(n log logn)
	Algorithm : Sieve of Eratosthenes	
***/
public class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
             primes[i] = true;
        }
        
        //we potray i< sqrt(n) as i^2 < n, as sqrt is expensive
        //for a number say 12, 2*6 and 4*3 are repetitions, which means
        //n is divisible by p => n = p*q and p <= q => p <= sqrt(n)
        //thus we cut down the run time by 0.5
        for(int i=2; i*i < n; i++){
            if(!primes[i]) continue;
            //lets for number 5, we need to mark off multiples of 5 as non-primes
            //so we start from 10 = 5*2, but 10 would ahave already been marked off
            //by the cycle of 2. So technically we need to check from i = 5 => 5^2 and
            //5^2 + 5, 5^2 +10 .... < N
            for(int j = i*i; j < n; j += i){
                primes[j] = false;
            }
        }
        
        //now count the array and all the non false entries are primes
        int count = 0;
        for(int i=2;i<n;i++){
            if(primes[i])count++;
        }
        
        return count;
    }
}