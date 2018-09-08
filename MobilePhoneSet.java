public class MobilePhoneSet extends Myset{
	public MobilePhoneSet(){
		super();
    }
     public MobilePhone searchPhone(int id){
        MyLinkedList.Node itr = myset.head;
        MobilePhone temp = null;
        if(itr!=null){
        	temp = (MobilePhone) itr.data;
        }	
        while(itr!=null && (temp.number() != id)){
            itr = itr.next;
            if(itr!=null){
        		temp = (MobilePhone)itr.data;
        	}
        }
        if(itr == null){
            return null;
        }
        return temp;
    }
     
}