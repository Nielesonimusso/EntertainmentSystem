/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s132054
 */
public class PlayList {
    
    List<Recording> recordings;
    public static final String WORKING_PATH = "./recordings/";

    public PlayList() {
        recordings = new ArrayList<>();
        File file = new File(WORKING_PATH);
         String[] fileNames = file.list();
                for(String fileName : fileNames){
                    Recording recording = new Recording();
                    recording.name = fileName.substring(0, fileName.lastIndexOf("."));
                    recordings.add(recording);
               }
    }
    
    void add(Recording recording) {
        
    }
    
    void delete(Recording recording) {
        
    }
    
    void select(Recording recording) {
        
    }
    
}
