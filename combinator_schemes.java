import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CombinatorSchemes {
    public static void main(String[] args) {
        ArrayList<Integer> list1;
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> listK;
        int answer = -1, k = 0, l1 = 0, l2 = 0;
        String error = "Error!";
        System.out.print("Введите множество: ");
        list1 = scanList();
        l1 = list1.size();
        printListOptions();
        do {
            answer = scan(false);
            switch (answer) {
                case 1:
                    if (list2.isEmpty()) {
                        System.out.print("Введите множество: ");
                        list2 = scanList();
                        l2 = list2.size();
                    }
                    System.out.println("Sum = " + (l1 + l2));
                    break;
                case 2:
                    if (list2.isEmpty()) {
                        System.out.print("Введите множество: ");
                        list2 = scanList();
                        l2 = list2.size();
                    }
                    System.out.println("Mul = " + (l1 * l2));
                    break;
                case 3:
                    k = scan(true);
                    System.out.println("Number of placements with repetitions: " + Math.pow(l1, k));
                    break;
                case 4:
                    k = scan(true);
                    if (l1 >= k) {
                        System.out.println("Number of placements without repetitions: " + factor(l1) / factor(l1 - k));
                    } else System.out.println(error);
                    break;
                case 5:
                    k = scan(true);
                    if (l1 >= k) {
                        System.out.println("Number of combinations with repetitions: " + factor(l1 + k - 1) / factor(l1 - 1) / factor(k));
                    } else System.out.println(error);
                    break;
                case 6:
                    k = scan(true);
                    if (l1 >= k) {
                        System.out.println("Number of combinations without repetitions: " + factor(l1) / factor(l1 - k) / factor(k));
                    } else System.out.println(error);
                    break;
                case 7:
                    System.out.print("Введите список k: ");
                    listK = scanList();
                    int downK;
                    if (listK.size() == l1) {
                        k = listK.stream().mapToInt(i -> i.intValue()).sum();
                        downK = listK.stream().mapToInt(i -> factor(i.intValue())).sum();
                        System.out.println("Number of permutations with repetitions: " + factor(k) / downK);
                    } else System.out.println(error);
                    break;
                case 8:
                    System.out.println("Number of permutations without repetitions: " + factor(l1));
                    break;
                case 9:
                    printListOptions();
                    break;
                default:
                    break;
            }
        } while (answer != 0);
    }

    public static int factor(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factor(n - 1);
        }
    }

    public static void printListOptions() {
        System.out.println("Выберите опцию: ");
        System.out.println("1) Сумма\n2) Произведение\n3)Размещения с повторениями\n" +
                "4) Размещения без повторений\n5) Сочетания с повторениями\n" +
                "6) Сочетания без повторений\n7) Перестановки с повторниями\n" +
                "8) Перестановки без повторениями\n9) Вывести список опций\n0) Выход");
    }

    public static ArrayList<Integer> scanList() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int c;
        String str;
        do {
            str = scan.nextLine();
        } while (str == "");
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            try {
                list.add(Integer.parseInt(strings[i]));
            } catch (NumberFormatException e) {}
        }
        return list;
    }

    public static int scan(boolean b) {
        Scanner scan;
        int k = -1;
        if(b) System.out.println("Введите k: ");
        do {
            try {
                scan = new Scanner(System.in);
                k = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод!");
            }
        } while(k == -1);
        return k;
    }
}
