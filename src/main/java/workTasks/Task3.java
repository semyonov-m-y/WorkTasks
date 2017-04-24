package workTasks;

//2
public class Task3 {

    public static void main(String[] args) {
        String str = "1234567890";
        System.out.println("First: " + str.charAt(0));
        System.out.println("Last: " + str.charAt(str.length() - 1));

        for (int i = 0; i < str.toCharArray().length; i++) {
            if (i % 2 == 0) {
                System.out.print("Odd: " + i + " ");
            }
        }

        System.out.println();

        System.out.println("Reverse: " + new StringBuilder(str).reverse().toString());
    }
}
