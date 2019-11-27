/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad.fake;

/**
 *
 * @author s157106
 */
public class TStreamFrame {
    
    private int value;
    
    public TStreamFrame(int value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        return "[" + value  + "]"; 
    }
}
