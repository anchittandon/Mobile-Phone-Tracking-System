public class MyLinkedList {
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

	MyLinkedList(){
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
		Node nextNode = new Node(data);
		nextNode.setNext(head);
		head = nextNode;
		size+=1;
	}

	public Object remove(){
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
            if(dataString.equals("") == false){
                linkedListString = dataString+", "+linkedListString;
            }
            itr = itr.next;
        }
        if(linkedListString.equals("") == true){
            return linkedListString;
        }
        else{
            return linkedListString.substring(0,linkedListString.length()-2);
        }
    }
}