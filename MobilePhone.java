interface MobilePhone{
	 MobilePhone(Integer number);
	 public Integer number();
	 public Boolean status();
	 public void switchOn();
	 public void switchOff();
	 public Exchange location();
}

public class MobilePhone{
	Integer id;
	Boolean phoneStatusOn;
	Exchange baseStation;
	MobilePhone(Integer number){
		this.id = number;
	}
	public Integer number(){
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