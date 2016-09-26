import java.util.Collection;

/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: lab2
 * Filename : DoublyLinkedList.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 


public class DoublyLinkedList<T> {
	
	// Creating and defining a nested Node class
	private class Node<T>{
		
		// Private fields for Node class
		private T element;		
		private Node<T> next;		
		private Node<T> prev;		
		
		// default constructor - setting element to null
		public Node(){
			element = null;
		}
		
		// constructor setting element to value of parameter t
		public Node(T t){
			element = t;
		}
		
		
		// Accessor methods:
		public Node<T> getNext(){
			return next;
		}
		public Node<T> getPrev(){
			return prev;
		}
		public T getElement(){
			return element;
		}
		
		// Modifier methods:
		public void setNext(Node<T> n){
			next = n;
		}
		public void setPrev(Node<T> n){
			prev = n;
		}
		
	}
	
	
	// private fields for DoublyLinkedList class
	private int num_nodes;		// number of nodes (size of the list)
	private Node<T> head;			// first node in the list		
	private Node<T> tail;			// last node in the list
	
	// default constructor - setting head, tail to null and num_nodes to 0
	public DoublyLinkedList(){
		head = null;
		tail = null;
		num_nodes = 0;		
	}
	
	// constructor taking a value in the parameter c
	public DoublyLinkedList(Collection<? extends T> c){
		head = null;
		tail = null;
		num_nodes = 0;
	}
	
	// Add Method - adding an element at a specific given index
	public void add(int index, T t){
		
		// Instantiating a new Node
		Node<T> newNode = new Node<T>(t);
		
		// if List is empty, add newNode as first element
		if(isEmpty()){
			newNode.setNext(null);
			newNode.setPrev(null);
			head = newNode;
			tail = newNode;
		}
		else{
			
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> current = head;		// starting at head node
					
			// if user wants to add in the beginning of list
			if(index == 0){
				
				// adding the new node in the beginning of the list
				current.setPrev(newNode);
				newNode.setPrev(null);
				newNode.setNext(current);
				head = newNode;
			}
			
			// if user wants to add at the end of list
			else if((index+1) > num_nodes){
				
				// traverse across the list
				for(int i = 0; i < (index-1); i++){
					current = current.getNext();
				}
				
				// adding the new node at the end of list
				current.setNext(newNode);
				newNode.setPrev(current);
				newNode.setNext(null);
				tail = newNode;
			}
			
			// otherwise put the new node somewhere in between any two existing nodes that user wants
			else{
				
				// traverse across the list
				for(int i = 0; i < index; i++){
					current = current.getNext();
				}
				
				// adding new node between two existing nodes
				current.getPrev().setNext(newNode);
				current.setPrev(newNode);
				current.getPrev().setNext(newNode);
				newNode.setPrev(current.getPrev());
				newNode.setNext(current);
			}
		}
		
		// incrementing number of nodes (size of list)
		num_nodes++;
	
	}
	
	// Remove method - given an index
	public T remove(int index){
		
		// if user inputs an index that is out of bound, return null
		if((index < 0) || (index > size()-1)){
			return null;
		}

		// case where index is 0, first element in list
		else if(index == 0){
			
			// if there is only one element left
			if(size() == 1){
				head = null;
				tail = null;
				
				// decrement number of nodes (size of list)
				num_nodes--;
				
				return null;	
			}
			else{
			
				// Instantiating a 'current' node to use to traverse across the list
				Node<T> current = head;
				
				// putting element to be removed in temp otherwise will lose it
				T temp = (T)current.getElement();
				head = current.getNext();
				
				// putting to null to de-access the node to let garbage collector take it
				current.getNext().setPrev(null);
				current.setNext(null);
				
				// decrement number of nodes (size of list)
				num_nodes--;
				
				// return the value removed
				return temp;
			}
		}
		
		// case where user wants to remove node at the end of the list
		else if (index+2 > num_nodes){
			
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> current = head;
			
			// traverse across the list
			for(int i = 0; i < (index-1); i++){
				current = current.getNext();
			}
			
			// putting element to be removed in temp otherwise will lose it
			T temp = (T)current.getNext().getElement();
			tail = current;
			
			// putting to null to de-access the node to let garbage collector take it
			current.getNext().setPrev(null);
			current.setNext(null);
			
			// decrement number of nodes (size of list)
			num_nodes--;
			
			// return the value removed
			return temp;	
		}
		
		// case removing anywhere between two existing nodes
		else{
			
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> current = head;
						
			// traverse across the list
			for(int i = 0; i < (index-1); i++){
				current = current.getNext();
			}
			
			// putting element to be removed in temp otherwise will lose it 
			T temp = (T)current.getNext().getElement();
			
			// creating a tempNode
			Node<T> tempNode = new Node<T>();
			tempNode.setNext(current.getNext().getNext());
		
			// putting to null to de-access the node to let garbage collector take it
			current.getNext().setNext(null);
			current.getNext().setPrev(null);
			
			// connecting the two nodes where the removed nodes were between together
			current.setNext(tempNode.getNext());
			current.getNext().setPrev(current);
			
			// decrement number of nodes (side of list)
			num_nodes--;
			
			// return the value removed
			return temp;
		}
		
	}
	
	// Remove method - given an object
	public T remove(Object o){
		
		// boolean if element exist or not
		boolean isElement = false;
		
		// Instantiating a 'current' node to use to traverse across the list
		Node<T> current = head;
		
		//local index to find the index of the object
		int lcindex = 0;
		
		// going through the list to find object
		while(lcindex<size()){

			// if finds object, break the loop and set isElement true
			if (o.equals(current.getElement())){
				isElement = true;
				break;	
			}
			
			current = current.getNext();
			lcindex++;
		}
		
		// if object found, use method remove(index) to remove object
		if(isElement){
			T temp = remove(lcindex);
			return temp;
		}
		
		// if can't find object return null
		else{
			return null;
		}
	}
	
	// Get method - given index
	public T get(int index){
		
		// check if index is out of bound
		if((index < 0) || (index > size()-1)){
			return null;
		}
	
		// else find the element
		else{
			
			// Instantiating a 'current' node to use to traverse across the list
			Node<T> current = head;
			
			for(int i = 0; i < index; i++){
				current = current.getNext();
			}
			
			// getting the current element and return it
			T temp = (T)current.getElement();
			return temp;
		}
	
	}
	
	// Size method - returns the size of list (numer of nodes)
	public int size(){
		return num_nodes;
	}
	
	// isEmpty method - checking if list is empty
	public boolean isEmpty(){
		if (num_nodes == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	// displayList method - will go through the entire list and print out the element
	public void displayList(){
		Node<T> current = head;
		while(current != null){
			System.out.println(current.element);
			current = current.getNext();
		}
	}

}
