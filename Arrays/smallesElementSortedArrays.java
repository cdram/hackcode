import java.io.*;
import java.util.*;



class KthElementSortedArrays{
		
	private static int kth(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd, int k){
		
		int aLen = (aEnd-aStart)+1;
		int bLen = (bEnd-bStart)+1;
		
		if(aLen==0) return b[bStart+k];
		if(bLen==0) return a[aStart+k];
		if(k==0) return Math.min(a[aStart], b[bStart]);
		
		//choose an element in a such that it is the middle and close to k
		//basically we need to choose two elements in the arrays, such that A[i] falls between b[j-1] & b[j]
		//which means, A[i] > B[j-1] => there are j elements less than kth in B and i elements less than than the kth in A
		//so i+j = k-1 => j = k-i-1
		int i = aLen/(aLen+bLen)*k;
		int j = k-i-1;

		int iTh = Math.min(aStart+i, aEnd);
		int jTh = Math.min(bStart+j, bEnd);
		
		if(a[iTh] > b[jTh]){
			//here the first half of the B array is discarded [0....jTH...bEnd]
			//which k gets reduced by that number of elements in the newly formed bounded array
			k = k-(jTh-bStart+1); 
			aEnd = iTh;
			bStart = jTh+1;
		}else{
			k = k-(iTh-aStart+1);
			aStart = iTh+1;
			bEnd = jTh;			
		}
		
		return kth(a,b,aStart, aEnd, bStart, bEnd, k);
	}	
	
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int[] b = {6,7,8,9};
		int k = 5;
			
		System.out.println("The " + k +" th smallest element after merge => " + kth(a, b, 0, a.length-1, 0, b.length-1, k-1));				
		
		
		int len1 = a.length;
		int len2 = b.length;
        k = (len1+len2)/2;
		
		if((len1+len2)%2==0){
		      System.out.println("Median => " +(kth(a, b, 0, len1-1, 0, len2-1, k) + 
		                    kth(a, b, 0, len1-1, 0, len2-1, k-1))/2);    
		}else{
		      System.out.println("Median => " +kth(a, b, 0, len1-1, 0, len2-1, k));    
		}
	}


}