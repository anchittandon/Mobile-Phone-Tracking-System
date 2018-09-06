interface Exchange{
	Exchange(Integer number);
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

	Exchange(Integer number){
		id = number;
		children = new ExchangeList();
		mobileSet = new MobilePhoneSet();
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

	public void addChild(MobilePhone mobile){
		mobile.setParent(this);
		children.add(mobile);
	}

	public Exchange numChildren(){
		return children.getSize();
	}

	public Exchange child(int i){
		if(i<numChildren() && i>=0){
			ExchangeList.Node itr = children.head;
			for(int j=0;j<i;j++){
				itr = itr.next;
			}
			return itr;
		}
		else{
			return null;
		}
	}

	public Boolean isRoot(){
		if(parent == null){
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