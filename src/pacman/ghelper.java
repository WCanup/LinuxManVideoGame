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
public class ghelper extends Sprite{
    Picture p;
    boolean inWall;
    public ghelper(SpriteComponent sc) {
        super(sc);
        p = new Picture("void.png");
        setPicture(p);
        inWall = false;
        
    }
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
//            setX(sc.getSize().width-getWidth());
        }
        if (se.xhi) {
//            setX(0);
        }
        if (se.yhi){
            setY(0);
        }
        if(se.ylo){
            setY(sc.getSize().height-getHeight());
        }
    }
}
