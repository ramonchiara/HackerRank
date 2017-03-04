package br.pro.ramon.hackerrank.challenges.grading;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int grade = in.nextInt();

            if (grade >= 38) {
                int factor = grade / 5;
                int nextGrade = 5 * (factor + 1);

                if (nextGrade - grade < 3) {
                    grade = nextGrade;
                }
            }
            
            System.out.println(grade);
        }
    }
}
