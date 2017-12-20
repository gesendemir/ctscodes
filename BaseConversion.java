package basecon;


/**
 * Monitored Assignment 1
 * 
 * 
 * @authors
 * Chernet Ayele Lole
 * Emmanuel Osei-oppong
 * Hasan Güney Esendemir
 * 
 */


public class Converting {

	public static void main(String[] args) {
		System.out.println(toString(528, 15));
		System.out.println(toInt("1011",2));
	}
	public static String toString(int value, int radix){
			//Validity check for radix and number.
			if(radix < 2 || radix > 16)	return "Radix should be between 2 and 16";
			if(value < 0) return "Value should be equal or bigger than 0";
		
		//Create an array for digits.
		char NumberArray[] = {'0', '1', '2','3','4','5','6' ,'7','8','9', 'A', 'B','C','D','E','F'};
		int rem;
		String finals;
		String temp = "";
		//Find remainders and put them together.
		while(radix < value){
			rem = value % radix;
			temp = NumberArray[rem] + temp;
			value = value / radix;
		}
		//Find the last result and put it to string.
		if(value < radix){
			temp = NumberArray[value] + temp; 
		//If the last result is equal to radix we should put "10" to head of string.
		}else if(value == radix){
			temp = "10" + temp;
		}
		//Create a final string. Return it.
		finals = temp;
		return finals;
	}
	
	public static int toInt(String str, int radix) {
		//Validity check for radix and negative numbers.
	    if(radix < 2 || radix > 16) return -1;
        if (str.charAt(0) == '-') return -1; 

        int temp = 0;
        int total = 0;
        int pow = 0;
        //Make all string to Uppercase.
        str = str.toUpperCase();
        for(int i = str.length() - 1; i > -1; i--, pow++){
            char c = str.charAt(i);
            //For digits between '0' and '9'
            if (c >= '0' && c <= '9')
            	{
            	//Convert character to int by substracting "0" according to ASCII table.
                temp = c - '0'; 
                //Check if the current number is equal to base.. 
                if(temp == radix) return -1;

           //For Digits between 'A' and 'F'     
           }else if (c >= 'A' && c <= 'F')
           		{
        	 //Convert character to int by substracting "A" according to ASCII table.
        	   temp = 10 + (c - 'A');
        	   //Check if the current number is equal to base.
               if(temp == radix) return -1;
           }
           //Add current value to total.
           total += temp * power(radix,pow);
            //pow++;
        }return total;
    }
    
    public static int power(int x, int exponent) {

    int result = 1;
    for (int i = 0; i < exponent; ++i)
        result *= x;

    return result;

    }

}
