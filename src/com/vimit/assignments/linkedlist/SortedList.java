package com.vimit.assignments.linkedlist;

public class SortedList<T extends Comparable<? super T>> {
	
	//Fields
	Node<T> head;
	int size;

	
	//Constructor
	public SortedList() {
		clear();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		this.head = null;
		this.size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(T data) {
		Node current = this.head;
		Node newNode = new Node(data);
		Node previous = null;
		while(current != null && ((T)current.data).compareTo(data)<0){
			previous = current;
			current = current.next;
		}
		if(current == head){
			newNode.next = head;
			this.head = newNode;
		} else if(current == null){
			previous.next = newNode;
		} else {
			previous.next = newNode;
			newNode.next = current;
		}
		size++;
	}
	
	public T removeAt(int index) {
		if(this.size == 0 ) throw  new EmptyCollectionException();
		if(index>=this.size || index<0) throw new ArrayIndexOutOfBoundsException();
		int i=0;
		Node current = this.head;
		Node previous = null;
		while(i<index){
			previous = current;
			current = current.next;
			i++;
		}
		if(current == this.head){
			this.head = current.next;
		} else {
			previous.next = current.next;
		}
        size--;
		return (T) current.data;
	}
	
	public T get(int index) {
		if(this.size == 0 ) throw  new EmptyCollectionException();
		if(index>=this.size || index<0) throw new ArrayIndexOutOfBoundsException();
		int i=0;
		Node current = this.head;
		while(i<index){
			current = current.next;
			i++;
		}
		return (T) current.data;
	}
	
	public boolean contains(T data) {
		Node current = this.head;
		while(current != null){
			if(current.data.equals(data)){
				return true;
			}else{
				current = current.next;
			}
		}
		return false;
	}
	
	public int find(T data) {
		int index = 0;
		Node current = this.head;
		while(current != null){
			if(current.data.equals(data)){
				return index;
			}else{
				current = current.next;
				index++;
			}
		}
		return -1;
	}
	
	public int count(T data) {
		int count =0;
		Node current = this.head;
		while(current != null){
			if(current.data.equals(data)){
				count++;
			}
			current = current.next;
		}
		return count;
	}
	
	public void removeAll(SortedList<T> otherList) {
		Node currentReal = this.head;
		Node previousReal = null;
		Node currentTraverse = otherList.head;
		while(currentReal != null && currentTraverse != null){
			if(currentReal.data.equals(currentTraverse.data)){
				removeNode(currentReal, previousReal);
				currentReal = currentReal.next;
				this.size--;
			} else if(((T)currentReal.data).compareTo((T)currentTraverse.data) < 0) {
				previousReal = currentReal;
				currentReal = currentReal.next;
			}else {
				currentTraverse = currentTraverse.next;
			}
		}
		
	}

	public void reverse() {
       Node previousNode = null;
	   Node currentNode = head;
	   while(currentNode != null){
		   Node nextNode = currentNode.next;
		   currentNode.next = previousNode;
		   previousNode = currentNode;
		   currentNode = nextNode;
	   }
	   this.head = previousNode;
	}

	private void removeNode(Node currentNode, Node prevNode){
		if(currentNode == this.head){
			this.head = currentNode.next;
		} else{
			prevNode.next = currentNode.next;
		}
	}

	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		if(!isEmpty()) {
			Node<T> temp = head;
			for(int i = 0; i < size - 1; i++) {
				sb.append(temp.data.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.data.toString());
		}
		sb.append(")");
		return sb.toString();
	}
	
	//Your node class.  You may move it to a different file but
	//you will need to change this to public class Node
	private class Node<T> {
		T data;
		Node<T> next;
		public Node(T data) {
			this.data = data;
		}
	}
}
