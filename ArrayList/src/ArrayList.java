
public class ArrayList {
	
	Object[] list;
	
	//default constructor creates a new list with size 10
	public ArrayList() {
		list = new Object[10];
	}
	
	//accepts an integer value and sets it to list size
	public ArrayList(int x) {
		list = new Object[x];
	}
	
	private Object[] increase(Object[] currentList) {
		
		Object[] newList = new Object[(currentList.length+1)*2];
		for(int i = 0; i <= currentList.length; i++) {
			newList[i] = currentList[i];
		}
		
		return newList;
	
	}
	
	//accepts a value and places at the end of the list
	public void add(Object object) {
		
		list[list.length+1] = object;
	
	}
	
	//accepts an index of integer value within the boundaries of list size
	public Object get(int index) {
		
		Object getValue = list[index];
		//returns Object at provided index value from list
		return getValue;
	}
	
	public boolean isEmpty() {
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isIn(Object obj) {
		
		for(int i = 0; i < list.length; i++) {
			if(list[i] == obj) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
