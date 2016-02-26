package Heap;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Pratik on 2/21/2016.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeap max = new MaxHeap(25);
        MinHeap min = new MinHeap(25);
        for(int i=0; i<25; i++){
            max.insert(i);
            min.insert(i);
        }

        max.print();
        System.out.println("-------------------------------------------------------------------------");
        min.print();
    }
}
