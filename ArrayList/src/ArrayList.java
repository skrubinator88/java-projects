/*
 * Title: ArrayList
 * Author: Oseriemen Ivbaze
 * Date: 2/16/18
 * 
 * Purpose: This is a copy of the ArrayList Class, meant to accomplish the same functions
 * 
 * Solution: This class will function just like an ArrayList from the java ArrayList Class 
 * 
 * Data Structures: Classes, arrays
 * 
 * User Guide: 
 * 
 * 	 User must first declare new ArrayList object
 * 	 Arraylist accepts objects of any kinds, but must be an object
 * 	 Methods to use:
 * 		-add(): 
 * 			type 1: accepts an Object and adds to end of list
 * 			type 2: accepts an index value and Object and adds to index location in list
 * 		-get():
 * 			accepts an index and retrieves object at index location
 * 		-size():
 * 			returns the current amount of non null values in list
 * 		-isEmpty():
 * 			checks whether list has any non null values and returns a boolean
 * 		-isIn():
 * 			accepts an Object and checks if it is in list, returns a boolean
 * 		-find():
 * 			accepts an Object and returns the current index location in list
 * 		-remove():
 * 			accepts an object and removes the first occurence of it
 * 		-toString():
 * 			returns an organized string version of list
 * 	
 * */

//purpose of this class is to provide the methods necessary to create an ArrayList structure
public class ArrayList {
	
	Object[] list;
	
	//default constructor creates a new list with size 10
	public ArrayList() {
		this.list = new Object[10];
	}
	
	//accepts an integer value and sets it to list size
	public ArrayList(int x) {
		this.list = new Object[x];
	}
	
	//accepts an Object array
	private Object[] increase(Object[] currentList) {
		
		Object[] newList = new Object[(currentList.length)*2];
		for(int i = 0; i < currentList.length; i++) {
			newList[i] = currentList[i];
		}
		//returns a new array with doubled size
		return newList;
	
	}
	
	//accepts a value and places at the end of the list
	public void add(Object object) {
		
		list[list.length-1] = object;
	
	}
	
	//accepts an index of integer value within the boundaries of list size
	public Object get(int index) {
		
		Object getValue = list[index];
		//returns Object at provided index value from list
		return getValue;
	}
	
	//checks to see if ArrayList is currently empty
	public boolean isEmpty() {
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				//will return false if no objects are found
				return false;
			}
		}
		//returns true if objects are found
		return true;
	}
	
	//accepts an object and checks if it is currently in ArrayList
	public boolean isIn(Object obj) {
		
			for(int i = 0; i < list.length; i++) {
				if(list[i] != null) {
					if(list[i].equals(obj)) {
						return true;
					}
				}
			}
		
		return false;
	}
	
	//accepts an Object 
	public int find(Object n) {
		//searches list to see if object is present
		if(n != null) {
			for(int i = 0; i < list.length; i++) {
				if(list[i] != null) {
					if(list[i].equals(n))
						//returns object if found
						return i;
				}
			};
		}
		//if no value is found, will automatically return 0
		return 0;
		
	}
	
	//accepts an Object
	public void remove(Object x) {
		//checks list to see if Object is present
		
		if(isIn(x)) {
			//finds the index of Object
			int index = find(x);
			Object[] newList = list.clone();
			for(int i = index; i < list.length; i++) {
				newList[i] = null;
				newList[i] = list[i++];
			};
			this.list = newList;
			return;
		}
		
	}
	
	public int size() {
		int amount = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				amount++;
			}
		}
		//returns an integer value of the amount of items not null in list
		return amount;
	}
	
	//accepts an index of int value and an Object
	public void add(int index, Object x) {
		//assigns a copy of the current list to a temp list
		Object[] newList = list.clone();  
		for(int i = 0; i < list.length; i++) {
			//checks if at end of loop and there is still an object to be moved
			if((i == newList.length-1 && index == i) && newList[index] != null) {
				//keeps increasing temp list until index is no longer out of array bounds
				while(index >= newList.length-1) {
					newList = increase(newList);
				}
					//assigns input Object to index location of temp list
					newList[index] = x;
					//shifts all objects after index location to the right
					newList[index+(i-index)+1] = list[index+(i-index)];
			}
			//checks to see if index is just greater than the current list length
			else if((index >= list.length || index+i+1 >= list.length) && i == list.length-1) {
				//increases temp list to size that can fit index location
				while(index >= newList.length) {
					newList = increase(newList);
				}
				//assigns input object to index location
				newList[index] = x;
			}
			//checks to see if index is within current list length and it has not been filled
			else if(index < list.length-1 && newList[index] == null) {
				//only assigns value if location is completely empty
				if(newList[index] == null && list[index] == null) {
					newList[index] = x;
				}
			}
			//checks to see if index value has passed
			else if((i - index) >= 0){
				//shifts values after index to the right
				newList[index+(i-index)+1] = list[index+(i-index)];
			}
			//inserts index 
//			else {
//				newList[index] = x;
//			}
			}
		//assigns temp list to current list
		list = newList;
		return;
		
	}	
	
	//returns a concatenated string array
	public String toString() {
		
		String string = "";
		for(int i = 0; i < list.length; i++) {
			string += list[i]+ ", ";
		}
		return "[" + string + "]";
	}
	
	
	
}
