/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prakpdresponsi2;

/**
 *
 * @author STEVEN
 */
public class LinkedList {

    LinkedListNode head;
    LinkedListNode tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void print() {
        LinkedListNode current = this.head;
        while (current != null) {
            System.out.println(current.data + "." + " " + current.Dokter);
            current = current.next;
        }
        System.out.println("");
    }

    LinkedListNode find_node_by_data(int data) {
        LinkedListNode current = this.head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void push(LinkedListNode new_node) {
        if (this.head == null && this.tail == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }

    LinkedListNode qpop() {
        LinkedListNode taken;
        if (this.head == null && this.tail == null) {
            taken = null;
        } else if (this.head == this.tail) {
            taken = head;
            head = null;
            tail = null;
        } else {
            taken = head;
            head = head.next;
            head.prev = null;
            tail.prev = null;
        }
        return taken;
    }
}
