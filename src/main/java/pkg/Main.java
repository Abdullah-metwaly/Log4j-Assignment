package pkg;

import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final Marker Hickory = MarkerManager.getMarker("HICKORY_DICKORY");
    private static final Marker Mouse = MarkerManager.getMarker("MOUSE");
    private static final Marker Ran_down = MarkerManager.getMarker("RAN_DOWN");


    public static void main(String[] args) {
        try{
            String lyrics = """
                The mouse ran up the clock,
                The clock struck one
                The mouse ran down,
                Hickory Dickory dock.                                
                Hickory Dickory dock,
                The mouse ran up the clock,
                The clock struck two
                And down he flew,
                Hickory Dickory dock.                                
                Hickory Dickory dock,
                The mouse ran up the clock,
                The clock struck three
                And he did flee,
                Hickory Dickory dock.                               
                Hickory Dickory dock,
                The mouse ran up the clock,
                The clock struck four,
                He hit the floor,
                Hickory Dickory dock.
                Hickory Dickory dock,         
                """;

            for(int i=0; i< Integer.parseInt(args[0]); i++){
                ThreadContext.push(String.valueOf(i));

                logger.info("The mouse ran up the clock");
                logger.debug(Mouse,"The mouse ran");
                logger.fatal(Hickory, "Hickory Dickory");
                logger.warn(Ran_down, "The mouse ran down");
                logger.error("He hit the floor");

                ThreadContext.clearAll();

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        } catch (NumberFormatException nfe){
            System.out.println("Arrguments entered aren't correct");
        }


    }

}