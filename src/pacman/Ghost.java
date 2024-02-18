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
public class Ghost extends Sprite{
    Picture up;
    Picture down;
    Picture left;
    Picture right;
    Picture rightr;
    Picture righty;
    Picture rightg;
    Picture rightb;
    Picture leftr;
    Picture lefty;
    Picture leftg;
    Picture leftb;
    Picture upr;
    Picture upy;
    Picture upg;
    Picture upb;
    Picture downr;
    Picture downy;
    Picture downg;
    Picture downb;
    Picture idler;
    Picture idley;
    Picture idleb;
    Picture idleg;
    String c;
    
    public Ghost(SpriteComponent sc, int color) {
        super(sc);
    rightr = new Picture("rightr.png");
    righty = new Picture("righty.png");
    rightg = new Picture("rightg.png");
    rightb = new Picture("rightb.png");
    leftr = new Picture("leftr.png");
    lefty = new Picture("lefty.png");
    leftg = new Picture("leftg.png");
    leftb = new Picture("leftb.png");
    upr = new Picture("upr.png");
    upy = new Picture("upy.png");
    upg = new Picture("upg.png");
    upb = new Picture("upb.png");
    downr = new Picture("downr.png");
    downy = new Picture("downy.png");
    downg = new Picture("downg.png");
    downb = new Picture("downb.png");
    idler = new Picture("idler.png");
    idley = new Picture("idley.png");
    idleb = new Picture("idleb.png");
    idleg = new Picture("idleg.png");
    if(color == 1){
        c = "red";
        setPicture(downr);
        up = upr;
        down = downr;
        left = leftr;
        right = rightr;
    }
    else if(color == 2){
        c = "blue";
        setPicture(upb);
        up = upb;
        left = leftb;
        right = rightb;
        down = downb;
    }
    else if(color == 3){
        c = "yellow";
        setPicture(downy);
        up = upy;
        left = lefty;
        right = righty;
        down = downy;
    }
    else if (color == 4){
        c = "green";
        setPicture(upg);
        up = upg;
        down = downg;
        left = leftg;
        right = rightg;
    }
    }
    
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            setPicture(right);
        }
        if (se.xhi) {
            setPicture(left);
        }
        if (se.ylo) {
            setY(sc.getSize().height-getHeight());
        }
        if (se.yhi) {
            setY(0);
        }
    }
}
