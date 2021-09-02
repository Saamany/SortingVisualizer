import java.awt.*;
import java.util.Arrays;

/**
 * @author Saam Eymany
 * @version 1.0
 * @since 2021-07-25
 */

public class Drawer {

    int width, xPos, multiplikator, arrayLength;
    int[] num;
    Graphics g;
    String speed;

    //Dieser Konstruktor dient dazu die Angaben der Menu-Klasse zu bekommen
    public Drawer(int arrayLength, int[] num, Graphics g, String speed) {
        this.arrayLength = arrayLength;
        this.num = num;
        this.g = g;
        this.speed = speed;
    }

    /**
     *
     * @param array ist der ausgewählte Array
     * @return ein Boolean, der anzeigt, ob das Array sortiert ist
     */
    public boolean isSorted(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;

    }


    /**
     * Diese Methode ist für die Visualisierung der Sortier-Algorythmen zuständig
     * @param mark ist das ausgewählte Array
     */
    public void paintComponents(int[] mark){
        if (arrayLength == 10) {
            width = 30;
            xPos = 50;
            multiplikator = 30;
        } else if (arrayLength == 20) {
            width = 15;
            xPos = 25;
            multiplikator = 15;
        } else if (arrayLength == 30) {
            width = 10;
            xPos = 16;
            multiplikator = 10;
        } else if (arrayLength == 40) {
            width = 7;
            xPos = 16;
            multiplikator = 7;
        }
        g.setColor(Color.WHITE);
        g.fillRect(50, 200, 700, 350);
            for (int k = 0; k < num.length; k++) {
                    if(arrayContains(mark, k)) {
                        if(isSorted(num)){
                            showOrderedView();
                            showOrderedArray();
                            break;
                        }else {
                            g.setColor(Color.RED);
                        }
                    }else {
                        g.setColor(Color.BLACK);
                    }
                    g.fillRect(100 + xPos * k, 500 - num[k] * multiplikator, width, num[k] * multiplikator);
                    g.drawString("" + num[k], 100 + xPos * k, 530);


            }
        try {
            if (speed == "langsam") {
                Thread.sleep(350);
            } else if (speed == "normal") {
                Thread.sleep(200);
            } else if (speed == "schnell") {
                Thread.sleep(10);
            }

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Diese Methode wird für die Visualisierung genutzt
     * @param arr ist das ausgewählte Array
     * @param key ist die Zahl aus dem Array, welche verglichen wird
     * @return ein Boolean
     */
    private boolean arrayContains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    /**
     * Hier wird das sortierte Array im Terminal ausgegeben.
     */
    public void showOrderedArray() {
        System.out.println(Arrays.toString(num));
    }

    /**
     * Hier wird das sortierte Array visuel dargestellt.
     */
    public void showOrderedView() {

        for (int k = 0; k < num.length; k++) {
            g.setColor(Color.GREEN);
            g.fillRect(100 + xPos * k, 500 - num[k] * multiplikator, width, num[k] * multiplikator);
            g.drawString("" + num[k], 100 + xPos * k, 530);
        }
    }
}
