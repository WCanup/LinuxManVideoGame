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
public class Penguin extends Sprite{
    Picture up;
    Picture left;
    Picture right;
    Picture bullet;
    Boolean start;
    int marker;
    public Penguin(SpriteComponent sc) {
        super(sc);
        
        up = new Picture("PenguinSpriteforward.png");
        left = new Picture("PenguinSpritemoveleft.png");
        right = new Picture("PenguinSpritemoveright.png");
        bullet = new Picture("coin.png");
        start = false;
        marker = 3;
    }
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.xlo) {
            setX(getX() + 50);
        }
        if (se.xhi) {
            setX(getX() - 50);
        }

    }
}
