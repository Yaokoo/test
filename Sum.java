import java.util.Arrays;

class Sum {
    public static void main(String[] args) {
        int[] arr={2,7,11,5};
        int target=9;
        int[] a=twoSum(arr,target);
        System.out.println(Arrays.toString(a));
    }
    public static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == target - arr[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
