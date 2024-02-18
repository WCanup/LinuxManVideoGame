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
public class title extends Sprite{
    Picture start;
    Picture cursor;
    int marker;
    boolean show;
    
    public title(SpriteComponent sc, int type) {
        super(sc);
        start= new Picture("title.png");
        cursor = new Picture("cursor.png");
        if(type == 0){
            setPicture(start);
        }
        else{
            setPicture(cursor);
        }
        marker = 0;
        show = false;
    }
    
}
