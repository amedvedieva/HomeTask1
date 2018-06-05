import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static jdk.nashorn.internal.objects.NativeDate.parse;

public class ArrayMadness {


        public static void main(String[] args) {

            // task 1
            int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

            // task 2
            int a1 = a[0];
            int a2 = a[9];

            a[0] = a2;
            a[9] = a1;

            String m = Arrays.toString(a);
            System.out.println(m);

            // task 3
            OptionalDouble avg = Arrays.stream(a).average();
            System.out.println(avg);

            //task 4
            int[] p = new int[13];
            Random random = ThreadLocalRandom.current();

            int c0 = 0, c1 = 0, c2 = 0;
            for (int i = 0; i < 13; i++) {
                //  0, 1, 2
                p[i] = random.nextInt(3) - 1;
                switch (p[i]) {
                    case -1:
                        c0++;
                        break;
                    case 0:
                        c1++;
                        break;
                    case 1:
                        c2++;
                        break;
                }
            }
            System.out.println(Arrays.toString(p));
            if (c0 >= c1 && c0 >= c2) {
                System.out.println("Count: " + c0 + " value " + -1);
            } else if (c1 >= c0 && c1 >= c2) {
                System.out.println("Count: " + c1 + " value " + 0);
            } else {
                System.out.println("Count: " + c2 + " value " + 1);
            }

            // task 5
            ArrayList<String> list = new ArrayList<>();
            System.out.println("Enter five strings: ");
            Scanner s = new Scanner(System.in);
            int i = 4, minLength;
            if (s.hasNext()) {
                String next = s.nextLine();
                minLength = next.length();
                list.add(next);
                while (i > 0 && s.hasNext()) {
                    next = s.nextLine();
                    minLength = Math.min(next.length(), minLength);
                    list.add(next);
                    i--;
                }
                System.out.println(Arrays.toString(list.toArray()));
                System.out.println("Min length: " + minLength + " strings: ");
                for (String str : list) {
                    if (str.length() == minLength) {
                        System.out.println(str);
                    }
                }
            }

            // task 6
            Scanner s1 = new Scanner(System.in);
            ArrayList<Integer> numbers = new ArrayList<>();
            System.out.println("\nPlease enter numbers: ");
            while (numbers.size() <= 3 && s1.hasNext()) {
                parse(s1.nextLine(), numbers);
                if(numbers.size() <= 3) {
                    System.out.println("enter more numbers: ");
                }
            }
            System.out.println("Unique numbers: " + Arrays.toString(new HashSet<>(numbers).toArray()));
        }
}
