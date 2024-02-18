/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;



/**
 *
 * @author 14046
 */
public class Steven extends Sprite{
    
    Picture basePic;
    Picture left1;
    Picture left2;
    Picture right1;
    Picture right2;
    Picture up1;
    Picture up2;
    Picture down1;
    Picture down2;
    int marker;
    boolean devSkip;
    
    public Steven(SpriteComponent sc) {
        super(sc);
        basePic = new Picture("idle.png");
        left1 = new Picture("left.png");       
        right1 = new Picture("right.png");
        up1 = new Picture("up.png");
        down1 = new Picture("down.png");
        setPicture(basePic);
        marker = 0;
        devSkip = true;
        
    }
    
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            setX(sc.getSize().width-getWidth());
        }
        if (se.xhi) {
            setX(0);
        }
        if (se.ylo) {
            setY(sc.getSize().height-getHeight());
        }
        if (se.yhi) {
            setY(0);
        }
    }
}

    
    

