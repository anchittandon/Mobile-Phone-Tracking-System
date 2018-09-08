interface MysetInterface{
	public Boolean IsEmpty();
	public Boolean IsMember(Object o);
	public void Insert(Object o);
	public void Delete(Object o) throws Exception;
	public Myset Union(Myset a);
	public Myset Intersection(Myset a);
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
			if(itr.getData().equals(o)){
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
	public void Delete(Object o) throws Exception{
		if(IsMember(o) == true){
			if(myset.head!=null && myset.head.getData() == o){
				myset.remove();
			}
			else{
				MyLinkedList.Node prev = myset.head;
				MyLinkedList.Node itr = myset.head.getNext();

				while(itr!=null){
					if(itr.getData().equals(o)){
						prev.next = itr.next;
					}
					prev = itr;
					itr = itr.getNext();
				}				
			}
		}
		else{
			throw new NotInSetException(o+" is not in the set.");
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
	public String toString(){
        return myset.toString();
    }
}	