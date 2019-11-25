/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tue.ooad;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author s132054
 */
public class ProgramGuide {
    
    List<Program> programs;
    JPanel programGuidePanel;

    public ProgramGuide(JPanel programGuidePanel) {
        programs = new ArrayList<>();
        this.programGuidePanel = programGuidePanel;
    }
    
    void update() {
        
    }
    
}
