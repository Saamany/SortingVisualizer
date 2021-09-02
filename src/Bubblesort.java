import java.awt.*;
import java.util.Arrays;

/**
 * @author Saam Eymany
 * @version 1.0
 * @since 2021-07-25
 */

public class Bubblesort {
    Graphics g;
    int[] num;
    int arrayLength;
    String speed;
    int temp = 0;
    int compares;
    Drawer d;


    public void sort(){
        d = new Drawer(arrayLength, num, g, speed);
        bubbleSort();

    }
    public void bubbleSort() {

        System.out.println(Arrays.toString(num));
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < (num.length - i); j++) {
                if (num[j - 1] > num[j]) {
                    //swap elements
                    temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;
                    if (!d.isSorted(num)) {
                        System.out.println(Arrays.toString(num));
                    }
                }
                d.paintComponents(new int[]{j - 1, j});



                compares++;


            }
            if(d.isSorted(num)) {
                d.showOrderedView();
                break;
            }
        }


    }

    /**
     * @param l ist Länge des Array
     */
    public void setSelectedArrayLength(int l) {
        this.arrayLength = l;
    }

    /**
     * @param s ist die Geschwindigkeit
     */
    public void setSelectedTempo(String s) {
        this.speed = s;
    }

    /**
     * @param n ist das Array
     */
    public void setArray(int[] n) {
        this.num = n;
    }

    /**
     * @return die Anzahl Vergleiche, die beim sortieren enstanden sind
     */
    public int getCompares() {
        return compares;
    }

    /**
     * löscht die Vergleiche
     */
    public void deleteCompares(){
        compares = 0;
    }
}
