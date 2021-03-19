package com.sumit;

public class Solution {
	
	static Node head;
	
	static class Node{
		int data ;
		Node next;
		Node(int d){
			data = d;
		}
	}
	
	static void printLinkedList(Node head) 
	{	
		while(head !=null) 
		{
			System.out.println(head.data + " ");
			head = head.next;
		}
	}
	
	static Node rotateLinkedList(Node head, int k) 
	{
		if(head.next==null) 
		{
			return head;
		}
		
		//for first node
		int length = 1;
		
		//point tail to head
		Node tail = head;
		
		
		while(tail.next!=null) 
		{
			tail = tail.next;
			
			//length till last node
			length++;
		}
		
		//if k is greater than length of list
		k = k%length;
		
		if(k==0) 
		{
			return head;
		}
		
		//steps to rotate
		int stepsToMove = length - k;
		
		tail.next=head;
		Node newTail = tail;
		
		while(stepsToMove-- > 0) 
		{
			newTail = newTail.next;
		}
		
		Node newHead = newTail.next;
	    newTail.next=null;	
	    return newHead;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.head = new Node(1);
		s.head.next = new Node(2);
		s.head.next.next = new Node(3);
		s.head.next.next.next = new Node(4);
		s.head.next.next.next.next = new Node(5);
		
		Node rotateLinkedListHead = s.rotateLinkedList(head, 2);
		
		s.printLinkedList(rotateLinkedListHead); // 4 -> 5 -> 1-> 2-> 3
	}
}
