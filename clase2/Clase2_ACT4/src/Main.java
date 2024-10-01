public class Main {
    public static void main(String[] args) {
        MergeSort busc= new MergeSort();
        int [] arr={3,2,5,4,7,6,10,9,1,8,};
        busc.mergeSort(arr);
        for (int num:arr){
            System.out.print(num+" ");
        }
    }
}