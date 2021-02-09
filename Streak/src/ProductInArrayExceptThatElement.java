public class ProductInArrayExceptThatElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int i, zerocnt = 0, p = 1, pos = -1;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zerocnt++;
                pos = i;
            }
        }
        if (zerocnt == 1) {
            for (i = 0; i < arr.length; i++) {
                p *= arr[i];
            }
            for (i = 0; i < arr.length; i++) {
                if (i != pos) {
                    System.out.print("0 ");
                } else {
                    System.out.print(p + " ");
                }
            }
        } else if (zerocnt > 1) {
            for (i = 0; i < arr.length; i++) {
                System.out.print("0 ");
            }
        } else {
            for (i = 0; i < 5; i++) {
                p = p * arr[i];
            }
            for (i = 0; i < arr.length; i++) {
                System.out.print(p / arr[i] + " ");
            }
        }
    }
}