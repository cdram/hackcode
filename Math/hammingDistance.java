class Hamming{
 
  public static int[] convertBinary(int num){
     int binary[] = new int[32];
     int index = 0;
     while(num > 0){
       binary[index++] = num%2;
       num = num/2;
     }
	 
     for(int i = index;i < binary.length;i++){
		 binary[i] = 0;
     }
	 return binary;
  }
 
  public static void main(String a[]){
	  int num1 = 7;
	  int num2 = 12;
	  int hamming = 0;
	  
	  int[] numB1 = convertBinary(num1);
	  int[] numB2 = convertBinary(num2);
	
	  for(int i = numB1.length-1;i>=0;i--){
		  System.out.print(numB1[i]);
	  }
	  		  System.out.println();
	  
	  for(int i = numB2.length-1;i>=0;i--){
		  System.out.print(numB2[i]);
	  }
		  
	  for(int i = 0;i<numB1.length;i++){
		  if(numB1[i] != numB2[i]) hamming++;
	  }
	  
	  System.out.println();
	 
	  System.out.println("Hamming Distance => " + hamming);	  
  }
  
  
}