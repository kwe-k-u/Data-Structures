package com.duala;

import java.util.Objects;

public class DoublyLinkedList<E> {
    private Node head = new Node();
    private Node tail = new Node();
    private int size = 0;

    public DoublyLinkedList(){
        this.head.next = tail;
        this.tail.previous = head;
    }



    /**
     * Returns the number of nodes in the doubly linked list.
     * @return E
     */
    public int getSize() {

        return size;
    }


    /**
     * Adds a node to the top of the list
     * @param data element to be contained in the first node of the list
     * @return Node if addition was successful
     */
    public Node addFirst(E data){
        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
        node.previous = head;
        node.next.previous = node;

        size++;
        return node;
    }


    /**
     * Removes and returns the node at the head of the list
     * @return Element at the first index of the list, null if the list is empty
     */
    public Node removeFirst(){

        //Return null if the list is empyt
        if (isEmpty())
            return  null;
        Node first = this.head.next;

        //Connecting head to second element
        this.head.next = this.head.next.next;  //second element
        this.head.next.previous = this.head;

        //disconnecting first element's links
        first = null;
        first = null;
        size--;

        return first;
    }


    /**
     * Removes and returns the node at the end of the list
     * @return Element at the end of the list, null if the list is empty
     */
    public Node removelast(){

        //If the list is empty return null
        if(isEmpty())
            return null;

        Node last = this.tail.previous;

        //Connecting head to second element
        this.tail.previous = this.tail.previous.previous;  //second element
        this.tail.previous.next = this.tail;

        //disconnecting first element's links
        last.next = null;
        last.previous = null;
        size--;

        return last;
    }


    /**
     * Adds an Node to the end of the list
     * @param data element to be added to be list
     * @return node containing the element if the addition was successful
     */
    public Node addLast(E data){
        Node last = new Node<E>(this.tail.previous,data, this.tail); //Connecting new node to list

        //positioning node between tail and former last node
        this.tail.previous.next = last;
        this.tail.previous = last;

        size++;
        return last;
    }


    /**
     * Inserts an element at the specified index
     * @param data Data to be inserted
     * @param index Index at which data should be inserted
     * @return Node containing data if insertion was successful
     */
    public Node insertAt(E data, int index){
        //TODO throw exception for negative indexes

        Node node = new Node<E>(data);
        Node before = this.head; //Node to appear before the new node
        Node after; //Node to appear after new node


        for (int i = 0; i < index-1; i++)
            before = before.next;
        after = before.next;

        before.next = node;
        node.previous = before;

        after.previous = node;
        node.next = after;

        return node;
    }


    /**Finds and returns the first one that contains the specified data
     * @param data Data to be found in node
     * @return Node containing specified data; null if none exists
     */
    public Node find(E data){
     Node node = null;

     //if list is
     if (isEmpty())
         return node;

     Node current = this.head.next;

        for (int index = 0; index < getSize(); index++) {
            if (current.data == data)
                break;
            current = current.next;

        }



     return  node;
    }


    /**
     * Removes the first occurring node that contains the specified data
     * @param data Data to be removed from the list
     * @return Removed node that contained the entered data. null if none exists
     */
    public Node remove(E data){
        Node<E> node = find(data);

        if (node == null)
            return null;

        node.next.previous = node.previous;
        node.previous.next = node.next;
        node.previous = null;
        node.next = null;


        return node;
    }


    /**
     * Returns a boolean to show if the list is empty
     * @return true if list is empty. false if list is not empty
     */
    public boolean isEmpty(){
        return 0 == getSize();
    }














    static  class Node<E>{
        private E data;
        private Node next;
        private Node previous;

        Node(){

        }


        Node (E data){
            this.data = data;
        }

        Node(Node previous, E data, Node next){
            this.previous = previous;
            this.data = data;
            this.next = next;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(next, node.next) &&
                    Objects.equals(previous, node.previous);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }
}
