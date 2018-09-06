interface RoutingMapTree{
	public Boolean containsNode(Exchange node);
	public void switchOn(MobilePhone mobile, Exchange node);
	public void switchOff(MobilePhone mobile);
	public void performAction(String actionMessage);
}



public class RoutingMapTree{
	Exchange root;
	RoutingMapTree(){
		root = new Exchange(0);
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
    public void switchOn(MobilePhone mobile, Exchange node)



}
