package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Main {


    public static void main(final String[] args) {
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(2);
        myCollection.add(3);
        myCollection.add(4);
        myCollection.add(null);
        myCollection.add(6);
        myCollection.add(7);
//
//
//
//        // <T> T[] toArray(T[] a)
//        /*Integer[] arr = {5, 4, 6, 8, 9, 10, 11, 12};
//        Object[] newArr = myCollection.toArray(arr);
//        for (int i = 0; i < newArr.length; i++) {
//            System.out.print(newArr[i] + " ");
//        }
//        System.out.println();
//
//        //Object[] toArray()
//        for (int i = 0; i < myCollection.toArray().length; i++) {
//            System.out.print(myCollection.toArray()[i] + " ");
//        }
//        System.out.println();*/
//
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2131);
        l.add(212312);
        l.add(3123213);
        /*l.add(4);
        l.add(3);
        l.add(2);*/
//
        Iterator<Integer> iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
//
//        myCollection.clear();
        System.out.println(myCollection.retainAll(l));
//
        iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
