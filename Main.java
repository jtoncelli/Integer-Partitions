import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void printSum(ArrayList<Integer> list){
        System.out.print(list.get(0));
        for(int i = 1; i < list.size(); i++){
            System.out.print(" + " + list.get(i));
        }
        System.out.println();
    }
    public static int sumList(ArrayList<Integer> list){
        int n = 0;
        for (int i = 0; i < list.size(); i++){
            n += list.get(i);
        }
        return n;
    }
    public static void printPartitions(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        displayPartitions(n, list);
        list.remove(list.size() - 1);
        for(int i = 2; i < n; i++){
            list.add(i);
            displayPartitions(n, list);
            list.remove(list.size() - 1);
        }
        System.out.println(n);
    }

    public static void displayPartitions(int n, ArrayList<Integer> list) {
        if (sumList(list) == n){
            printSum(list);
        }
        if (sumList(list) < n){
            if(list.isEmpty()){
                for (int i = 1; i <= n - sumList(list); i++){
                    list.set(list.size() - 1, i);
                    displayPartitions(n, list);
                }
            }
            else{
                for (int i = list.get(list.size() - 1); i <= n - sumList(list); i++){
                    list.add(i);
                    displayPartitions(n, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a positive integer:");
        String input = scan.nextLine();
        try{
            int a = Integer.parseInt(input);
            if (a > 0){
                printPartitions(a);
            }
            else{
                System.out.println("Invalid input");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Invalid input");
        }
    }
}
