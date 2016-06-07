package core.codechef.medium;

/**
 *  Rohit dreams he is in a shop with an infinite amount of marbles. 
 *  He is allowed to select n marbles. There are marbles of k different 
 *  colors. From each color there are also infinitely many marbles. Rohit 
 *  wants to have at least one marble of each color, but still there are 
 *  a lot of possibilities for his selection. In his effort to make a 
 *  decision he wakes up. Now he asks you how many possibilities for his
 *  selection he would have had. Assume that marbles of equal color can't 
 *  be distinguished, and the order of the marbles is irrelevant.
 *  
 *  Input
 *  The first line of input contains a number T <= 100 that indicates the 
 *  number of test cases to follow. Each test case consists of one line
 *   containing n and k, where n is the number of marbles Rohit selects 
 *   and k is the number of different colors of the marbles. 
 *   You can assume that 1<=k<=n<=1000000.
 *   
 *  Output
 *  For each test case print the number of possibilities that Rohit would have had. 
 *  You can assume that this number fits into a signed 64 bit integer.
 *  
 *  Example
 *  Input:
 *  2
 *  10 10
 *  30 7
 *  Output:
 *  1
 *  475020
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Marbles {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		//for every test case
		for ( int t = 0; t < T; t++ ) {
			String[] arr = br.readLine().trim().split(" ");
			long N = Long.parseLong(arr[0]);
			Long K = Long.parseLong(arr[1]);
			
			
			N = N - K;
			System.out.println( calculateCombination(N + K - 1, K - 1) );
		}
	}
	
	public static long calculateCombination(long N, long R) {
		if(R > N / 2) 
			R = N - R; // because C(n, r) == C(n, n - r)
	    long answer = 1;
	    
	    for(int i = 1; i <= R; i++) {
	        answer *= N - R + i;
	        answer /= i;
	    }
	    return answer;
		
	}
}