/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacman;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 14046
 */
public class WallMaker extends Sprite{
    Picture penguin = new Picture("penguin.jpg");
    Picture coin = new Picture("coin.png");
    Picture black = new Picture("black.png");
    Boolean tunnel;
    Boolean red;
    public WallMaker(SpriteComponent sc,String str) {
        super(sc);
        tunnel = false;
        red = false;
        setPicture(new Picture(str));
        
      
        
    }
    
    
}
