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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Merka
 */
public class ProgramGuide {

    List<Program> programs;
    JList programJList;
    private static final String WORKING_PATH = "./channels/";

    public ProgramGuide(JList programJList) {
        programs = new ArrayList<>();
        this.programJList = programJList;
    }

    void update() {
        ArrayList<String> programNames = readProgramNames();      
         programJList.setModel(new javax.swing.AbstractListModel<String>() {           
            public int getSize() { return programNames.size(); }
            public String getElementAt(int i) { return programNames.get(i); }
        });
       
    }

    private ArrayList<String> readProgramNames() {
        File handler = new File(WORKING_PATH);
        ArrayList<String> nameList = new ArrayList<>();
        for(File f :  handler.listFiles()){
            if(f.isDirectory()){
                String[] tmp = f.list();
                for(String name : tmp){
                    nameList.add("ch. " + f.getName() + " - " + name.substring(0, name.lastIndexOf(".")));
               }
            }
        }
        return nameList;
    }

}
