package pacman;

import basicgraphics.BasicFrame;
import basicgraphics.Clock;
import basicgraphics.SpriteComponent;
import basicgraphics.SpriteSpriteCollisionListener;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Pacman {

    static Picture penguin = new Picture("penguin.jpg");
    static Picture coin = new Picture("coin.png");
    static Picture black = new Picture("black.png");

    static String[][] layout = {
        {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10", "a11", "a12", "a13", "a14", "a15", "a16", "a17", "a18", "a19", "a20", "a21", "a22", "a23", "a24", "a25", "a26", "a27", "a28"},
        {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10", "b11", "b12", "b13", "b14", "b15", "b16", "b17", "b18", "b19", "b20", "b21", "b22", "b23", "b24", "b25", "b26", "b27", "b28"},
        {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10", "c11", "c12", "c13", "c14", "c15", "c16", "c17", "c18", "c19", "c20", "c21", "c22", "c23", "c24", "c25", "c26", "c27", "c28"},
        {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "d11", "d12", "d13", "d14", "d15", "d16", "d17", "d18", "d19", "d20", "d21", "d22", "d23", "d24", "d25", "d26", "d27", "d28"},
        {"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10", "e11", "e12", "e13", "e14", "e15", "e16", "e17", "e18", "e19", "e20", "e21", "e22", "e23", "e24", "e25", "e26", "e27", "e28"},
        {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12", "f13", "f14", "f15", "f16", "f17", "f18", "f19", "f20", "f21", "f22", "f23", "f24", "f25", "f26", "f27", "f28"},
        {"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g10", "g11", "g12", "g13", "g14", "g15", "g16", "g17", "g18", "g19", "g20", "g21", "g22", "g23", "g24", "g25", "g26", "g27", "g28"},
        {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11", "h12", "h13", "h14", "h15", "h16", "h17", "h18", "h19", "h20", "h21", "h22", "h23", "h24", "h25", "h26", "h27", "h28"},
        {"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10", "i11", "i12", "i13", "i14", "i15", "i16", "i17", "i18", "i19", "i20", "i21", "i22", "i23", "i24", "i25", "i26", "i27", "i28"},
        {"k1", "k2", "k3", "k4", "k5", "k6", "k7", "k8", "k9", "k10", "k11", "k12", "k13", "k14", "k15", "k16", "k17", "k18", "k19", "k20", "k21", "k22", "k23", "k24", "k25", "k26", "k27", "k28"},
        {"j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10", "j11", "j12", "j13", "j14", "j15", "j16", "j17", "j18", "j19", "j20", "j21", "j22", "j23", "j24", "j25", "j26", "j27", "j28"},
        {"l1", "l2", "l3", "l4", "l5", "l6", "l7", "l8", "l9", "l10", "l11", "l12", "l13", "l14", "l15", "l16", "l17", "l18", "l19", "l20", "l21", "l22", "l23", "l24", "l25", "l26", "l27", "l28"},
        {"m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10", "m11", "m12", "m13", "m14", "m15", "m16", "m17", "m18", "m19", "m20", "m21", "m22", "m23", "m24", "m25", "m26", "m27", "m28"},
        {"n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8", "n9", "n10", "n11", "n12", "n13", "n14", "n15", "n16", "n17", "n18", "n19", "n20", "n21", "n22", "n23", "n24", "n25", "n26", "n27", "n28"},
        {"o1", "o2", "o3", "o4", "o5", "o6", "o7", "o8", "o9", "o10", "o11", "o12", "o13", "o14", "o15", "o16", "o17", "o18", "o19", "o20", "o21", "o22", "o23", "o24", "o25", "o26", "o27", "o28"},
        {"p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28"},
        {"q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10", "q11", "q12", "q13", "q14", "q15", "q16", "q17", "q18", "q19", "q20", "q21", "q22", "q23", "q24", "q25", "q26", "q27", "q28"},
        {"r1", "r2", "r3", "r4", "r5", "r6", "r7", "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "r27", "r28"},
        {"s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11", "s12", "s13", "s14", "s15", "s16", "s17", "s18", "s19", "s20", "s21", "s22", "s23", "s24", "s25", "s26", "s27", "s28"},
        {"t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9", "t10", "t11", "t12", "t13", "t14", "t15", "t16", "t17", "t18", "t19", "t20", "t21", "t22", "t23", "t24", "t25", "t26", "t27", "t28"},
        {"u1", "u2", "u3", "u4", "u5", "u6", "u7", "u8", "u9", "u10", "u11", "u12", "u13", "u14", "u15", "u16", "u17", "u18", "u19", "u20", "u21", "u22", "u23", "u24", "u25", "u26", "u27", "u28"},
        {"v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10", "v11", "v12", "v13", "v14", "v15", "v16", "v17", "v18", "v19", "v20", "v21", "v22", "v23", "v24", "v25", "v26", "v27", "v28"},
        {"w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w16", "w17", "w18", "w19", "w20", "w21", "w22", "w23", "w24", "w25", "w26", "w27", "w28"},
        {"x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9", "x10", "x11", "x12", "x13", "x14", "x15", "x16", "x17", "x18", "x19", "x20", "x21", "x22", "x23", "x24", "x25", "x26", "x27", "x28"},
        {"y1", "y2", "y3", "y4", "y5", "y6", "y7", "y8", "y9", "y10", "y11", "y12", "y13", "y14", "y15", "y16", "y17", "y18", "y19", "y20", "y21", "y22", "y23", "y24", "y25", "y26", "y27", "y28"},
        {"z1", "z2", "z3", "z4", "z5", "z6", "z7", "z8", "z9", "z10", "z11", "z12", "z13", "z14", "z15", "z16", "z17", "z18", "z19", "z20", "z21", "z22", "z23", "z24", "z25", "z26", "z27", "z28"},
        {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20", "A21", "A22", "A23", "A24", "A25", "A26", "A27", "A28"},
        {"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B11", "B12", "B13", "B14", "B15", "B16", "B17", "B18", "B19", "B20", "B21", "B22", "B23", "B24", "B25", "B26", "B27", "B28"},
        {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14", "C15", "C16", "C17", "C18", "C19", "C20", "C21", "C22", "C23", "C24", "C25", "C26", "C27", "C28"},
        {"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13", "D14", "D15", "D16", "D17", "D18", "D19", "D20", "D21", "D22", "D23", "D24", "D25", "D26", "D27", "D28"},
        {"E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10", "E11", "E12", "E13", "E14", "E15", "E16", "E17", "E18", "E19", "E20", "E21", "E22", "E23", "E24", "E25", "E26", "E27", "E28"}
    };

    public static void main(String[] args) {

        BasicFrame bf = new BasicFrame("Pacman");
        final SpriteComponent steve = new SpriteComponent();
        String filename = "RedMap1";

        String[] l1 = new String[868];
        for (int i = 0; i < l1.length; i++) {
            int num = i + 1;
            String box = "map 1_" + num + ".png";
            l1[i] = box;
        }

        Boolean[] tunnels = new Boolean[l1.length];
        Boolean[] red = new Boolean[l1.length];
        coinCounter count = new coinCounter();

        for (int i = 0; i < l1.length; i++) {
            if (check(l1[i]) == true) {
                tunnels[i] = true;

            } else {
                tunnels[i] = false;
            }

        }
        for (int i = 0; i < l1.length; i++) {
            if (check2(l1[i]) == true) {
                red[i] = true;
            } else {
                red[i] = false;
            }
        }

        bossMap indicator = new bossMap(steve);
        indicator.setPicture(indicator.indicator);
        indicator.setY(8525);
        indicator.ind = true;

        bossMap cloud1 = new bossMap(steve);
        cloud1.setPicture(cloud1.background);
        cloud1.setY(-7750);
        cloud1.c1 = true;

        bossMap cloud2 = new bossMap(steve);
        cloud2.setPicture(cloud2.background);
        cloud2.c2 = true;

        bossMap bulletIndicator = new bossMap(steve);
        bulletIndicator.setPicture(bulletIndicator.bulletIndicator);
        bulletIndicator.setY(-25);

        bossMap swingIndicator1 = new bossMap(steve);
        swingIndicator1.setPicture(swingIndicator1.swingIndicator);
        swingIndicator1.setY(775);
        swingIndicator1.setX(-700);

        bossMap swingIndicator2 = new bossMap(steve);
        swingIndicator2.setPicture(swingIndicator2.swingIndicator);
        swingIndicator2.setY(775);

        bossMap swingIndicator3 = new bossMap(steve);
        swingIndicator3.setPicture(swingIndicator3.swingIndicator);
        swingIndicator3.setY(775);
        swingIndicator3.setX(700);

        bossMap mapPiece = new bossMap(steve);
        mapPiece.setPicture(mapPiece.mapPiece);
        mapPiece.setY(750);

        bossMap hiddenMap = new bossMap(steve);
        hiddenMap.setPicture(hiddenMap.hiddenMap);
        hiddenMap.setY(-1000);

        Billiam gates = new Billiam(steve);
        gates.setPicture(gates.icon);
        gates.setX(260);
        gates.setY(3000);

        Billiam leftHand = new Billiam(steve);
        leftHand.setPicture(leftHand.leftHand);
        leftHand.setX(-200);

        Billiam rightHand = new Billiam(steve);
        rightHand.setPicture(rightHand.rightHand);
        rightHand.setX(-200);

        Penguin brandt = new Penguin(steve);
        brandt.setPicture(brandt.up);
        brandt.setX(310);
        brandt.setY(5000);

        bossMap[] pieces = new bossMap[14];
        bossMap m8 = new bossMap(steve);
        m8.setPicture(m8.m8);
        m8.setY(750);
        m8.setX(175);
        pieces[0] = m8;

        bossMap m9 = new bossMap(steve);
        m9.setPicture(m9.m9);
        m9.setY(750);
        m9.setX(200);
        pieces[1] = m9;

        bossMap m10 = new bossMap(steve);
        m10.setPicture(m10.m10);
        m10.setY(750);
        m10.setX(225);
        pieces[2] = m10;

        bossMap m11 = new bossMap(steve);
        m11.setPicture(m11.m11);
        m11.setY(750);
        m11.setX(250);
        pieces[3] = m11;

        bossMap m12 = new bossMap(steve);
        m12.setPicture(m8.m12);
        m12.setY(750);
        m12.setX(275);
        pieces[4] = m12;

        bossMap m13 = new bossMap(steve);
        m13.setPicture(m8.m13);
        m13.setY(750);
        m13.setX(300);
        pieces[5] = m13;

        bossMap m14 = new bossMap(steve);
        m14.setPicture(m8.m14);
        m14.setY(750);
        m14.setX(325);
        pieces[6] = m14;

        bossMap m15 = new bossMap(steve);
        m15.setPicture(m8.m15);
        m15.setY(750);
        m15.setX(350);
        pieces[7] = m15;

        bossMap m16 = new bossMap(steve);
        m16.setPicture(m8.m16);
        m16.setY(750);
        m16.setX(375);
        pieces[8] = m16;

        bossMap m17 = new bossMap(steve);
        m17.setPicture(m8.m17);
        m17.setY(750);
        m17.setX(400);
        pieces[9] = m17;

        bossMap m18 = new bossMap(steve);
        m18.setPicture(m8.m18);
        m18.setY(750);
        m18.setX(425);
        pieces[10] = m18;

        bossMap m19 = new bossMap(steve);
        m19.setPicture(m8.m19);
        m19.setY(750);
        m19.setX(450);
        pieces[11] = m19;

        bossMap m20 = new bossMap(steve);
        m20.setPicture(m8.m20);
        m20.setY(750);
        m20.setX(475);
        pieces[12] = m20;

        bossMap m21 = new bossMap(steve);
        m21.setPicture(m8.m21);
        m21.setY(750);
        m21.setX(500);
        pieces[13] = m21;

        finalExposition finalScreen = new finalExposition(steve);
        finalScreen.setPicture(finalScreen.screen);

        finalExposition penguin = new finalExposition(steve);
        penguin.setPicture(penguin.penguin);
        penguin.setX(375);
        penguin.setY(100);

        finalExposition penguinCover = new finalExposition(steve);
        penguinCover.setPicture(penguinCover.iconCover);
        penguinCover.setX(375);
        penguinCover.setY(100);

        finalExposition finalSteve = new finalExposition(steve);
        finalSteve.setPicture(finalSteve.icon);
        finalSteve.setX(375);
        finalSteve.setY(100);

        finalExposition ascendedSteve = new finalExposition(steve);
        finalExposition ascendedSteveScreen = new finalExposition(steve);

        finalExposition bill = new finalExposition(steve);
        bill.setPicture(bill.billiam);
        bill.setX(25);
        bill.setY(100);

        finalExposition billCover = new finalExposition(steve);
        billCover.setPicture(billCover.iconCover);
        billCover.setX(25);
        billCover.setY(100);

        finalExposition fRed = new finalExposition(steve);
        fRed.setPicture(fRed.red);
        fRed.setX(75);
        fRed.setY(100);

        finalExposition fBlue = new finalExposition(steve);
        fBlue.setPicture(fBlue.blue);
        fBlue.setX(75);
        fBlue.setY(250);

        finalExposition fGreen = new finalExposition(steve);
        fGreen.setPicture(fGreen.green);
        fGreen.setX(225);
        fGreen.setY(100);

        finalExposition fYellow = new finalExposition(steve);
        fYellow.setPicture(fYellow.yellow);
        fYellow.setX(225);
        fYellow.setY(250);

        finalExposition fline5 = new finalExposition(steve);
        fline5.setPicture(fline5.line5);
        fline5.setX(50);
        fline5.setY(500);

        finalExposition lineCover5 = new finalExposition(steve);
        lineCover5.setPicture(lineCover5.linecover);
        lineCover5.setX(50);
        lineCover5.setY(500);

        finalExposition fline4 = new finalExposition(steve);
        fline4.setPicture(fline4.line4);
        fline4.setX(50);
        fline4.setY(500);

        finalExposition lineCover4 = new finalExposition(steve);
        lineCover4.setPicture(lineCover4.linecover);
        lineCover4.setX(50);
        lineCover4.setY(500);

        finalExposition fline3 = new finalExposition(steve);
        fline3.setPicture(fline3.line3);
        fline3.setX(50);
        fline3.setY(500);

        finalExposition lineCover3 = new finalExposition(steve);
        lineCover3.setPicture(lineCover3.linecover);
        lineCover3.setX(50);
        lineCover3.setY(500);

        finalExposition fline2 = new finalExposition(steve);
        fline2.setPicture(fline2.line2);
        fline2.setX(50);
        fline2.setY(500);

        finalExposition lineCover2 = new finalExposition(steve);
        lineCover2.setPicture(lineCover2.linecover);
        lineCover2.setX(50);
        lineCover2.setY(500);

        finalExposition lore = new finalExposition(steve);
        finalExposition lorescreen = new finalExposition(steve);

        finalExposition fline1 = new finalExposition(steve);
        fline1.setPicture(fline1.line1);
        fline1.setX(50);
        fline1.setY(500);

        finalExposition lineCover1 = new finalExposition(steve);
        lineCover1.setPicture(lineCover1.linecover);
        lineCover1.setX(50);
        lineCover1.setY(500);

        cutscene cscreen = new cutscene(steve);
        cscreen.setPicture(cscreen.background);

        cutscene space1 = new cutscene(steve);
        space1.setPicture(space1.space);
        space1.setX(365);
        space1.setY(400);

        cutscene ss = new cutscene(steve);
        ss.setPicture(ss.lefts);
        ss.setX(550);
        ss.setY(400);

        cutscene rc = new cutscene(steve);
        rc.setPicture(rc.leftr);
        rc.setX(600);
        rc.setY(400);

        cutscene gc = new cutscene(steve);
        gc.setPicture(gc.leftg);
        gc.setX(625);
        gc.setY(400);

        cutscene bc = new cutscene(steve);
        bc.setPicture(bc.leftb);
        bc.setX(650);
        bc.setY(400);

        cutscene yc = new cutscene(steve);
        yc.setPicture(yc.lefty);
        yc.setX(675);
        yc.setY(400);

        List<WallMaker> lvl1 = new ArrayList<WallMaker>();
        for (int i = 0; i < l1.length; i++) {
            WallMaker wall = new WallMaker(steve, l1[i]);
            if (tunnels[i]) {
                wall.tunnel = true;
                wall.setPicture(coin);
                count.totalCoins++;
            } else {
                wall.tunnel = false;
            }
            if (red[i]) {
                wall.tunnel = true;
                wall.red = true;
                wall.setPicture(black);
            }
            lvl1.add(wall);

        }
        Steven steven = new Steven(steve);
        steven.setX(350);
        steven.setY(575);

        Ghost r = new Ghost(steve, 1);
        r.setX(25);
        r.setY(25);
        ghelper leftr = new ghelper(steve);
        leftr.setX(0 + 12.5);
        leftr.setY(25 + 12.5);
        ghelper upr = new ghelper(steve);
        upr.setX(25 + 12.5);
        upr.setY(0 + 12.5);
        ghelper downr = new ghelper(steve);
        downr.setX(25 + 12.5);
        downr.setY(50 + 12.5);
        ghelper rightr = new ghelper(steve);
        rightr.setX(50 + 12.5);
        rightr.setY(25 + 12.5);

        Ghost b = new Ghost(steve, 2);
        b.setX(25);
        b.setY(725);
        ghelper leftb = new ghelper(steve);
        leftb.setX(0 + 12.5);
        leftb.setY(725 + 12.5);
        ghelper rightb = new ghelper(steve);
        rightb.setX(50 + 12.5);
        rightb.setY(725 + 12.5);
        ghelper upb = new ghelper(steve);
        upb.setX(25 + 12.5);
        upb.setY(700 + 12.5);
        ghelper downb = new ghelper(steve);
        downb.setX(25 + 12.5);
        downb.setY(750 + 12.5);

        Ghost y = new Ghost(steve, 3);
        y.setX(650);
        y.setY(25);
        ghelper upy = new ghelper(steve);
        upy.setX(650);
        upy.setY(0 + 12.5);
        ghelper downy = new ghelper(steve);
        downy.setX(650 + 12.5);
        downy.setY(50 + 12.5);
        ghelper lefty = new ghelper(steve);
        lefty.setX(625 + 12.5);
        lefty.setY(25 + 12.5);
        ghelper righty = new ghelper(steve);
        righty.setX(675 + 12.5);
        righty.setY(25 + 12.5);

        Ghost g = new Ghost(steve, 4);
        g.setX(650);
        g.setY(725);
        ghelper upg = new ghelper(steve);
        upg.setX(650 + 12.5);
        upg.setY(700 + 12.5);
        ghelper downg = new ghelper(steve);
        downg.setX(650 + 12.5);
        downg.setY(750 + 12.5);
        ghelper leftg = new ghelper(steve);
        leftg.setX(625 + 12.5);
        leftg.setY(725 + 12.5);
        ghelper rightg = new ghelper(steve);
        rightg.setX(675 + 12.5);
        rightg.setY(725 + 12.5);

        exposition fexpo = new exposition(steve);
        fexpo.setPicture(fexpo.expoScreen);

        exposition screen = new exposition(steve);
        screen.setPicture(screen.blackscreen);
        exposition icon = new exposition(steve);
        icon.setPicture(icon.steven);
        icon.setX(175);
        icon.setY(50);
        exposition line2 = new exposition(steve);
        line2.setPicture(line2.line2);
        line2.setX(50);
        line2.setY(500);
        exposition cover2 = new exposition(steve);
        cover2.setPicture(cover2.linecover);
        cover2.setX(50);
        cover2.setY(500);
        exposition line1 = new exposition(steve);
        line1.setPicture(line1.line1);
        line1.setX(50);
        line1.setY(500);
        exposition cover1 = new exposition(steve);
        cover1.setPicture(cover1.linecover);
        cover1.setX(50);
        cover1.setY(500);

        title frontpage = new title(steve, 0);
        title cursor = new title(steve, 1);
        cursor.setX(150);
        cursor.setY(650);

        Dimension dim = new Dimension(700, 775);
        steve.setPreferredSize(dim);
        bf.setStringLayout(layout);
        int k = 0;

        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                bf.add(layout[i][j], (lvl1.get(k)).getSpriteComponent());
                k++;
            }
        }
        steve.addSpriteSpriteCollisionListener(bossMap.class, bossMap.class, new SpriteSpriteCollisionListener<bossMap, bossMap>() {
            @Override
            public void collision(bossMap b1, bossMap b2) {
                if ((b1.ind && b2.c1) || (b2.ind && b1.c1)) {
                    cloud1.setY(cloud2.getY() - 7750);
                }
                if ((b1.ind && b2.c2) || (b2.ind && b1.c1)) {
                    cloud2.setY(cloud1.getY() - 7750);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(WallMaker.class, WallMaker.class, new SpriteSpriteCollisionListener<WallMaker, WallMaker>() {
            @Override
            public void collision(WallMaker w1, WallMaker w2) {
                double x = w1.getX();
                double y = w1.getY();
                if (x - 675 == 0) {
                    w2.setX(0);
                    w2.setY(y + 25);
                } else {
                    w2.setX(x + 25);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(WallMaker.class, Steven.class, new SpriteSpriteCollisionListener<WallMaker, Steven>() {
            @Override
            public void collision(WallMaker w1, Steven s1) {

                if (!w1.tunnel) {
                    s1.setVelX(0);
                    s1.setVelY(0);
                    if (s1.getPicture() == s1.down1) {
                        s1.setY(s1.getY() - 25);
                    } else if (s1.getPicture() == s1.up1) {
                        s1.setY(s1.getY() + 25);
                    } else if (s1.getPicture() == s1.left1) {
                        s1.setX(s1.getX() + 25);
                    } else if (s1.getPicture() == s1.right1) {
                        s1.setX(s1.getX() - 25);
                    }

                } else if (w1.getPicture() == coin) {
                    w1.setPicture(black);
                    count.collected++;
                    //UNCOMMENT COUNT.COLLECTED == 3 TO SKIP THE PACMAN LEVEL
                    if (count.collected == count.totalCoins /*|| count.collected == 3*/) {

                        s1.setActive(false);
                        r.setActive(false);
                        leftr.setActive(false);
                        rightr.setActive(false);
                        downr.setActive(false);
                        upr.setActive(false);
                        b.setActive(false);
                        upb.setActive(false);
                        downb.setActive(false);
                        leftb.setActive(false);
                        rightb.setActive(false);
                        g.setActive(false);
                        downg.setActive(false);
                        upg.setActive(false);
                        leftg.setActive(false);
                        rightg.setActive(false);
                        y.setActive(false);
                        upy.setActive(false);
                        lefty.setActive(false);
                        righty.setActive(false);
                        downy.setActive(false);
                        for (int i = 0; i < lvl1.size(); i++) {
                            lvl1.get(i).setActive(false);
                        }
                        ss.setVelX(-1);
                        rc.setVelX(-1);
                        gc.setVelX(-1);
                        bc.setVelX(-1);
                        yc.setVelX(-1);
                    }
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(Penguin.class, bossMap.class, new SpriteSpriteCollisionListener<Penguin, bossMap>() {
            @Override
            public void collision(Penguin p, bossMap b) {
                if (b.getPicture() == b.hiddenMap) {
                    cloud1.setVelY(20);
                    cloud2.setVelY(20);
                    mapPiece.setActive(false);
                    hiddenMap.setActive(false);
                    m8.setActive(false);
                    m9.setActive(false);
                    m10.setActive(false);
                    m11.setActive(false);
                    m12.setActive(false);
                    m13.setActive(false);
                    m14.setActive(false);
                    m15.setActive(false);
                    m16.setActive(false);
                    m17.setActive(false);
                    m18.setActive(false);
                    m19.setActive(false);
                    m20.setActive(false);
                    m21.setActive(false);
                    gates.setVelY(0);
                    gates.setY(0);
                    leftHand.setX(100);
                    leftHand.setVelY(-2);
                    leftHand.setPicture(leftHand.leftFist);
                    leftHand.setY(200);
                    rightHand.setX(500);
                    rightHand.setY(200);
                    brandt.setVelY(0);
                    brandt.setY(600);
                    brandt.start = true;
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(Billiam.class, bossMap.class, new SpriteSpriteCollisionListener<Billiam, bossMap>() {
            @Override
            public void collision(Billiam g, bossMap b) {
                Random rand = new Random();
                double x;
                double y;
                int leftOrRight;
                if (b.getPicture() == b.mapPiece) {
                    for (int i = 0; i < pieces.length; i++) {
                        x = rand.nextDouble(5, 10);
                        y = rand.nextDouble(5, 10);
                        leftOrRight = rand.nextInt(10);
                        if (leftOrRight > 4) {
                            pieces[i].setVelX(-x);
                            pieces[i].setVelY(-y);
                        } else {
                            pieces[i].setVelX(x);
                            pieces[i].setVelY(-y);
                        }
                    }
                }
                if (b.getPicture() == b.bulletIndicator && g.getPicture() == g.leftFist) {
                    g.setPicture(g.leftFistBullet);
                    swing(brandt, g);
                }
                if (b.getPicture() == b.bulletIndicator && g.getPicture() == g.rightFist) {
                    g.setPicture(g.rightFistBullet);
                    swing(brandt, g);
                    g.setVelX(g.getVelX() + .5);
                }
                if (b.getPicture() == b.swingIndicator && g.getPicture() == g.leftFistBullet) {
                    g.setVelX(0);
                    g.setVelY(0);
                    g.setX(100);
                    g.setY(200);
                    g.setPicture(g.leftHand);
                    rightHand.setVelY(-3);
                    rightHand.setPicture(rightHand.rightFist);
                }
                if (b.getPicture() == b.swingIndicator && g.getPicture() == g.rightFistBullet) {
                    g.setVelX(0);
                    g.setVelY(0);
                    g.setX(500);
                    g.setY(200);
                    g.setPicture(g.rightHand);
                    leftHand.setVelY(-3);
                    leftHand.setPicture(leftHand.leftFist);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(cutscene.class, cutscene.class, new SpriteSpriteCollisionListener<cutscene, cutscene>() {
            @Override
            public void collision(cutscene c1, cutscene c2) {
                if (c1.getPicture() == c1.rightr && c2.getPicture() == c2.space) {
                    c2.setX(-300);
                    c2.setY(300);
                    c2.setPicture(c2.righticon);
                    c2.setVelX(2.2);
                } else if (c2.getPicture() == c2.rightr && c1.getPicture() == c1.space) {
                    c2.setX(0);
                    c2.setY(300);
                    c1.setPicture(c1.righticon);
                    c1.setVelX(2);
                }
                if (c1.getPicture() == c1.righticon && c2.getPicture() == c2.righty) {
                    c1.setActive(false);
                    c2.setActive(false);
                    rc.setActive(false);
                    gc.setActive(false);
                    bc.setActive(false);
                    cscreen.show = true;
                    cscreen.setActive(false);
                    lineCover1.setVelY(1);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(Billiam.class, Penguin.class, new SpriteSpriteCollisionListener<Billiam, Penguin>() {
            @Override
            public void collision(Billiam b, Penguin p) {
                if (b.getPicture() == b.rightFistBullet) {
                    p.marker--;
                    double x = b.getVelX();
                    double y = b.getVelY();
                    b.setVelX(0);
                    b.setVelY(0);
                    b.setX(500);
                    b.setY(200);
                    JOptionPane.showMessageDialog(steve, p.marker + " lives left!");
                    b.setPicture(b.rightFist);
                    b.setVelY(-3);
                }
                if (b.getPicture() == b.leftFistBullet) {
                    p.marker--;
                    double x = b.getVelX();
                    double y = b.getVelY();
                    b.setVelX(0);
                    b.setVelY(0);
                    b.setX(100);
                    b.setY(200);
                    JOptionPane.showMessageDialog(steve, p.marker + " lives left!");
                    b.setPicture(b.leftFist);
                    b.setVelY(-3);
                }
                if (p.marker == 0) {
                    b.setVelX(0);
                    b.setVelY(0);
                    JOptionPane.showMessageDialog(steve, "You failed to save your people.");
                    System.exit(0);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(Billiam.class, bullet.class, new SpriteSpriteCollisionListener<Billiam, bullet>() {
            @Override
            public void collision(Billiam b, bullet t) {
                if (b.getPicture() == b.icon) {
                    b.health--;
                    b.setPicture(b.red);
                }
                if (b.health < 0) {
                    b.setActive(false);
                    rightHand.setVelX(0);
                    rightHand.setVelY(0);
                    leftHand.setVelX(0);
                    rightHand.setVelY(0);
                    JOptionPane.showMessageDialog(steve, "You saved your people!");
                    System.exit(0);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(bullet.class, bossMap.class, new SpriteSpriteCollisionListener<bullet, bossMap>() {
            @Override
            public void collision(bullet b, bossMap m) {
                if (m.getPicture() == m.bulletIndicator) {
                    b.setActive(false);
                    gates.setPicture(gates.icon);
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(WallMaker.class, ghelper.class, new SpriteSpriteCollisionListener<WallMaker, ghelper>() {
            @Override
            public void collision(WallMaker w1, ghelper g1) {
                if (w1.tunnel) {
                    g1.inWall = false;
                } else {
                    g1.inWall = true;
                }
            }
        });

        steve.addSpriteSpriteCollisionListener(Steven.class, Ghost.class, new SpriteSpriteCollisionListener<Steven, Ghost>() {
            public void collision(Steven s1, Ghost g1) {
                if (s1.marker < 3) {
                    steven.setX(350);
                    steven.setY(575);
                    r.setX(25);
                    r.setY(25);
                    leftr.setX(0 + 12.5);
                    leftr.setY(25 + 12.5);
                    upr.setX(25 + 12.5);
                    upr.setY(0 + 12.5);
                    downr.setX(25 + 12.5);
                    downr.setY(50 + 12.5);
                    rightr.setX(50 + 12.5);
                    rightr.setY(25 + 12.5);
                    b.setX(25);
                    b.setY(725);
                    leftb.setX(0 + 12.5);
                    leftb.setY(725 + 12.5);
                    rightb.setX(50 + 12.5);
                    rightb.setY(725 + 12.5);
                    upb.setX(25 + 12.5);
                    upb.setY(700 + 12.5);
                    downb.setX(25 + 12.5);
                    downb.setY(750 + 12.5);
                    y.setX(650);
                    y.setY(25);
                    upy.setX(650);
                    upy.setY(0 + 12.5);
                    downy.setX(650 + 12.5);
                    downy.setY(50 + 12.5);
                    lefty.setX(625 + 12.5);
                    lefty.setY(25 + 12.5);
                    righty.setX(675 + 12.5);
                    righty.setY(25 + 12.5);
                    g.setX(650);
                    g.setY(725);
                    upg.setX(650 + 12.5);
                    upg.setY(700 + 12.5);
                    downg.setX(650 + 12.5);
                    downg.setY(750 + 12.5);
                    leftg.setX(625 + 12.5);
                    leftg.setY(725 + 12.5);
                    rightg.setX(675 + 12.5);
                    rightg.setY(725 + 12.5);
                    s1.marker++;
                }
                if (s1.marker == 1) {
                    JOptionPane.showMessageDialog(steve, "2 lives left");
                }
                if (s1.marker == 2) {
                    JOptionPane.showMessageDialog(steve, "1 life left");
                }
                if (s1.marker == 3) {
                    JOptionPane.showMessageDialog(steve, "You lose :(");
                    System.exit(0);
                }
            }
        });
        Clock.addTask(steve.moveSprites());
        bf.show();
        Clock.start(10);

        KeyAdapter ka = new KeyAdapter() {

            int action = 0;

            @Override
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_UP) {
                    if (frontpage.show == false && !cscreen.show) {
                        if (cursor.marker == 0) {
                            frontpage.show = true;
                            cursor.setActive(false);
                            frontpage.setActive(false);
                        } else if (cursor.marker == 1) {
                            JOptionPane.showMessageDialog(steve, "Read the .txt file");
                        } else if (cursor.marker == 2) {
                            System.exit(0);
                        }
                    }
                    if (icon.show == false && frontpage.show && !cscreen.show) {
                        if (cover1.marker == 0) {
                            cover1.setVelY(.5);
                        } else {
                            cover1.setActive(false);
                            line1.setActive(false);
                            cover2.setVelY(.5);
                        }
                        if (cover2.marker > 0) {
                            cover2.setActive(false);
                            line2.setActive(false);

                            icon.setActive(false);
                            screen.setVelY(1);
                        }
                        if (screen.getY() >= 775) {
                            icon.show = true;
                            screen.setActive(false);
                            fexpo.setActive(false);
                        }
                    }
                    if (icon.show && !cscreen.show) {
                        if (action > 0) {
                            steven.setY(steven.getY() - 25);
                            steven.setPicture(steven.up1);
                            action--;
                        }
                    }
                    if (cscreen.show) {
                        if (lineCover1.marker > 0) {
                            lineCover1.setActive(false);
                            fline1.setActive(false);
                            lore.setPicture(lore.fuse);
                            lorescreen.setPicture(lorescreen.screen);
                            lorescreen.setVelY(1);
                        }
                        if (lorescreen.getY() > 775) {
                            fBlue.setActive(false);
                            fRed.setActive(false);
                            fYellow.setActive(false);
                            fGreen.setActive(false);
                            billCover.setActive(false);
                            lore.setActive(false);
                            lorescreen.setActive(false);
                            lineCover2.setVelY(1);
                        }
                        if (lineCover2.marker > 0) {
                            lineCover2.setActive(false);
                            fline2.setActive(false);
                            lineCover3.setVelY(1);
                        }
                        if (lineCover3.marker > 0) {
                            lineCover3.setActive(false);
                            fline3.setActive(false);
                            lineCover4.setVelY(1);
                        }
                        if (lineCover4.marker > 0) {
                            lineCover4.setActive(false);
                            fline4.setActive(false);
                            ascendedSteve.setPicture(ascendedSteve.ascend);
                            ascendedSteveScreen.setPicture(ascendedSteveScreen.screen);
                            ascendedSteveScreen.setVelY(1);
                        }
                        if (ascendedSteveScreen.getY() > 775) {
                            ascendedSteve.setActive(false);
                            ascendedSteveScreen.setActive(false);
                            finalSteve.setActive(false);
                            penguinCover.setActive(false);
                            lineCover5.setVelY(1);
                        }
                        if (lineCover5.marker > 0 && !brandt.start) {
                            lineCover5.setActive(false);
                            fline5.setActive(false);
                            bill.setActive(false);
                            finalScreen.setActive(false);
                            penguin.setActive(false);
                            gates.setVelY(-30);
                            brandt.setVelY(-30);
                        }
                        if (brandt.start && action > 0) {
                            bullet b = new bullet(steve);
                            b.setPicture(b.bullet);
                            b.setX(brandt.getX() + 40);
                            b.setY(brandt.getY());
                            b.setVelY(-8);
                            action--;
                        }
                    }
                }
                if (key.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (icon.show) {
                        if (action > 0) {
                            steven.setY(steven.getY() + 25);
                            steven.setPicture(steven.down1);
                            action--;
                        }
                    }
                }
                if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (action > 0 && !brandt.start) {
                        if (cursor.marker == 0) {
                            cursor.marker++;
                            cursor.setX(350);
                        } else if (cursor.marker == 1) {
                            cursor.marker++;
                            cursor.setX(550);
                        } else if (cursor.marker == 2) {
                            cursor.marker = 0;
                            cursor.setX(150);
                        }
                        if (icon.show) {
                            steven.setX(steven.getX() + 25);
                            steven.setPicture(steven.right1);
                        }
                        action--;
                    }
                    if (brandt.start) {
                        brandt.setPicture(brandt.right);
                        brandt.setVelX(5);
                    }

                }
                if (key.getKeyCode() == KeyEvent.VK_LEFT) {

                    if (action > 0 && !brandt.start) {
                        if (cursor.marker == 0) {
                            cursor.marker = 2;
                            cursor.setX(550);
                        } else if (cursor.marker == 1) {
                            cursor.marker--;
                            cursor.setX(150);
                        } else if (cursor.marker == 2) {
                            cursor.marker--;
                            cursor.setX(350);
                        }
                        if (icon.show) {
                            steven.setX(steven.getX() - 25);
                            steven.setPicture(steven.left1);
                        }
                        action--;

                    }
                    if (brandt.start) {
                        brandt.setPicture(brandt.left);
                        brandt.setVelX(-5);

                    }

                }
            }

            public void keyReleased(KeyEvent key) {
                if (icon.show) {
                    moveRed(r, upr, downr, leftr, rightr, steven);
                    movePink(y, upy, downy, lefty, righty, steven);
                    moveBlue(b, upb, downb, leftb, rightb, steven, r);
                    moveGreen(g, upg, downg, leftg, rightg, steven);
                }
                if (action < 1) {
                    action++;

                }
                if (brandt.start) {
                    brandt.setPicture(brandt.up);
                    brandt.setVelX(0);
                }

            }
        };
        bf.addKeyListener(ka);

    }
    static Picture blackPicture = new Picture("black.png");

    public static boolean check(String name1) {
        try {

            Picture image = new Picture(name1);
            BufferedImage newImage = (BufferedImage) image.getImage();
            BufferedImage black = (BufferedImage) blackPicture.getImage();
            boolean equal = true;
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 25; j++) {
                    if (newImage.getRGB(i, j) != black.getRGB(0, 0)) {
                        equal = false;
                    }
                }
            }
            return equal;
        } catch (Exception e) {
        }
        return false;
    }
    static Picture redPic = new Picture("red.png");

    public static boolean check2(String name1) {
        try {

            Picture image = new Picture(name1);
            BufferedImage newImage = (BufferedImage) image.getImage();
            BufferedImage red = (BufferedImage) redPic.getImage();
            boolean redImage = false;
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 25; j++) {
                    if (newImage.getRGB(i, j) == red.getRGB(0, 0)) {
                        redImage = true;
                    }
                }
            }
            return redImage;
        } catch (Exception e) {
        }
        return false;
    }

    public static void moveRed(Ghost g, ghelper up, ghelper down, ghelper left, ghelper right, Steven steve) {
        double px = steve.getX();
        double py = steve.getY();
        double gx = g.getX();
        double gy = g.getY();
        Picture s = g.getPicture();
        if (s == g.up) {
            double upd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (upd <= leftd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            } else if (leftd <= upd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= upd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.down) {
            double downd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (downd <= leftd && downd <= rightd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= downd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.left) {
            double downd = 1000;
            double leftd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= leftd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= upd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (upd <= downd && upd <= leftd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        } else if (s == g.right) {
            double downd = 1000;
            double rightd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= rightd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (rightd <= downd && rightd <= upd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            } else if (upd <= downd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        }

    }

    public static void movePink(Ghost g, ghelper up, ghelper down, ghelper left, ghelper right, Steven steve) {
        double px;
        double py;
        if (steve.getPicture() == steve.up1) {
            px = steve.getX();
            py = steve.getY() - 100;
        } else if (steve.getPicture() == steve.down1) {
            px = steve.getX();
            py = steve.getY() + 100;
        } else if (steve.getPicture() == steve.left1) {
            px = steve.getX() - 100;
            py = steve.getY();
        } else {
            px = steve.getX() + 100;
            py = steve.getY();
        }

        double gx = g.getX();
        double gy = g.getY();
        Picture s = g.getPicture();
        if (s == g.up) {
            double upd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (upd <= leftd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            } else if (leftd <= upd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= upd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.down) {
            double downd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (downd <= leftd && downd <= rightd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= downd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.left) {
            double downd = 1000;
            double leftd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= leftd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= upd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (upd <= downd && upd <= leftd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        } else if (s == g.right) {
            double downd = 1000;
            double rightd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= rightd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (rightd <= downd && rightd <= upd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            } else if (upd <= downd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        }
    }

    public static void moveBlue(Ghost g, ghelper up, ghelper down, ghelper left, ghelper right, Steven steve, Ghost red) {
        double px;
        double py;
        if (steve.getPicture() == steve.up1) {
            px = steve.getX();
            py = steve.getY() - 50;
        } else if (steve.getPicture() == steve.down1) {
            px = steve.getX();
            py = steve.getY() + 50;
        } else if (steve.getPicture() == steve.left1) {
            px = steve.getX() - 50;
            py = steve.getY();
        } else {
            px = steve.getX() + 50;
            py = steve.getY();
        }

        double gx = red.getX();
        double gy = red.getY();
        Picture s = g.getPicture();
        if (s == g.up) {
            double upd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (upd <= leftd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            } else if (leftd <= upd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= upd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.down) {
            double downd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (downd <= leftd && downd <= rightd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= downd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.left) {
            double downd = 1000;
            double leftd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= leftd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= upd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (upd <= downd && upd <= leftd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        } else if (s == g.right) {
            double downd = 1000;
            double rightd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= rightd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (rightd <= downd && rightd <= upd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            } else if (upd <= downd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        }
    }

    public static void moveGreen(Ghost g, ghelper up, ghelper down, ghelper left, ghelper right, Steven steve) {
        Random rand = new Random();
        double px = steve.getX();
        double py = steve.getY();

        double gx = g.getX();
        double gy = g.getY();
        Picture s = g.getPicture();
        if (s == g.up) {
            double upd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!up.inWall) {
                upd = rand.nextDouble(100);
            }
            if (!left.inWall) {
                leftd = rand.nextDouble(100);
            }
            if (!right.inWall) {
                rightd = rand.nextDouble(100);
            }
            if (upd <= leftd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            } else if (leftd <= upd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= upd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.down) {
            double downd = 1000;
            double leftd = 1000;
            double rightd = 1000;
            if (!down.inWall) {
                downd = rand.nextDouble(100);
            }
            if (!left.inWall) {
                leftd = rand.nextDouble(100);
            }
            if (!right.inWall) {
                rightd = rand.nextDouble(100);
            }
            if (downd <= leftd && downd <= rightd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= rightd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (rightd <= downd && rightd <= leftd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            }
        } else if (s == g.left) {
            double downd = 1000;
            double leftd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!left.inWall) {
                leftd = vector(gx - 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= leftd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (leftd <= downd && leftd <= upd) {
                g.setPicture(g.left);
                g.setX(g.getX() - 25);
                up.setX(up.getX() - 25);
                down.setX(down.getX() - 25);
                left.setX(left.getX() - 25);
                right.setX(right.getX() - 25);
            } else if (upd <= downd && upd <= leftd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        } else if (s == g.right) {
            double downd = 1000;
            double rightd = 1000;
            double upd = 1000;
            if (!down.inWall) {
                downd = vector(gx, px, gy + 25, py);
            }
            if (!right.inWall) {
                rightd = vector(gx + 25, px, gy, py);
            }
            if (!up.inWall) {
                upd = vector(gx, px, gy - 25, py);
            }
            if (downd <= rightd && downd <= upd) {
                g.setPicture(g.down);
                g.setY(g.getY() + 25);
                up.setY(up.getY() + 25);
                down.setY(down.getY() + 25);
                left.setY(left.getY() + 25);
                right.setY(right.getY() + 25);
            } else if (rightd <= downd && rightd <= upd) {
                g.setPicture(g.right);
                g.setX(g.getX() + 25);
                up.setX(up.getX() + 25);
                down.setX(down.getX() + 25);
                left.setX(left.getX() + 25);
                right.setX(right.getX() + 25);
            } else if (upd <= downd && upd <= rightd) {
                g.setPicture(g.up);
                g.setY(g.getY() - 25);
                up.setY(up.getY() - 25);
                down.setY(down.getY() - 25);
                left.setY(left.getY() - 25);
                right.setY(right.getY() - 25);
            }
        }
    }

    public static double vector(double x1, double x2, double y1, double y2) {
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        double distance = Math.sqrt(x + y);
        return distance;
    }

    public static void swing(Penguin p, Billiam b) {
        double delx = p.getX() - b.getX() - p.getWidth() / 2;
        double dely = p.getY() - b.getY() - p.getHeight() / 2;
        double dist = Math.sqrt(delx * delx + dely * dely);
        b.setVelX(7 * (2 * delx / dist));
        b.setVelY(7 * (2 * dely / dist));
    }

    static ArrayList<String> contents(Class<?> c, String name) throws Exception {

        URL url = c.getResource(name);
        System.out.println("url: " + url);
        InputStream o = url.openStream();
        InputStreamReader r = new InputStreamReader(o);
        BufferedReader br = new BufferedReader(r);
        ArrayList<String> n = new ArrayList<>();
        for (String s = br.readLine(); s != null; s = br.readLine()) {
            n.add(s);
        }
        return n;
    }

}
