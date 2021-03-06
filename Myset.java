interface MysetInterface{
	public Boolean IsEmpty();
	public Boolean IsMember(Object o);
	public void Insert(Object o);
	public void Delete(Object o) throws Exception;
	public Myset Union(Myset a);
	public Myset Intersection(Myset a);
}


public class Myset implements MysetInterface{

	/*
		Implementation of Set data structure using linked list data structure.
	 */

	MyLinkedList myset;

	public Myset(){
		myset = new MyLinkedList ();
	}

	public Boolean IsEmpty(){
	// Returns true if the set is empty
		return myset.isEmpty();
	}

	public Boolean IsMember(Object o){
	
	// Returns true if o is in the set, false otherwise.
	
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

	// Inserts o into the set

		if(!IsMember(o)){
			myset.add(o);
		}

	}

	public void Delete(Object o) throws NotInSetException{

	// Deletes o from the set, throws exception if o is not in the set.

		if(IsMember(o)){

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
	// Returns a set which is the union of the current set with the set a.
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
	//Returns a set which is the intersection of the current set with the set a.

		Myset answer = new Myset();
		MyLinkedList.Node itr = myset.head;

		while( itr != null){

			if(a.IsMember(itr.getData())){
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