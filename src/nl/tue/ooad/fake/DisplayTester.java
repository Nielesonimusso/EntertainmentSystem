/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author s157106
 */
public class DisplayTester {
    
    
    public void test(){
         BlockingQueue<TStreamFrame> blockingQueue = new LinkedBlockingQueue<TStreamFrame>();
         Thread fakeProducer = new Thread(new TFrameProducer(blockingQueue));
         Thread fakeConsumer = new Thread(new TFrameConsumer(blockingQueue));
         
         fakeProducer.start();
         fakeConsumer.start();
    }
}
