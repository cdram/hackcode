/***
	There is a hypothesis floating around that SAT score is a strong indicator of GPA. Your task is to provide the strongest counter example for this hypothesis. Given a data set of 	(sat, gpa) for the final year of a group of students, devise an algorithm to construct the longest sequence of (sati, gpai) of students with progressively better SAT scores, and 	progressively worse gpa’s, i.e. sat1 < sat2 < … < satk and gpa1 > gpa2 > … > gpak ( Assume SAT scores and gpa’s are unique )
***/

import java.io.*;
import java.util.*;


class Score{
	int sat;
	double gpa;
	
	public Score(int sat, double gpa){
		this.sat = sat;
		this.gpa = gpa;
	}
	
	@Override
	public String toString(){
		return ("sat: " + sat + " gpa: " + gpa);
	}
}


class SatGpa{
	
	private static boolean check(List<Score> scores, int low, int high){
		Score u = scores.get(low);
		Score v = scores.get(high);
		return (u.sat < v.sat && u.gpa > v.gpa);
	}
	
	private static void processData(List<Score> scores){
		int currentStart = 0, start = 0, end = 0;
		int maxLen = 1, low = 0;
		int high = 1;
		
		
		for(int i=1;i<scores.size();i++){
			currentStart = low = i-1;
			high = i;
			while(high < scores.size() && check(scores, low, high)){
				high++;	
				low++;
			}
			
			if(low - currentStart +1 > maxLen){
				maxLen = low - currentStart +1;
				start = currentStart;
				end = low;
			}		
		}
		
		System.out.println("\nLongest Monotonic 2D Subsequence");
		System.out.println("---------------------------------");
		for(int i=start;i<=end;i++){
			System.out.println(scores.get(i).toString());
		}
	}
	
	
	public static void main(String args[]){
		
		
		int satMax = 2400;
		double gpaMax = 4.0;
		List<Score> scores = null;
		
		scores = new ArrayList<>(Arrays.asList(new Score(260,1.3), new Score(2000,3.34), new Score(2100,3.21), new Score(2300,3.00), new Score(2400,4.0)));
		System.out.println("Scores");
		System.out.println("----------");
		for(int i=0;i<scores.size();i++){			
			System.out.println(scores.get(i).toString());
		}
		processData(scores);		
		
		
		scores = new ArrayList<>(Arrays.asList(new Score(260,1.3), new Score(327,2.93), new Score(2305,3.44), new Score(1341,2.72)));
		System.out.println("\nScores");
		System.out.println("----------");
		for(int i=0;i<scores.size();i++){			
			System.out.println(scores.get(i).toString());
		}
		processData(scores);		
		
	}

}