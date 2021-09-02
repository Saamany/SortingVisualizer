import java.awt.*;

/**
 * @author Saam Eymany
 * @version 1.0
 * @since 2021-07-25
 */

public class Mergesort {
    Graphics g;
    int[] num;
    int arrayLength;
    String speed;
    int compares;
    Drawer d;

    public void sort() {
        d = new Drawer(arrayLength, num, g, speed);


        mergeSort(0, num.length - 1);

    }

    public int[] mergeSort(int l, int r) {

        if (l < r) {
            int q = (l + r) / 2;
            d.paintComponents(new int[] {l, r});
            compares++;
            mergeSort(l, q);
            mergeSort(q + 1, r);
            merge(l, q, r);
            d.paintComponents(new int[] {l, r});
        }
        return num;
    }

    private void merge(int l, int q, int r) {
        int[] arr = new int[num.length];
        int i, j;
        for (i = l; i <= q; i++) {
            arr[i] = num[i];
        }
        for (j = q + 1; j <= r; j++) {
            arr[r + q + 1 - j] = num[j];
        }
        i = l;
        j = r;
        for (int k = l; k <= r; k++) {
            if (arr[i] <= arr[j]) {
                num[k] = arr[i];
                i++;
            } else {
                num[k] = arr[j];
                j--;
            }
            compares++;
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
