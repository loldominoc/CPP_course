import java.util.Random;

public class Task5 {
    public static void run() {
        Random rand = new Random();
        int size = 20;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(101) - 50;
        }

        int[] evenNumbers = getEvenNumbers(array);
        int[] fibonacciNumbers = getFibonacciNumbers(array);
        int[] negativeNumbers = getNegativeNumbers(array);
        int[] primeNumbers = getPrimeNumbers(array);

        System.out.println("Оригінальний масив:");
        printArray(array);

        System.out.println("\nПарні числа:");
        printArray(evenNumbers);

        System.out.println("\nЧисла Фібоначчі:");
        printArray(fibonacciNumbers);

        System.out.println("\nВід’ємні числа більші за -17:");
        printArray(negativeNumbers);

        System.out.println("\nПрості числа:");
        printArray(primeNumbers);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            if (num != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static int[] getEvenNumbers(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                temp[index++] = num;
            }
        }
        return shrinkArray(temp, index);
    }

    public static int[] getFibonacciNumbers(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;

        for (int num : array) {
            if (isFibonacci(num)) {
                temp[index++] = num;
            }
        }
        return shrinkArray(temp, index);
    }

    public static int[] getNegativeNumbers(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;

        for (int num : array) {
            if (num < 0 && num > -17) {
                temp[index++] = num;
            }
        }
        return shrinkArray(temp, index);
    }

    public static int[] getPrimeNumbers(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;

        for (int num : array) {
            if (isPrime(num)) {
                temp[index++] = num;
            }
        }
        return shrinkArray(temp, index);
    }

    public static int[] shrinkArray(int[] array, int length) {
        int[] result = new int[length];
        System.arraycopy(array, 0, result, 0, length);
        return result;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFibonacci(int num) {
        if (num < 0) return false;
        int x1 = 5 * num * num + 4;
        int x2 = 5 * num * num - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return num == sqrt * sqrt;
    }
}
