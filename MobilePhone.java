interface MobilePhoneInterface{
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
	MobilePhone(int number){
		id = number;
		phoneStatusOn = false;
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
	public Exchange location() throws MobilePhoneSwitchedOffException{
		if(status() == true){
			return baseStation;
		}
		else {
			throw new MobilePhoneSwitchedOffException("MobilePhone "+this.number()+" is switched Off");
		}
	}

	public void setBaseStation (Exchange base){
		baseStation = base;
	}

    public String toString(){
        if(phoneStatusOn == true){
            return String.valueOf(id);
        }
        else{
            return "";
        }
    }
    public boolean equals(MobilePhone o) { 
        if (o == this) { 
            return true; 
        } 

        if (!(o instanceof MobilePhone)) { 
            return false; 
        }  
        return o.number() == id; 
    }
}