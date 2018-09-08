interface RoutingMapTree{
	public Boolean containsNode(Exchange node);
	public void switchOn(MobilePhone mobile, Exchange node);
	public void switchOff(MobilePhone mobile);
	public void performAction(String actionMessage);
	public void setRoot(int i);
}



public class RoutingMapTree{
	Exchange root;
	RoutingMapTree(){
		root = new Exchange(0);
	}
	public void setRoot(int i){
		root.setUniqueId(i);
	}

	public Boolean containsNode(Exchange node){
		if(root = node){
			return true;
		}
		int n = root.numChildren();
		RoutingMapTree subT = root.subtree(i+1);
		for(int i=0;i<n;i++){
			if(subT.containsNode(node) == true){
				return true;
			}
		}
		return false;
	}
    public void switchOn(MobilePhone mobile, Exchange node){
    	if(mobile.status() == false){
    		mobile.switchOn();
    		mobile.setBase(node);
    		node.addMobileToResidentSet(mobile);
    		while(node.parent() !=null){
    			node = node.parent();
    			node.addMobileToResidentSet(mobile);
    		}
    	}
    }
    public void switchOff(MobilePhone mobile){
    	if(mobile.status() == true){
    		mobile.switchOff();
    	}
    }
    public void performAction(String actionMessage){
    	String delims = "[ ]+";
		String[] tokens = actionMessage.split(delims);
		if(tokens[0].equals("addExchange") == true){
			Exchange X = 
		}

    }



}
