package projectthree;
/**
 *Class ChannelClass for storing data into a pcm30.
 */

public class ChannelClass {	
	private int value;
    private String binary;

    /**
     * constructor ChannelClass use to initialize the class ChannelClass.
     * @param value to be store.
     */
    public ChannelClass(int value){
        setValue(value);
    }

    /**
     * method getValue() to return integer value.
     * @return value.
     */
    public int getValue(){
        return value;
    }
    
    /**
     * method getBinaryValue() to return String value.
     * @return binary.
     */
    public String getBinary(){
        return binary;
    }

    /**
     * method getBinaryValue() to return String value.
     * @param value to be convert.
     */
    public void setValue(int value){
        this.value = value;
        this.binary = DecToBinary.getBinary(value);
    }
}
