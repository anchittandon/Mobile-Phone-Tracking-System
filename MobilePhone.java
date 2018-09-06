interface MobilePhone{
	 MobilePhone(Int number);
	 public Int number();
	 public Boolean status();
	 public void switchOn();
	 public void switchOff();
	 public Exchange location();
}

public class MobilePhone{
	Int id;
	Boolean phoneStatusOn;
	Exchange baseStation;
	MobilePhone(Int number){
		this.id = number;
	}
	public Int number(){
		return id;
	}
	public Boolean status(){
		return phoneStatusOn;
	}
	public void switchOn(){
		if(phoneStatusOn == false){
			phoneStatusOn = true;
		}
	}
	public void switchOff(){
		if(phoneStatusOn == true){
			phoneStatusOn = false;
		}
	}
	public Exchange location() throws Exception{
		if(status() == true){
			return baseStation;
		}
		else {
			throw new Exception();
		}
	}
    public String toString(){
        if(phoneStatus){
            return phoneStatus.toString();
        }
        else{
            return "";
        }
    }
}