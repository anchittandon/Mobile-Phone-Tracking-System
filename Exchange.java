interface ExchangeInterface{
	public Exchange parent();
	public Exchange numChildren();
	public Exchange child(int i);
	public Boolean isRoot();
	public RoutingMapTree subtree(int i);
	public MobilePhoneSet residentSet();
}

public class Exchange{
	Integer id;
	Exchange parent;
	ExchangeList children;
	MobilePhoneSet mobileSet;

	Exchange(int number){
		//constructor to create an exchange.
		//Unique identifier for an exchange is an integer
		id = number;
		children = new ExchangeList();
		mobileSet = new MobilePhoneSet();
	}

	public Integer getUniqueId(){
		return id;
	}

	public void setUniqueId(int i){
		id = i;
	}

	public Exchange parent(){
		//Returns the parent of the Exchange in RoutingMapTree
		return parent;
	}

	public void setParent(Exchange node){
		parent = node;
	}
	public void addMobileToResidentSet(MobilePhone mobile){
		mobileSet.Insert(mobile);
	}

	public void deleteMobilefromResidentSet(MobilePhone mobile) throws Exception{
		mobileSet.Delete(mobile);
	}

	public void addChild(Exchange node){
		node.setParent(this);
		children.add(node);
	}

	public int numChildren(){
		// Number of children
		return children.getSize();
	}

	public Exchange child(int i) throws ChildNotFoundException{
		//returns the ith child
		int num = numChildren();
		if(i<num && i>=0){
			ExchangeList.Node itr = children.head;
			for(int j=num-1;j>i;j--){
				itr = itr.next;
			}
			return (Exchange)itr.data;
		}
		else{
			throw new ChildNotFoundException("Error - No "+ i +" child of Exchange "+this.getUniqueId());
		}
	}

	public MobilePhone searchPhone(int i) throws MobilePhoneNotFoundException{
		// calls MobilePhoneSet operation searchPhone()
		return mobileSet.searchPhone(i);
	}

	public Boolean isRoot(){
		if(parent() == null){
			return true;
		}
		return false;
	}

	public RoutingMapTree subtree(int i) throws ChildNotFoundException{
		//returns the ith subtree
		//Throws exception if the child i is not found
		Exchange subtreeAti = child(i);
		RoutingMapTree rmt = new RoutingMapTree();
		rmt.setRoot(subtreeAti);
		return rmt;
	}

	public MobilePhoneSet residentSet(){
		//returns the resident set of mobile phones of the exchange
        return mobileSet;
    }

    public boolean equals(Exchange o) { 
    	// Two Exchanges are the same 
    	// if their identifiers are the same
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Exchange)) { 
            return false; 
        }  
        return o.getUniqueId() == id; 
    } 
}