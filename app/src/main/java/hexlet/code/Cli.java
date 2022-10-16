package hexlet.code;


import hexlet.code.utils.HelloUtils;

import java.util.Scanner;


public class Cli {
    /**
     * ask username.
     */
    public static void haveName() {
        HelloUtils.hello();
        Scanner sc = new Scanner(System.in);
        String scName = sc.next();
        System.out.println("Hello, " + scName + "!");
    }
}
