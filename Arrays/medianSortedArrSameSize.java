/***
Median of Two Sorted Arrays of the Same Length
Algorithm: 
	1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
	2) If m1 and m2 both are equal then we are done, and return m1 (or m2)
	3) If m1 is greater than m2, then median is present in one of the below two subarrays.
	  a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
	  b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
	4) If m2 is greater than m1, then median is present in one of the below two subarrays.
	  a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
	  b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
	5) Repeat the above process until size of both the subarrays becomes 2.
	6) If size of the two arrays is 2 then use below formula to get the median.
	Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
***/

public class Solution {
    
    private double findMedian(int[] arr, int start, int end){
        int mid = (start+end)/2;
        if(((end-start)+1)%2==0){
            return (arr[mid]+arr[mid+1])/2;
        }else{
           return (double)arr[mid]; 
        }
    }
    
    private int findMedianIndex(int[] arr, int start, int end){
        int mid = (start+end)/2;
        return mid;
    }
    
    private double medianHelper(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2){
        if((end1-start1) + 1 == 1 && (end2-start2) + 1 == 1) return (nums1[start1] + nums2[start2])/2;
        if((end1-start1) + 1 == 2 && (end2-start2) + 1 == 2) {
            System.out.println("here" + start1 + " " + end1 +" " + start2 + " " + end2);
            return (double)(Math.max(nums1[start1],nums2[start2])+Math.min(nums1[end1],nums2[end2]))/2;
        }
        
        double m1 = findMedian(nums1, start1, end1);
        double m2 = findMedian(nums2, start2, end2);
        
        if(m1 == m2) return m1;
        if(m1 < m2){
            boolean f = (((end2-start2)+1)%2==0);
            int index = findMedianIndex(nums2, start2, end2);
            return medianHelper(nums1, nums2, findMedianIndex(nums1, start1, end1), end1, 0, (f)?index+1:index);
        }else {
            boolean f = (((end1-start1)+1)%2==0);
            int index = findMedianIndex(nums1, start1, end1);
            return medianHelper(nums1, nums2, 0, (f)?index+1:index, findMedianIndex(nums2, start2, end2), end2);
        }
    }
    
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length ==0 && nums2.length==0) return 0;
        if(nums1.length ==0 ) return findMedian(nums2,0, nums2.length-1);
        if(nums2.length ==0 ) return findMedian(nums1,0, nums1.length-1);
        return medianHelper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }
}