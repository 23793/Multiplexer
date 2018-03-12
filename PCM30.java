package projectthree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *Class PCM30 for stroring data into a pcm30.
 */

public class PCM30 {
    private static boolean debug = false;
    private String pcmName;
    private ArrayList<ChannelClass> channelList;
    private int value;
    private Map<Integer,Integer> map;
    
    /**
    * constructor PCM30 to initialize the PCM30
    * @param pcmName String value to be store.
    * @param value corresponding value of pcmName
    */
    public PCM30(String pcmName, int value){
        if(debug) System.out.println("DEBUG-PCM30: Constructor "+pcmName+" "+value);
        this.pcmName = pcmName;
        this.value = value;
        this.channelList = new ArrayList<>(32);
        this.map = new TreeMap<>();
        for(int i=0; i<32; i++) channelList.add(i,new ChannelClass(0));
        // check if the frame is odd or even
        channelList.get(0).setValue((value%2==0)? 27:64);
        channelList.get(16).setValue(95);
    }

    /**
     * method assignChannel describing the way to allocate valuues into every channel
     * @param ChannelID for the 
     * @param InputID use to allocate the same input number into the pcm30
     * @return false if the condition doesn't work
     * @throws NullPointerException use to avoid the exeedance of the frame.
     */
    public boolean assignChannel(int ChannelID, int InputID) 
    		throws NullPointerException{
        if(debug) {
        	System.out.println("DEBUG-PCM30: assignChannel "+ChannelID+" "+InputID);
        } 
        if(ChannelID!=0 && ChannelID!=16 && ChannelID<32 && ChannelID>=0){
            map.put(ChannelID,InputID);
            return true;
        }
        return false;
    }

    /**
     * method assignValue(,) use to allocate value to a inputID
     * @param value to be store.
     * @param InputID use to allocate the same input number into the pcm30
     * @return false if the condition doesn't work
     */
    public boolean assignValue(int value, int InputID){
        if(debug) System.out.println("DEBUG-PCM30: assignValue "+value+" "+InputID);
        if(map.containsKey(InputID)){
        	if(value < 128 || value > -129)
        	{	
	            channelList.get(map.get(InputID)).setValue(value);
	            //OutputList.add(value);
	            return true;
        	}else {
        		System.out.println("Wrong Number");
        	}
        }
        return false;
    }

    /**
     * method assignChannel describing the way to allocate values into every channel
     * @param ChannelID for the 
     * @param OutputID use to allocate the same input number into the pcm30
     * @return false if the condition doesn't work
     * @throws NullPointerException use to avoid the exceedance of the frame.
     */
    public boolean assignOutput(int ChannelID, int OutputID) 
    		throws NullPointerException{
        if(debug) {
        	System.out.println("DEBUG-PCM30: assignChannel "+ChannelID+" "+OutputID);
        }
        if(ChannelID!=0 && ChannelID!=16 && ChannelID<32 && ChannelID>=0){
            map.put(ChannelID,OutputID);
            return true;
        }
        return false;
    }
   
    /**
     * method getChannelList
     * @return channelList the final frame.
     */
    public ArrayList<ChannelClass> getChannelList(){
        return channelList;
    }
}
