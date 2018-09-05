interface MysetInterface{
	public Boolean IsEmpty();
	public Boolean IsMember(Object o);
	public void Insert(Object o);
	public void Delete(Object o);
	public Myset Union(Myset a);
	public Myset Intersection(Myset a);
}

class MyLinkedList {
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
                linkedListString = linkedListString+" "+dataString;
            }
            itr = itr.next;
        }
        if(linkedListString.equals("") == true){
            return linkedListString;
        }
        else{
            return linkedListString.substring(1);
        }
    }
}

public class Myset implements MysetInterface{

	MyLinkedList myset;

	Myset(){
		myset = new MyLinkedList ();
	}
	public Boolean IsEmpty(){
		return myset.isEmpty();
	}
	public Boolean IsMember(Object o){
		MyLinkedList.Node itr= myset.head;
		while(itr!=null){
			//System.out.println(itr.getData());
			if(itr.getData() == o){
				return true;
			}
			itr = itr.getNext();
		}
		return false;
	}
	public void Insert(Object o){
		if(IsMember(o) == false){
			myset.add(o);
		}
	}
	public void Delete(Object o){
		try{
			if(IsMember(o) == true){
				if(myset.head!=null && myset.head.getData() == o){
					myset.remove();
				}
				else{
					MyLinkedList.Node prev = myset.head;
					MyLinkedList.Node itr = myset.head.getNext();

					while(itr!=null){
						if(itr.getData() == o){
							prev.next = itr.next;
						}
						prev = itr;
						itr = itr.getNext();
					}				
				}
			}
			else{
				throw new Exception();
			}
		}
		catch(Exception e){
			System.out.println("The element "+o+" was not found in the set");
		}
	}
	public Myset Union(Myset a){
		Myset answer = new Myset();
		MyLinkedList.Node itr = myset.head;
		while(itr!=null){
			answer.Insert(itr.getData());
			itr= itr.getNext();
		}
		itr = a.myset.head;
		while(itr!=null){
			answer.Insert(itr.getData());
			itr = itr.getNext();
		}
		return answer;
	}
	public Myset Intersection(Myset a){
		Myset answer = new Myset();
		MyLinkedList.Node itr = myset.head;
		while( itr != null){
			if(a.IsMember(itr.getData()) == true){
				answer.Insert(itr.getData());
			}
			itr = itr.getNext();
		}
		return answer;
	}
	public String toString()
    {
        return myset.toString();
    }	
}	