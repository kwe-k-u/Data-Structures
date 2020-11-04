package com.duala;

import java.util.Objects;

public class SinglyLinkedList {
    private Node head = new Node();
    private int size = 0;

    /**
     * Returns the number of nodes in the singly linked list.
     * @return int
     */
    public int getSize() {

        return size;
    }

    /**
     * Adds a new Node to the top of the singly linked list with value {data} and returns the node
     * @param data
     * @return newNode
     */
    public Node addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        this.size++;

        return newNode;
    }

    /**
     * Adds a new node with value and returns node
     * @param data data to be included
     * @return newNode
     */
    public Node addLast(int data){
        Node last = last();
        Node newNode = new Node(data);
        last.setNext( newNode);
        this.size ++;
        return newNode;
    }


    /**
     * Checks if the singly linked list contains at least one node. If it does true is returned, else false.
     * @return boolean
     */
    boolean isEmpty(){
        return head.next == null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList that = (SinglyLinkedList) o;
        return size == that.size &&
                Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    /**
     * Removes the first node from the singly linked list. Returns the removed node, if the list is empty, returns null;
     * @return
     */
    Node removeFirst(){
        Node current = head.next;
        if (current != null) {
            head.next = current.next;
            this.size--;
        }
        return current;
    }


    Node remove(int data){
        Node current = first();
        Node previous = this.head;

        while (current != null){
            current = previous.next;
            if (current.getData() != data) {
                previous = current;
                current = current.next;

                continue; //if the current node does not contain the data, skip the loop
            }

            //if a node with that value is found
            previous.setNext( current.next);
            size--;
        }

        return null;
    }

    /**
     * Returns the node that contains a value equal to data. if none exists, returns null
     * @param data
     * @return Node
     */
    Node find(int data){
        Node current = first();
        while (current != null){
            current = current.next;
            if (current == null && current.getData() != data)
                continue; //if the current node does not contain the data, skip the loop
            break;
        }

        return current;
    }


    /**
     * Returns the first node of the Singly Linked List without removal. If none exists, returns null.
     * @return
     */
    Node first(){
        return head.next;
    }

    /**
     * Returns the last node in the singly linked list
     * @return node
     */
    Node last(){
        Node last = head;
        while (last.next != null)
            last = last.next;

        return last;
    }







    static  class Node{
        private int data;
        private Node next;

        Node(){

        }


        Node (int data){
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }



}
