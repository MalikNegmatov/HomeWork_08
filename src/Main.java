import java.util.Arrays;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        // Задачи 1 части темы Массивы

        // Пишем код для задачи 1
        int[] index = new int[]{1, 2, 3};
        double[] vector = {1.57, 7.654, 9.986};
        double[] tensor = {1, 0, 0, 0, 1, 0, 0, 0, 0.001};
        System.out.println("Задача №1.1 \nМассивы index, vector и tensor инициализированы.");

        task1_2(index, vector, tensor);
        task1_3(index, vector, tensor);

        index = new int[]{1, 3, 2, 2, 4, 5, 65, 77, 5};
        task1_4(index);

        // Задачи 2 части темы Массивы

        task2_1();
        task2_2();
        task2_3(29);
        task2_4();

        // Из раздела доп.задач к теме Массивы
        taskAddProblem1(20,20,-10,-2);
        taskAddProblem1(30,30,-15,8);
    }

    /**
     * Метод для вывода элементов массива типа double через разделитель "запятая"
     *
     * @param array -- передаваемый массив данных типа double
     * @param style -- порядок печати: True печатаем с первого по последний; False печатаем в обратном порядке
     * @return строка с форматированным выводом элементов массива
     */
    public static String doubleArrayPrint(double[] array, boolean style) {
        String strOutput = "";
        if (style) {
            for (double j : array) strOutput = String.format("%s, %s", strOutput, j);
            return strOutput.substring(2);
        } else {
            for (double j : array) strOutput = String.format("%s, %s", j, strOutput);
            return strOutput.substring(0, (strOutput.length() - 2));
        }
    }

    public static void task1_2(int[] arrayIndex, double[] arrayVector, double[] arrayTensor) {
        System.out.println("\nЗадача №1.2");
//      Пишем код для задачи 2

        String strOutput = Arrays.toString(arrayIndex); // чит-код
        System.out.println(strOutput.substring(1,(strOutput.length() - 1))); // why not ) ?

        System.out.println(doubleArrayPrint(arrayVector, true));
        System.out.println(doubleArrayPrint(arrayTensor, true));
    }

    public static void task1_3(int[] arrayIndex, double[] arrayVector, double[] arrayTensor) {
        System.out.println("\nЗадача №1.3");

        String strOutput = Integer.toString(arrayIndex[2]);
        for (int i = (arrayIndex.length - 2); i >= 0; i--) {
            strOutput = String.format("%s, %d", strOutput, arrayIndex[i]);
        }
        System.out.println(strOutput);

        System.out.println(doubleArrayPrint(arrayVector, false));
        System.out.println(doubleArrayPrint(arrayTensor, false));
    }

    public static void task1_4(int[] arrayIndex) {
        System.out.println("\nЗадача № 1.4");
        // Пишем код для задачи 4
        for (int i = 0; i < arrayIndex.length; i++) if (arrayIndex[i] % 2 > 0) arrayIndex[i]++;
        System.out.println(Arrays.toString(arrayIndex));
    }

    // Задачи массивы Урок 2


    public static void task2_1() {
        System.out.println("\nЗадача № 2.1");

        int[] arrayMonthSpending = generateRandomArray(30, 100000, 100000);
        int sumMonthSpending = 0;

        for (int i : arrayMonthSpending) {
            sumMonthSpending += i;
        }
        System.out.println("Сумма трат за месяц составила " + sumMonthSpending + " рублей");
    }

    public static void task2_2() {
        System.out.println("\nЗадача № 2.2");

        int[] arrayDaySpending = generateRandomArray(21, 100000, 100000);
        int minSpending = arrayDaySpending[0];
        int maxSpendig = arrayDaySpending[0];

        for (int i : arrayDaySpending) {
            if (i < minSpending)  minSpending = i;
            if (i > maxSpendig)  maxSpendig = i;
        }

        System.out.println("Минимальная сумма трат за день составила " + minSpending + " рублей");
        System.out.println("Максимальная сумма трат за день составила " + maxSpendig + " рублей");
    }

    public static void task2_3(int monthDays) {
        System.out.println("\nЗадача № 2.3");

        int[] arrayMonthSpending = generateRandomArray(monthDays, 100000, 100000);
        double sumAveregePerDaySpending=0;

        for (int i : arrayMonthSpending) sumAveregePerDaySpending += i;

        String stringOutput = new DecimalFormat("#.0#").format(sumAveregePerDaySpending/monthDays);
        System.out.println("Средняя сумма трат за месяц составила " + stringOutput + " рублей.");
    }
    public static void task2_4() {
        System.out.println("\nЗадача № 2.4");

        char[] arrayOfNames = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        int index = arrayOfNames.length - 1;
        while (index >= 0) {
            System.out.print(arrayOfNames[index]);
            index--;
        }
    }

    public static void taskAddProblem1(int arrayLength, int sectionLength, int sectionDisplace, int givenSum) {
        System.out.println("\n\nДополнительная Задача №1");
/*      Необходимо найти два числа, сумма которых равна −2.
        Пишем код для дополнительной задачи */

        int[] numbersArray = generateRandomArray(arrayLength, sectionLength, sectionDisplace);
        System.out.println(Arrays.toString(numbersArray));
        System.out.println("В данном массиве ищем пару чисел, которая в сумме равна " + givenSum + " :\n");

        int leftIndex = 0;
        int rightIndex = numbersArray.length-1;

        Arrays.sort(numbersArray); // сортируем входной массив данных
        while (leftIndex < rightIndex) {
            if (numbersArray[leftIndex] +numbersArray[rightIndex] == givenSum)
            {
                System.out.print("( " + numbersArray[leftIndex] + " , " + numbersArray[rightIndex] + " )");
                return;
            }
            if (numbersArray[leftIndex] + numbersArray[rightIndex] > givenSum) rightIndex--;
            else leftIndex++;
        }
        System.out.print("\nВ данном массиве нет пар чисел с общей суммой " + givenSum + ".");

    }

    /**
     * Метод для генерации массива заданной длины и разряда значений
     *
     * @param arrayLength -- длина массива
     * @param segmentLength -- интервал генерируемых чисел
     * @param segmentDisplace -- смещение интервала на величину +rightBound
     * @return массив случайных чисел
     */
    public static int[] generateRandomArray(int arrayLength, int segmentLength, int segmentDisplace) {
        java.util.Random random = new java.util.Random();
        int[] arr   = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(segmentLength)+segmentDisplace;
        }
        return arr;
    }
}
