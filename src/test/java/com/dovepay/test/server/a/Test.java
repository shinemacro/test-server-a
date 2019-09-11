 package com.dovepay.test.server.a;

import java.util.Scanner;

/**
 * @author zhaoyh
 * @date 2019/03/22
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("please input a number:");
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String input = s.nextLine();
            System.out.println(input);
            if("exit".equals(input)) {
                s.close();
                break;
            }
        }
    }
}
