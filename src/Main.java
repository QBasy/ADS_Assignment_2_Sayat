import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        MyArrayList array = new MyArrayList();
        Scanner userInput = new Scanner(System.in);
        String a;
        switch (userInput.nextInt())
        {
            case 1:
                getArray();
                a = "Array";
                System.out.println("What do you want to with your" + a);
            case 2:
                getLinkedList();
                a = "LinkedList";
                System.out.println("What do you want to with your" + a);
        }
        int x;
        switch (userInput.nextInt())
        {
            case 1:
                System.out.println("How many elements?");
                x = userInput.nextInt();
                for (int i = 0; i < x; i++) {
                    array.add(userInput.nextInt());
                }
                for (int j = 0; j < x; j++)
                {
                    System.out.print(array.get(j));
                    System.out.print(" ");
                }
            case 2:
                System.out.println("");
        }
    }
    public static void getArray()
    {
        Scanner scanner = new Scanner(System.in);
        MyArrayList<Integer> array = new MyArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++)
        {
            array.add(scanner.nextInt());
            if (i == (n-1))
            {
                System.out.println(array.size());
                for (int j = 0; j < n; j++)
                {
                    System.out.print(array.get(j));
                    System.out.print(" ");
                }
            }
        }
    }
    public static void getLinkedList()
    {
    }
}
