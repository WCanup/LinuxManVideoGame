/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

/**
 *
 * @author 14046
 */
public class Billiam extends Sprite{
    Picture icon;
    Picture leftHand;
    Picture rightHand;
    Picture leftFist;
    Picture rightFist;
    Picture leftFistBullet;
    Picture rightFistBullet;
    double health;
    Picture follower;
    Picture red;
    
    
    public Billiam(SpriteComponent sc) {
        super(sc);
        health = 100;
        red = new Picture("redBoss.png");
        follower = new Picture("void.png");
        icon = new Picture("BilliamBoss.png");
        leftHand = new Picture("leftOpenHand.png");
        rightHand = new Picture("rightOpenHand.png");
        leftFist = new Picture("leftFist.png");
        rightFist = new Picture("rightFist.png");
        leftFistBullet = new Picture("leftFistBullet.png");
        rightFistBullet = new Picture("rightFistBullet.png");
        
        
    }
    
}
