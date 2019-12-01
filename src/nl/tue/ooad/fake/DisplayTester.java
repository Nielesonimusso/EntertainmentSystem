/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import nl.tue.ooad.Display;
import nl.tue.ooad.StreamFrame;

/**
 *
 * @author s157106
 */
public class DisplayTester {
    
  
    public void test(Display display){

        String AUDIO_FILENAME = "JungleAnimalSounds.wav";
        TFrameProducer producer = new TFrameProducer();
        producer.configStreamSource(AUDIO_FILENAME);
        
        display.setStreamSource(producer.getStreamSource());
        display.play();
    }   
}
