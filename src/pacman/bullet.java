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
public class bullet extends Sprite{
    Picture bullet;
    public bullet(SpriteComponent sc) {
        super(sc);
        bullet = new Picture("bullet.png");
    }
    public void processEvent(SpriteCollisionEvent se){
      
        SpriteComponent sc = getSpriteComponent();
        if (se.ylo) {
            setActive(false);
        }
    }
}
