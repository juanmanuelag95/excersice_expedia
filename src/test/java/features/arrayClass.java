package features;

import java.util.Arrays;

public class arrayClass {

	public static void main(String[] args) {
		int[] arr = {13, 7 , 6 }; 
		  
        Arrays.sort(arr);        
        
        // verify array
        //boolean value = arrayIsOk(arr);
        //System.out.println(value);
        
        // greater
        //boolean value = greaterAsExpected(arr[arr.length - 1], 7);
        //System.out.println(value);
        
	}

	private static boolean greaterAsExpected(int i, int j) {
		if (i == j) 
			return true;
		else
			return false;
	}

	private static boolean arrayIsOk(int[] arr) {
		// 6, 7, 13 , 45
		int[] arrExpected = {6, 7, 13, 45}; 
	
		if (Arrays.equals(arr, arrExpected))
			return true;
		else 
			return false;
	}
}
