# Multiplexer
Create a program that consists of more than three classes and simulates a multiplexer mechanism.
Create a multiplexer that can realize a STD (Synchronous Time Division), ATD (Asynchronous Time
Division), and CDM (Code Division Multiplex). The multiplexer offers the following facilities:

 Assign a value to an input of the multiplexer
 Start the multiplexing
 Assign an input to a channel (channel 1 to channel 30, because only 30 voice channels exist)
 Each input holds a two’s complement byte reference or instance

An instance of a specialized multiplexer can be realized and it can be assigned the number of inputs it
has. The following strings define the possible multiplexer types:

 STDM
 ATDM
 CDM

Create a multiplexer that realizes a synchronous time division. The realized multiplexer has to utilize
a PCM-30 frame

The channel 0 is for framing bits and channel 16 for signaling. Channel 0 has the value 27 for even
frames and the value 64 for odd frames. The first created frame is an even frame. Channel 16 always
has the value 95.

During a multiplex process, the PCM-30 frame will be print in console as depicted:

|<value> Channel 0|<value> Channel 1| … |<value> Channel 31|
Change the created user interface so that a multiplexer type can be chosen with a desired number of
inputs. 
  
  Each time a multiplexer is created the user is informed by:
<type> multiplexer created
If a multiplexer ATD or CDM was requested the user is informed by:
This type is not implemented
Furthermore, the user should be enabled to assign an input to a channel. Also a value can be
assigned to an input. If the typed in value for an input is not correct or the specified range is
exceeded the user should receive the information from console as described in previous project
exercise.
  
  If no multiplexer is realized the user is informed by: Please create multiplexer
If any input is not compliant with the syntax depicted in the following table the resulting print out
will be Wrong Input
As long as the program runs it askes the user to type in a command by: Input:˽
The program can be stopped with q or Q.
