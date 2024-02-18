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
public class exposition extends Sprite{
    Picture blackscreen;
    Picture expoScreen;
    Picture steven;
    Picture line1;
    Picture line2;
    Picture linecover;
    int marker;
    boolean show;
    public exposition(SpriteComponent sc) {
        super(sc);
        
        blackscreen = new Picture("blackscreen.png");
        expoScreen = new Picture("Expositionscreen.png");
        steven = new Picture("stevenIcon.png");
        line1 = new Picture("line1.png");
        line2 = new Picture("line2.png");
        linecover = new Picture("linecover.png");
        marker = 0;
        show = false;
    }
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.yhi) {
        marker++;
        }
    }
}
