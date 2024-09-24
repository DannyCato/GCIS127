package unit07.practicum;

public class Practice01 {
    public static String arrayToString(int[] arr) {
        String ret = "[";
        boolean start = true;
        for (int i : arr) {
            if (!start) {
                ret += ", ";
            }
            start = false;
            ret += i;
        }
        ret += "]";
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(arrayToString(arr));
    }
}
