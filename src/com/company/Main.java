package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Cutoff Rank:");
        int cr = sc.nextInt();
        System.out.println("Enter Number of Scores:");
        int n = sc.nextInt();
        System.out.println("Enter Scores:");
        Integer[] score = new Integer[n];
        for (int i = 0; i < n; i++)
            score[i] = sc.nextInt();
        Arrays.sort(score, Collections.reverseOrder());
        Stack<Integer> st = new Stack<>();
        int i = 1, rank = 1, count = 0, same = 1;
        if(score.length!=0 && score[0]!=0){
            st.push(rank);
            while (i < n) {
                if(score[i]!=0) {
                    if (score[i].equals(score[i - 1])) {
                        st.push(rank);
                        same++;
                    }
                    else if (score[i] < score[i - 1]) {
                        st.push(rank + same);
                        rank++;
                    }
                }
                i++;
            }
            for (int p: st){
                if(p<=cr) {
                    count++;
                }
            }
            System.out.println(count);
        }
        else {
            System.out.println("No One Will Get Level Up Abilities");
        }
    }
}
