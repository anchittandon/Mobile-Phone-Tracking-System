public class MyLinkedList {
	
	/*
		Implements Linked List with Node class
	 	- remove() removes the first element
	 	- add() inserts from the front of the linked list
	*/

	class Node {
		Object data;
		Node next;
		Node(Object d){
			this.data = d;
			this.next = null;
		}
		public Object getData(){
			return data;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node n){
			next = n;
		}
	}

	Node head;
	int size;

	public MyLinkedList(){
		head = null;
		size = 0;
	}

	public int getSize(){
		return size;
	}

	public Boolean isEmpty(){
		return size==0;
	}

	public void add(Object data){
	// Add the element at the head of the Linked List
		Node nextNode = new Node(data);
		nextNode.setNext(head);
		head = nextNode;
		size+=1;
	}

	public Object remove(){
	// Removes the element at the head of the Linked List
		if(this.isEmpty()){
			return null;
		}
		Object returnNode = head.getData();
		head = head.getNext();
		size--;
		return returnNode;
	}

	public String toString(){

        String linkedListString= "";
        String dataString = "";
        Node itr = head;

        while(itr != null){

            dataString = itr.data.toString();

            if(!dataString.equals("")){
                linkedListString = dataString+", "+linkedListString;
            }

            itr = itr.next;

        }

        if(linkedListString.equals("")){
            return linkedListString;
        }

        else{
            return linkedListString.substring(0,linkedListString.length()-2);
        }
    
    }

}