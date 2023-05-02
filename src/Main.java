// import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        taskAddProblem1();
    }

//    public static void task1() {
//        System.out.println("\nЗадача №1");
//      Пишем код для задачи 1
//    }

    public static int[] generateRandomArray(int arrayLength, int numberDigits) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((int) Math.pow(10,numberDigits) + (int) Math.pow(10^numberDigits,numberDigits));
        }
        return arr;
    }

    public static void taskAddProblem1() {
        System.out.println("\nДополнительная Задача №1");
//      Пишем код для задачи 1
        int[] nums = generateRandomArray(5, 5);
        int target = 5;
        target += nums[2];
        System.out.println(target);
        System.out.println(nums[0]);
        System.out.println(nums.length);
    }
}
