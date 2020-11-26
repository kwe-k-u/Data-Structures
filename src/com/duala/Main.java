package com.duala;

public class Main {

    public static void main(String[] args) {

        /**
         * Creating lists with elements of the for;;
         *      2,3,4,85,5,12,19
         *
         * Removing elements 3,12, 5
         *
         * adding new elements 1,56,39
         *
         * finding elements that don't exists
         *
         * removing elements that don't exist
         *
         * Finding first and last elements
         *
         * removing all elements
         *
         * finding first and last elements
         *
         */

        //Testing SinglyLinkedList

        SinglyLinkedList singleList = new <Integer>SinglyLinkedList();

        //Creating a full list
        singleList.addFirst(2);
        singleList.addFirst(3);
        singleList.addFirst(4);
        singleList.addFirst(85);
        singleList.addFirst(5);
        singleList.addFirst(12);
        singleList.addFirst(19);

        //Getting the size of the list
        System.out.println(singleList.getSize());

        //Removing elements 3, 12, 5
        singleList.remove(3);
        singleList.remove(12);
        singleList.remove(5);

        //Getting the size of the list
        System.out.println(singleList.getSize());

        //adding elements
        singleList.addFirst(1);
        singleList.addFirst(56);
        singleList.addLast(39);

        //finding a nonexistent element
        singleList.find(100);

        //removing nonexistent element
        singleList.remove(100);

        //finding first and last element
        singleList.first();
        singleList.last();

        //removing all elements
        for (int i = 0; i <= singleList.getSize(); i++)
            singleList.removeFirst();


        //Getting the size of the list
        System.out.println(singleList.getSize());

        //finding first and last element
        singleList.first();
        singleList.last();


        //Getting the size of the list
        System.out.println(singleList.getSize());









        //Testing circularlyLinkedList
        CircularlyLinkedList circleList = new <Integer>CircularlyLinkedList();

        //Creating a full list
        circleList.addFirst(2);
        circleList.addFirst(3);
        circleList.addFirst(4);
        circleList.addFirst(85);
        circleList.addFirst(5);
        circleList.addFirst(12);
        circleList.addFirst(19);

        //Getting the size of the list
        System.out.println(circleList.getSize());

        //Removing elements 3, 12, 5
        circleList.remove(3);
        circleList.remove(12);
        circleList.remove(5);

        //Getting the size of the list
        System.out.println(circleList.getSize());

        //adding elements
        circleList.addFirst(1);
        circleList.addFirst(56);
        circleList.addLast(39);

        //finding a nonexistent element
        circleList.find(100);

        //removing nonexistent element
        circleList.remove(100);

        //finding first and last element
        circleList.first();
        circleList.last();

        //removing all elements
        for (int i = 0; i <= circleList.getSize(); i++)
            circleList.removeFirst();


        //Getting the size of the list
        System.out.println(circleList.getSize());

        //finding first and last element
        circleList.first();
        circleList.last();


        //Getting the size of the list
        System.out.println(circleList.getSize());

    }
}
