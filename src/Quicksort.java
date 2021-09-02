import java.awt.*;

/**
 * @author Saam Eymany
 * @version 1.0
 * @since 2021-07-25
 */

public class Quicksort {
    Graphics g;
    int[] num;
    int arrayLength;
    String speed;
    int compares;
    Drawer d;

    public void sort() {
        d = new Drawer(arrayLength, num, g, speed);


        quickSort(num,0,num.length-1);

    }
    public void quickSort ( int arr[], int low, int high)
    {

        if (low < high) {
            int pi = partition(arr, low, high);
            d.paintComponents(new int[] {low, high});
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
            compares++;
        }
    }
    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                compares++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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
