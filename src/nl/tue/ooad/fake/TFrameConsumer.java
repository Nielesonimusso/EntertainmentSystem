/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author s157106
 */
public class TFrameConsumer implements Runnable {
    
    private final BlockingQueue<TStreamFrame> blockingQueue;
    
    public TFrameConsumer(BlockingQueue<TStreamFrame> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                TStreamFrame sf = blockingQueue.take();
                System.out.println("Consumed StreamFrame: " + sf);
            } catch (InterruptedException ie){
                System.out.println("Consumer was interrupted!");
            }
        }
    }
}
