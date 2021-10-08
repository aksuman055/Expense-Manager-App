package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CscanDiskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initial Data
        System.out.print("Enter total no. of tracks: ");
        int n = scanner.nextInt();
        System.out.print("Enter total no. of requests: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i< size; i++){
            System.out.print("Enter request no. " + (i+1 )+": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter head position: ");
        int head = scanner.nextInt();

        Arrays.sort(arr);

        int total = 0;
        int index = -1;
        for(int i = 0; i< size  ;i++){
            if(head <= arr[i]){
                index = i;
                break;
            }
        }

        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Seek sequence is: ");


        System.out.print(head);
        int k = index;
        do{
            if(k >= size){
                k = k % size;
                total += n-1 - head;
                System.out.print(" --> " + (n-1));
                total += (n-1);
                System.out.print(" --> " + 0);
                head = 0;
            }
            total += Math.abs(arr[k]- head);
            head =arr[k];
            System.out.print(" --> " + arr[k]);

            k++;
        }while (k != index);
        System.out.println();
        System.out.println("\nTotal operations = " +  total);
        System.out.println("Average seek time = " + (total * 1.0f/size *1.0f));


    }
}
