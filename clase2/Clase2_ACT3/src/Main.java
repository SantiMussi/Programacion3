public class Main {
    public static void main(String[] args) {
        QuickSort busc= new QuickSort();
        int [] arr={1,3,6,8,10,2,4,7,9};
        busc.quickSort(arr,0,arr.length-1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}