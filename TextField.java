/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proektsudoku;

import javax.swing.JTextField;

/**
 *
 * @author Boyanvb1
 */

    public class TextField extends JTextField {

    public int x;
    public int y;

    @Override
    public int getX() {
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return y;
    }

    void setVerifyInputWhenFocusTarget(int CENTER) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    

