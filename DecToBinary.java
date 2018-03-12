package projectthree;

import java.util.ArrayList;

/**
 *Class DecToBinary for stroring data into a pcm30.
 */

public class DecToBinary {
	/**
	 * method getBinary(int input)
	 * @param input to be convert in binary
	 * @return result in binary
	 */
	public static String getBinary(int input){
        int maxNum = (1<<8) -1;
        int minNum = -(maxNum+1)/2;
        if (input>maxNum || input<minNum) return "00000000";
        int toConvert = input;
        if(input<0) toConvert = maxNum+1+input;
        ArrayList<Integer> arrayBinary = new ArrayList<>();
        while (toConvert>0){
            arrayBinary.add(toConvert%2);
            toConvert/=2;
        }

        String result = "";
        for(int i=0; i<8-arrayBinary.size(); i++) result = result + "0";
        for(int i=arrayBinary.size()-1; i>=0; i--){
        	result = result + ((arrayBinary.get(i)==0)? "0":"1");
        }

        return result;
    }
}
