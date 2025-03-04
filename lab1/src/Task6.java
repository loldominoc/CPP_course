import java.util.Arrays;

public class Task6 {
    public static void run() {
        double[] numbers = {6, 3, 1, 8, 6, 7, 4};
        System.out.println("Оригінальний масив: " + Arrays.toString(numbers));
        sortRelativeToMax(numbers);
        System.out.println("Відсортований масив: " + Arrays.toString(numbers));
    }

    public static void sortRelativeToMax(double[] arr) {
        if (arr == null || arr.length == 0) return;

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = maxIndex + 1; i < arr.length - 1; i++) {
            for (int j = maxIndex + 1; j < arr.length - (i - maxIndex); j++) {
                if (arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
