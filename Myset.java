interface MysetInterface{
	public Boolean IsEmpty();
	public Boolean IsMember(Object o);
	public void Insert(Object o);
	public void Delete(Object o) throws Exception;
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

	public String toString()
    {
        String str= "";
        String temp = "";
        Node itr = head;
        while(itr != null)
        {
            temp = itr.data.toString();
            if(!temp.equals(""))
            {
                str = str+" "+temp;
            }
            itr = itr.next;
        }
        if(str.equals(""))
        {
            return str;
        }
        else
        {
            return str.substring(2);
        }
    }
}

public class Myset implements MysetInterface{

	MyLinkedList myset;

	Myset(){
		this.myset = new MyLinkedList ();
	}
	public Boolean IsEmpty(){
		return this.myset.isEmpty();
	}
	public Boolean IsMember(Object o){
		MyLinkedList.Node itr= this.myset.head;
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
			this.myset.add(o);
		}
	}
	public void Delete(Object o) throws Exception{
		if(IsMember(o) == true){
			if(this.myset.head!=null && this.myset.head.getData() == o){
				this.myset.remove();
			}
			else{
				MyLinkedList.Node prev = this.myset.head;
				MyLinkedList.Node itr = this.myset.head.getNext();

				while(itr!=null){
					if(itr.getData() == o){
						prev.next = itr.next;
					}
					prev = itr;
					itr = itr.getNext();
				}				
			}
		}
		else
        {
            throw new Exception();
        }
	}
	public Myset Union(Myset a){
		Myset answer = new Myset();
		MyLinkedList.Node itr = this.myset.head;
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
		MyLinkedList.Node itr = this.myset.head;
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
        return this.myset.toString();
    }
}