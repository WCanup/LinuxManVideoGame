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
public class bossMap extends Sprite{
    Picture background;
    Picture indicator;
    Boolean ind;
    Boolean c1;
    Boolean c2;
    Picture mapPiece;
    Picture hiddenMap;
    Picture m8;
    Picture m9;
    Picture m10;
    Picture m11;
    Picture m12;
    Picture m13;
    Picture m14;
    Picture m15;
    Picture m16;
    Picture m17;
    Picture m18;
    Picture m19;
    Picture m20;
    Picture m21;
    Picture bulletIndicator;
    Picture swingIndicator;
    
    public bossMap(SpriteComponent sc) {
        super(sc);
        swingIndicator = new Picture("mapPiece.png");
        background = new Picture("scrolling Cloud.png");
        indicator = new Picture("black.png");
        bulletIndicator = new Picture("mapPiece.png");
        ind = false;
        c1 = false;
        c2 = false;
        mapPiece = new Picture("mapPiece.png");
        hiddenMap = new Picture("mapPiece.png");
        m8 = new Picture("map 1_8.png");
        m9 = new Picture("map 1_9.png");
        m10 = new Picture("map 1_10.png");
        m11 = new Picture("map 1_11.png");
        m12 = new Picture("map 1_12.png");
        m13 = new Picture("map 1_13.png");
        m14 = new Picture("map 1_14.png");
        m15 = new Picture("map 1_15.png");
        m16 = new Picture("map 1_16.png");
        m17 = new Picture("map 1_17.png");
        m18 = new Picture("map 1_18.png");
        m19 = new Picture("map 1_19.png");
        m20 = new Picture("map 1_20.png");
        m21 = new Picture("map 1_21.png");
    }
     
}
