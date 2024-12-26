package hw.oop;

public class Block5 {

    // 5.1
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал индекс первого вхождения
    числа x в массив arr. Если число не входит
    в массив – возвращается -1.
     */
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // 5.2
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал индекс последнего
    вхождения числа x в массив arr. Если число
    не входит в массив – возвращается -1.
     */
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // 5.3
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал наибольшее по модулю
    (то есть без учета знака) значение массива arr.
     */
    // Возможно, решение тупое, что-то на ум ничего другого не приходит
    public static int maxAbs(int[] arr) {
        int max = arr[0];
        int indexOfMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && arr[i] * -1 > max) {
                max = arr[i] * -1;
                indexOfMax = i;
            } else if (arr[i] > max) {
                max = arr[i];
                indexOfMax = i;
            }
        }
        return arr[indexOfMax];
    }

    // 5.4
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал количество положительных
    элементов массива arr.
     */
    public static int countPositive(int[] arr) {
        int count = 0;
        for (int currentNum : arr) {
            if (currentNum > 0)
                count++;
        }
        return count;
    }

    // 5.5
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал true, если массив arr
    является палиндромом, то есть справа-налево
    и наоборот читается одинаково
     */
    public static boolean isPalindrome(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] != arr[arr.length-i-1]) {
                return false;
            }
        }
        return true;
    }

    // 5.6
    /*
    Необходимо реализовать метод таким образом,
    чтобы он изменял массив arr.
    После проведенных изменений массив должен
    быть записан задом-наперед
     */
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp;
            temp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
            arr[i] = temp;
        }
    }

    // 5.7
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал новый массив, в котором
    значения массива arr записаны задом наперед.
     */
    public static int[] reverseBack(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length-i-1];
        }
        return newArr;
    }

    // 5.8
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал новый массив, в котором
    сначала идут элементы первого массива (arr1),
    а затем второго (arr2).
     */
    public static int[] concat(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length+arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            newArr[arr1.length+i] = arr2[i];
        }
        return newArr;
    }

    // 5.9
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал новый массив, в котором
    записаны индексы всех вхождений числа x в
    массив arr.
     */
    public static int[] findAll(int[] arr, int x) {
        StringBuilder nums = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                nums.append(i);
        }
        int[] newArr = new int[nums.length()];
        for (int i = 0; i < nums.length(); i++) {
            newArr[i] = nums.charAt(i) - '0';
        }
        return newArr;
        // Билдер использовал, чтобы второй раз по всему массиву не проходить
        // Можно и строку, но она иммутабельная
    }

    // 5.10
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал новый массив, в котором
    записаны все элементы массива arr кроме
    отрицательных.
     */
    public static int[] deleteNegative(int[] arr) {
        StringBuilder positive = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                positive.append(arr[i]);
        }
        int[] newArr = new int[positive.length()];
        for (int i = 0; i < positive.length(); i++) {
            newArr[i] = positive.charAt(i) - '0';
        }
        return newArr;
    }

    // 5.11
    /*
    Необходимо реализовать метод таким образом,
    чтобы он возвращал новый массив, который
    будет содержать все элементы массива arr,
    однако в позицию pos будет вставлено значение x.
     */
    public static int[] add(int[] arr, int x, int pos) {
        int[] newArr = new int[arr.length + 1];
        int i = 0;
        while (i < pos) {
            newArr[i] = arr[i];
            i++;
        }
        newArr[i] = x;
        i++;
        while (i < newArr.length) {
            newArr[i] = arr[i-1];
            i++;
        }
        return newArr;
        // Чтобы в одном цикле не вызывать if на каждую итерацию
    }

        // 5.12
        /*
        Необходимо реализовать метод таким образом,
        чтобы он возвращал новый массив, который
        будет содержать все элементы массива arr,
        однако в позицию pos будутвставлены значения
        массива ins.
         */
        public static int[] add2(int[] arr, int[] ins, int pos) {
            int[] newArr = new int[arr.length+ins.length];
            int i = 0;
            while (i < pos) {
                newArr[i] = arr[i];
                i++;
            }
            for (int j = 0; j < ins.length; j++) {
                newArr[i] = ins[j];
                i++;
            }
            while (i < newArr.length) {
                newArr[i] = arr[i-ins.length];
                i++;
            }
            return newArr;
        }
}
