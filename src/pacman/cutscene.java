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
public class cutscene extends Sprite{
    Picture leftr;
    Picture rightr;
    Picture leftb;
    Picture rightb;
    Picture lefty;
    Picture righty;
    Picture leftg;
    Picture rightg;
    Picture lefts;
    Picture rights;
    Picture lefticon;
    Picture righticon;
    Picture coin;
    Picture bill;
    Picture background;
    Picture space;
    Picture space2;
    Picture idler;
    Picture idley;
    Picture idleb;
    Picture idleg;
    Boolean show;
    
    public cutscene(SpriteComponent sc) {
        super(sc);
        idler = new Picture("downr.png");
        idleb = new Picture("downb.png");
        idley = new Picture("downy.png");
        idleg = new Picture("downg.png");
        space = new Picture("void.png");
        
        background = new Picture("blackscreen.png");
        leftr = new Picture("leftr.png");
        rightr = new Picture("rightr.png");
        leftb = new Picture("leftb.png");
        rightb = new Picture("rightb.png");
        lefty = new Picture("lefty.png");
        righty = new Picture("righty.png");
        leftg = new Picture("leftg.png");
        rightg = new Picture("rightg.png");
        lefts = new Picture("left.png");
        righticon = new Picture("phase2stevenIcon2.png");
        show = false;
        
    }
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        Picture a = getPicture();
        
        
        if (se.xlo) {
            if(a == lefts){
                setActive(false);
            }
            else{
            if(a == leftr){
                setPicture(rightr);
            }
            if(a == leftg){
                setPicture(rightg);
            }
            if(a == leftb){
                setPicture(rightb);
            }
            if(a == lefty){
                setPicture(righty);
            }
            
                setVelX(-getVelX());
            }
        }
        if(se.xhi ){
            setActive(false);
            
            
        }
        
        
       
        
    }
}
