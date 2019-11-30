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
         BlockingQueue<StreamFrame> blockingQueue = new LinkedBlockingQueue<StreamFrame>();
         TFrameProducer producer = new TFrameProducer(blockingQueue);
         display.setProducer(producer);
         
         Thread producerThread = new Thread(producer);
         Thread displayThread = new Thread(display);
         
         producerThread.start();
         displayThread.start();
    }   
}
