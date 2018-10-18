interface MobilePhoneInterface{
	 public Integer number();
	 public Boolean status();
	 public void switchOn();
	 public void switchOff();
	 public Exchange location();
}

public class MobilePhone{
	
	/*
		A class for representing mobile phones. 
	*/

	Integer id;
	Boolean phoneStatusOn;
	Exchange baseStation;

	public MobilePhone(int number){
	/*
		Constructor to create a mobile phone. 
		Unique identifier for a mobile phone is an integer.
	*/
		id = number;
		phoneStatusOn = false;
	}
	
	public Integer number(){
	// Returns the id of the mobile phone
		return id;
	}
	
	public Boolean status(){
	// Returns the status of the phone, i.e. switched on or switched of
		return phoneStatusOn;
	}
	
	public void switchOn(){
	// Changes the status to switched on
		if(!phoneStatusOn){
			phoneStatusOn = true;
		}
	}
	
	public void switchOff(){
	// Changes the status to switched of
		if(phoneStatusOn){
			phoneStatusOn = false;
		}
	}
	
	public Exchange location() throws MobilePhoneSwitchedOffException{
	/*
		Returns the base station with which
		the phone is registered if the phone is 
		switched on and an exception if the phone is off.
	*/
		if(status()){
			return baseStation;
		}

		else {
			String err = "Error - Mobile phone with identifier "+this.number()+" is currently switched off";
			throw new MobilePhoneSwitchedOffException(err);
		}

	}

	public void setBaseStation (Exchange base){
	// Set Base Station for current exchange
		baseStation = base;
	}

    public String toString(){
	/*
    	Returns the number of Mobile Phone
    	In the form of a string
	*/
        if(phoneStatusOn){
            return String.valueOf(id);
        }
        else{
            return "";
        }
    }

    public boolean equals(MobilePhone o) { 
    /*
    	Two mobile phones are the same 
    	if their numbers are the same
    */
   
        if (o == this) { 
            return true; 
        } 

        if (!(o instanceof MobilePhone)) { 
            return false; 
        }  

        return o.number() == id; 
    }

}