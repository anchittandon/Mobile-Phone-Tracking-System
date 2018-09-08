interface RoutingMapTreeInterface{
	public Boolean containsNode(Exchange node);
	public void switchOn(MobilePhone mobile, Exchange node);
	public void switchOff(MobilePhone mobile);
	public String performAction(String actionMessage);
	public void setRoot(int i);
}

public class RoutingMapTree{
	Exchange root;
	RoutingMapTree(){
		root = new Exchange(0);
	}
	public void setRoot(Exchange node){
		root = node;
	}

	public Boolean containsNode(Exchange node){
		if(root == node){
			return true;
		}
		int n = root.numChildren();
		RoutingMapTree subT;
		for(int i=0;i<n;i++){
			subT = root.subtree(i+1);
			if(subT.containsNode(node) == true){
				return true;
			}
		}
		return false;
	}
    public void switchOn(MobilePhone mobile, Exchange node){
    	if(mobile.status() == false){
    		mobile.switchOn();
    		mobile.setBaseStation(node);
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

    public Exchange findExchange(int i){
    	int n = root.numChildren();
    	if(root.getUniqueId() == i){
    		return root;
    	}
    	for(int itr = 0;itr<n;itr++){
    		Exchange probableExchange = root.subtree(itr).findExchange(i);
    		if(probableExchange != null){
    			return probableExchange;
    		}
    	}
    	return null;
    }

    public String performAction(String actionMessage){
    	String delims = "[ ]+";
		String[] tokens = actionMessage.split(delims);
		String answer = "";
		try{
			//System.out.print(tokens[0]);
			if(tokens[0].equals("addExchange") == true){
				Exchange X = findExchange(Integer.parseInt(tokens[1]));  // Convert tokens[i] to integer
				Exchange Y = new Exchange(Integer.parseInt(tokens[2])); // Convert tokens[i] to integer
				X.addChild(Y);
			}
			else if(tokens[0].equals("switchOnMobile") == true){
				int a = Integer.parseInt(tokens[1]);
				int b =Integer.parseInt(tokens[2]);
				Exchange containerExchange = findExchange(b);
				if(containerExchange == null){
					return ("Error- No Exchange with identifier "+b);
				}
				else{
					MobilePhone mobile = root.searchPhone(a);
		            if(mobile == null){
		                mobile = new MobilePhone(a);
		            }
		            else{
				        Exchange base = mobile.location();
				        while(base != null)
				        {
				            base.deleteMobilefromResidentSet(mobile);
				            base = base.parent();
				        }
		            }
		            switchOn(mobile,containerExchange);
		        }
			}
			else if(tokens[0].equals("switchOffMobile") == true){
				int a = Integer.parseInt(tokens[1]);
				MobilePhone mobile = root.searchPhone(a);
				if(mobile == null){
					return ("Error- No mobile phone with identifer "+a);	
				}	
		        switchOff(mobile);
			}
			else if(tokens[0].equals("queryNthChild") == true){
				int a = Integer.parseInt(tokens[1]);
		        Exchange targetExchange = findExchange(a);
		        int b = Integer.parseInt(tokens[2]);
		        if(b >= targetExchange.numChildren() || b<0){
		            return ("Error - No "+ b +" child of Exchange "+a);
		        }
		        answer += actionMessage+": "+Integer.toString(targetExchange.child(b).getUniqueId());
			}
			else if(tokens[0].equals("queryMobilePhoneSet") == true){
				int a = Integer.parseInt(tokens[1]);
		        Exchange targetExchange = findExchange(a);
		        String requiredSet = targetExchange.residentSet().toString();
		        answer += actionMessage+": "+ requiredSet;		
			}			
		}
		catch(Exception e){

		}
	return answer;
    }	
}
