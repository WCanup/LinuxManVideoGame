/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;


public class finalExposition extends Sprite{
    Picture screen;
    Picture icon;
    Picture billiam;
    Picture penguin;
    Picture coin;
    Picture linecover;
    Picture line1;
    Picture line2;
    Picture line3;
    Picture line4;
    Picture line5;
    Picture red;
    Picture blue;
    Picture green;
    Picture yellow;
    Picture iconCover;
    int marker;
    int coinAmount;
    Picture fuse;
    Picture ascend;
    
    
    
    public finalExposition(SpriteComponent sc) {
        super(sc);
        ascend = new Picture("ascendedSteven.jpg");
        fuse = new Picture("billreveal.png");
        screen = new Picture("blackscreen.png");
        icon = new Picture("phase2stevenIcon.png");
        billiam = new Picture("BilliamNormal.png");
        penguin = new Picture("dopePenguin.jpg");
        coin = new Picture("coin.png");
        linecover = new Picture("linecover.png");
        line1 = new Picture("finalLine1.png");
        line2 = new Picture("finalLine2.png");
        line3 = new Picture("finalLine3.png");
        line4 = new Picture("finalLine4.png");
        line5 = new Picture("finalLine5.png");
        red = new Picture("idlertest.png");
        blue = new Picture("idlebtest.png");
        green = new Picture("idlegtest.png");
        yellow = new Picture("idleytest.png");
        iconCover = new Picture("finalphasecover.png");
        marker = 0;
        coinAmount = 0;
        
        
    }
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.yhi) {
        marker++;
        }
    }
}
