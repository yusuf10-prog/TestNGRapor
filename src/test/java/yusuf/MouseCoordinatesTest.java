package yusuf;

import utilities.ReusableMethods;

import java.awt.*;

public class MouseCoordinatesTest {
    public static void main(String[] args) {
        ReusableMethods.bekle(10);
        Point point = MouseInfo.getPointerInfo().getLocation();
        int x = (int) point.getX();
        int y = (int) point.getY();
        System.out.println("Mouse coordinates: " + x + ", " + y);

        //Adres çubuğu: 608, 218
        //ok tusu :698, 218
        //dosya yolu : C:\Users\orako\IdeaProjects\Project_Team_08\target\generated-test-sources\test-annotations
        // logo :407, 342
        //aç:781, 607
    }
}

