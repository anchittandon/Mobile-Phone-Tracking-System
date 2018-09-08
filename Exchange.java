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
		return children.getSize();
	}

	public Exchange child(int i){
		int num = numChildren();
		if(i<num && i>=0){
			ExchangeList.Node itr = children.head;
			for(int j=num-1;j>i;j--){
				itr = itr.next;
			}
			return (Exchange)itr.data;
		}
		else{
			return null;
		}
	}

	public MobilePhone searchPhone(int i){
		return mobileSet.searchPhone(i);
	}

	public Boolean isRoot(){
		if(parent() == null){
			return true;
		}
		return false;
	}

	public RoutingMapTree subtree(int i){
		Exchange subtreeAti = child(i);
		RoutingMapTree rmt = new RoutingMapTree();
		if(subtreeAti != null){
			rmt.setRoot(subtreeAti);
		}
		return rmt;
	}

	public MobilePhoneSet residentSet(){
        return mobileSet;
    }
}