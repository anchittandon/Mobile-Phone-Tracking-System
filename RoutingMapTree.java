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

	public Boolean containsNode(Exchange node) throws ChildNotFoundException{
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

    public Exchange findExchange(int i) throws ExchangeNotFoundException, ChildNotFoundException	{
    	int n = root.numChildren();
    	if(root.getUniqueId() == i){
    		return root;
    	}
    	Exchange probableExchange = null;
    	for(int itr = 0;itr<n;itr++){
    		probableExchange = root.subtree(itr).findExchange(i);
    		if(probableExchange != null){
    			break;
    		}
    	}
    	if(root.getUniqueId()==0 && probableExchange == null){
    		throw new ExchangeNotFoundException("Error- No exchange with identifier "+i);
    	}
    	return probableExchange;
    }

    public String performAction(String actionMessage){
    	String delims = "[ ]+";
		String[] tokens = actionMessage.split(delims);
		String answer = "";
		try{
			//System.out.print(tokens[0]);
			if(tokens[0].equals("addExchange") == true){
				int a = Integer.parseInt(tokens[1]);
				int b = Integer.parseInt(tokens[2]);
				Exchange X = findExchange(a); 
				Exchange Y = new Exchange(b);
				X.addChild(Y);
			}
			else if(tokens[0].equals("switchOnMobile") == true){
				int a = Integer.parseInt(tokens[1]);
				int b = Integer.parseInt(tokens[2]);
				Exchange containerExchange = findExchange(b);
/*				if(containerExchange == null){
					return ("Error- No Exchange with identifier "+i);
				}*/
				MobilePhone mobile = null;
				boolean flag = false;
				try{
					mobile = root.searchPhone(a);

					//System.out.println("Mobile phone "+a+" found with id "+mobile.number());
					/*Exchange base = mobile.location();
			        while(base != null) {
			            base.deleteMobilefromResidentSet(mobile);
			            base = base.parent();
			        }*/
				}
				catch(Exception e){
					//System.out.println(e.getMessage());
					mobile = new MobilePhone(a);
				}
				if (mobile.status() == true){
					throw new MobilePhoneAlreadyOnException("Error- Mobile phone with identifier "+a+" is already on");
				}
				//System.out.println(mobile.number());
				switchOn(mobile,containerExchange);

			}
			else if(tokens[0].equals("switchOffMobile") == true){
				int a = Integer.parseInt(tokens[1]);
				MobilePhone mobile = root.searchPhone(a);
				/*if(mobile == null){
					return ("Error- No mobile phone with identifer "+a);	
				}	*/
		        switchOff(mobile);
			}
			else if(tokens[0].equals("queryNthChild") == true){
				int a = Integer.parseInt(tokens[1]);
		        Exchange targetExchange = findExchange(a);
		        int b = Integer.parseInt(tokens[2]);
/*		        if(b >= targetExchange.numChildren() || b<0){
		            return ("Error - No "+ b +" child of Exchange "+a);
		        }*/
		        answer += actionMessage+": "+Integer.toString(targetExchange.child(b).getUniqueId());
			}
			else if(tokens[0].equals("queryMobilePhoneSet") == true){
				int a = Integer.parseInt(tokens[1]);
		        Exchange targetExchange = findExchange(a);
				//System.out.println(targetExchange.residentSet().IsEmpty());
		        String requiredSet = targetExchange.residentSet().toString();
		        answer += actionMessage+": "+ requiredSet;		
			}			
		}
		catch(Exception e){
			answer +=actionMessage+": "+e;
		}
	return answer;
    }	
}

class NotInSetException extends Exception
{
    private String message;

    public NotInSetException() {
        super();
    }

    public NotInSetException(String message) {
        super(message);
        this.message = message;
    }

    public NotInSetException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class MobilePhoneSwitchedOffException extends Exception
{
    private String message = null;

    public MobilePhoneSwitchedOffException() {
        super();
    }

    public MobilePhoneSwitchedOffException(String message) {
        super(message);
        this.message = message;
    }

    public MobilePhoneSwitchedOffException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class MobilePhoneNotFoundException extends Exception
{
    private String message = null;

    public MobilePhoneNotFoundException() {
        super();
    }

    public MobilePhoneNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public MobilePhoneNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
class ExchangeNotFoundException extends Exception
{
    private String message = null;

    public ExchangeNotFoundException() {
        super();
    }

    public ExchangeNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ExchangeNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
class ChildNotFoundException extends Exception
{
    private String message = null;

    public ChildNotFoundException() {
        super();
    }

    public ChildNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ChildNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class MobilePhoneAlreadyOnException extends Exception
{
    private String message = null;

    public MobilePhoneAlreadyOnException() {
        super();
    }

    public MobilePhoneAlreadyOnException(String message) {
        super(message);
        this.message = message;
    }

    public MobilePhoneAlreadyOnException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
