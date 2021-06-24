import java.util.Arrays;

public class Repeat {
    public static void main(String[] args) {
        int[] arr={2,3,1,0,2,5,3};
        Arrays.sort(arr);
        int a=arr.length;
        for (int i = 1; i <a-1; i++) {
            if(arr[i]==arr[i+1]){
                System.out.print(arr[i]+"\t");
            }
        }
    }
}
