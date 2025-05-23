
//INDUSTRY: CLEANING SERVICE (CAR WASH) 
public class CarWash{
	private String custId;
	private String custName;
	private String custPhone;
	private String custEmail;
	private boolean membership; // yes or no
	private String carBrand;
	private String carModel;
	private String carLicensePlate;
	private String carCategory; // SUV // SEDAN // MPV // HATCHBACK
	private String washPackage; // deep wash // normal wash // wash&polish // interior // exterior  
	//Storer Method
	public CarWash(String custId, String custName, String custPhone, String custEmail, boolean membership, String carBrand, String carModel, String carLicensePlate, String carCategory, String washPackage){
		this.custId = custId;
		this.custName = custName;
		this.custPhone = custPhone;
		this.custEmail = custEmail;
		this.membership = membership; 
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carLicensePlate = carLicensePlate;
		this.carCategory = carCategory;
		this.washPackage = washPackage;
	}
	//Getter Method
	public String getCustId() {return custId;}
	public String getCustName() {return custName;}
	public String getCustPhone() {return custPhone;}
	public String getCustEmail() {return custEmail;}
	public boolean getMembership() {return membership;}
	public String getCarBrand() {return carBrand;}
	public String getCarModel() {return carModel;}
	public String getCarLicensePlate() {return carLicensePlate;}
	public String getCarCategory() {return carCategory;}
	public String getWashPackage() {return washPackage;}
	//Mutator Method
	public void setCustId(String custId) {this.custId = custId;}
	public void setCustName(String custName) {this.custName = custName;}
	public void setCustPhone(String custPhone) {this.custPhone = custPhone;}
	public void setCustEmail(String custEmail) {this.custEmail = custEmail;}
	public void setMembership(boolean membership) {this.membership = membership;}
	public void setCarBrand(String carBrand) {this.carBrand = carBrand;}
	public void setCarModel(String carModel) {this.carModel = carModel;}
	public void setCarLicensePlate(String carLicensePlate) {this.carLicensePlate = carLicensePlate;}
	public void setCarCategory(String carCategory) {this.carCategory = carCategory;}
	public void setWashPackage(String washPackage) {this.washPackage = washPackage;}
    
	// Method to display Customer details
    @Override
	public String toString() {
		return String.format("""
							
							[ Customer Id       : %-27s ]
							[ Customer Name     : %-27s ]
							[ Customer Phone    : %-27s ]
							[ Customer Email    : %-27s ]
							[ Membership        : %-27s ]
							[ Car Brand         : %-27s ]
							[ Car Model         : %-27s ]
							[ Car License Plate : %-27s ]
							[ Car Category      : %-27s ]
							[ Wash Package      : %-27s ]""",
			custId, custName, custPhone, custEmail, membership, carBrand, carModel, carLicensePlate, carCategory, washPackage
		);
	}

}

