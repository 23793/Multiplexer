package projectthree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * main class
 * @author gaitannana
 *
 */

public class UserInterface {
	private static boolean debug = false;
    private static ArrayList<String> checkInput = new ArrayList<>();

    /**
     * main method
     * @param args main method
     */
    public static void main(String[] args) {
    	ArrayList<Integer> finalList = new ArrayList<Integer>(); 
        Scanner sc = new Scanner(System.in);
        ArrayList<PCM30> muxList = new ArrayList<>();
        fillValidInput();

        String inputValues="Q";
        String[] parts = inputValues.split(" ");
        
        do {
            do{
                if (!checkInput.contains(parts[0])) {
                	System.out.println("Wrong Input");
                }
                System.out.print("Input: ");
                inputValues = sc.nextLine();
                if(debug) System.out.println("DEBUG-MAIN: input = "+inputValues);
                if(!isValidInput(inputValues)) inputValues="oopjava";
                else if(debug) {
                	System.out.println("DEBUG-MAIN: input is valid");
                }
                parts = inputValues.split(" ");
            } while (!checkInput.contains(parts[0]));

            if (parts[0].equals("mux")){
                if(debug) System.out.println("DEBUG-MAIN: mux function");
                if(muxList.size()==0) {
                	System.out.println("Please create multiplexer");
                }else{
                	int muxSize = muxList.size();
                    ArrayList<ChannelClass> channelList=
                        muxList.get(muxSize-1).getChannelList();
                    System.out.print("|");
                    for(int i=0; i< channelList.size(); i++){
                   
                    	System.out.print(channelList.get(i).getBinary()
                    			+" Channel "+i+"|");
                    }
                    System.out.println();
                    for(int i=0; i<finalList.size(); i++){
                        System.out.print(finalList.get(i)+" ");
                    }
                    System.out.println();
                }
            }else if (parts[0].equals("create")){
                if(debug) System.out.println("DEBUG-MAIN: create function");
                String[] parts2 = parts[1].split(":");
                if(parts2[0].equals("ATDM") || parts2[0].equals("CDM")){
                    System.out.println("This type is not implemented");
                }else if (parts2[0].equals("STDM")){
                	int help=Integer.parseInt(parts2[1]);
                    muxList.add(new PCM30(parts2[0],help));
                    System.out.println(parts2[0]+" multiplexer created");
                }else{
                    inputValues="blabla";
                    parts = inputValues.split(" ");
                }
            }else if (parts[0].equals("assign")){
                if(debug) System.out.println("DEBUG-MAIN: assign function");
                if(muxList.size()==0){
                    System.out.println("Please create multiplexer");
                }else{
                    String[] parts2 = parts[1].split(":");
                    int channelID = Integer.parseInt(parts2[0]);
                    int inputID = Integer.parseInt(parts2[1]);
                    int muxSize = muxList.size();
                    muxList.get(muxSize-1).assignChannel(channelID,inputID);
                    System.out.println("Assignment created");
                }
            }else if (parts[0].equals("refer")){
                if(debug) System.out.println("DEBUG-MAIN: refer function");
                if(muxList.size()==0){
                    System.out.println("Please create multiplexer");
                }else{
                    String[] parts2 = parts[1].split(":");
                    int channelID = Integer.parseInt(parts2[0]);
                    int outputID = Integer.parseInt(parts2[1]);
                    int muxSize = muxList.size();
                    muxList.get(muxSize-1).assignOutput(channelID, outputID);
                    System.out.println("Assignment created");
                }
            }else if (parts[0].equals("input")){
                if(debug) System.out.println("DEBUG-MAIN: input function");
                if(muxList.size()==0){
                    System.out.println("Please create multiplexer");
                }else{
                    String[] parts2 = parts[1].split(":");
                    int value = Integer.parseInt(parts2[0]);
                    int inputID = Integer.parseInt(parts2[1]);
                    int muxSize = muxList.size();
                    muxList.get(muxSize-1).assignValue(value,inputID);
                    finalList.add(value);
                    System.out.println("Value assigned");
                }
            }else if(!parts[0].equals("q") && !parts[0].equals("Q")) {
                if(debug) System.out.println("DEBUG-MAIN: wrong value");
                inputValues="oopjava";
                parts = inputValues.split(" ");
            }

        }while (!parts[0].equals("q") && !parts[0].equals("Q"));
    }

    private static boolean isValidInput(String Input){
        if(debug) System.out.println("DEBUG-MAIN: isValidInput()");
        String[] parts = Input.split(" ");
        if(!checkInput.contains(parts[0])) return false;
        if (parts[0].equals("mux") && parts.length ==1) return true;
        if (parts[0].equals("create") && parts.length ==2 && parts[1].contains(":")){
            String[] parts2 = parts[1].split(":");
            if( parts2.length!=2) return false;
            if(isInteger(parts2[0],10) || !isInteger(parts2[1],10)) return false;
            return true;
        }
        if (parts[0].equals("assign") && parts.length ==2 && parts[1].contains(":")){
            String[] parts2 = parts[1].split(":");
            if( parts2.length!=2) return false;
            if(!isInteger(parts2[0],10) || !isInteger(parts2[1],10)) return false;
            return true;
        }
        if (parts[0].equals("refer") && parts.length ==2 && parts[1].contains(":")){
            String[] parts2 = parts[1].split(":");
            if( parts2.length!=2) return false;
            if(!isInteger(parts2[0],10) || !isInteger(parts2[1],10)) return false;
            return true;
        }
        if (parts[0].equals("input") && parts.length ==2 && parts[1].contains(":")){
            String[] parts2 = parts[1].split(":");
            if( parts2.length!=2) return false;
            if(!isInteger(parts2[0],10) || !isInteger(parts2[1],10)) return false;
            return true;
        }
        if (parts[0].equals("q") || parts[0].equals("Q")) return true;
        return false;
    }

    private static void fillValidInput(){
        if(debug) System.out.println("DEBUG-MAIN: fillValidInput()");
        checkInput.add("q");
        checkInput.add("Q");
        checkInput.add("mux");
        checkInput.add("create");
        checkInput.add("assign");
        checkInput.add("input");
        checkInput.add("refer");
    }

    private static boolean isInteger(String s, int radix) {
        if(debug) System.out.println("DEBUG-MAIN: isInteger()");
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    
    /**
     * method BinaryToDecimal.
     * @param binary to be convert in to decimal
     * @return decimal value of binary
     */
    public static int binaryToDecimal(int binary){
    	 
        int decimal = 0;
        int index = 0;
        while(true){
	        if(binary == 0){
	            break;
	        }else {
	            int help = binary%10;
	            decimal += help*Math.pow(2, index);
	            binary = binary/10;
	            index++;
	        }
        }
        return decimal;
    }
}
