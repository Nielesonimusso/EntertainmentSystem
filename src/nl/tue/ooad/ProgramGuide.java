/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author Merka
 */
public class ProgramGuide {

    List<Program> programs;
    JList programJList;
    public static final String WORKING_PATH = "./channels/";

    public ProgramGuide(JList programJList) {
        this.programs = new ArrayList<>();
        this.programJList = programJList;
    }

    void update(boolean showGuide) {
        readProgramNames();      
        if(showGuide){
            programJList.setModel(new javax.swing.AbstractListModel<String>() {           
                public int getSize() { return programs.size(); }
                public String getElementAt(int i) { return programs.get(i).name; }
            });
        } else {
            programJList.setModel(new javax.swing.AbstractListModel<String>() {           
                public int getSize() { return 0; }
                public String getElementAt(int i) { return ""; }
            }); 
        }
       
    }

    private void readProgramNames() {
        File handler = new File(WORKING_PATH);
        for(File f :  handler.listFiles()){
            if(f.isDirectory()){
                String[] fileNames = f.list();
                int i = 1;
                for(String file : fileNames){
                    Program p = new Program();
                    p.name = "ch. " + f.getName() + " - " + file.substring(0, file.lastIndexOf("."));
                    p.startingTime = i;
                    p.endTime = i+1;
                    programs.add(p);
               }
            }
        }
    }

}
