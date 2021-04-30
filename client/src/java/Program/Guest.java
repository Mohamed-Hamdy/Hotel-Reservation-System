package Program;

public class Guest extends User{

	public Guest() {}
	
	public Guest (String uname, String pass) {
		super();
		this.email=uname;
		this.password=pass;
	}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", streetName='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", Country='" + country + '\'' +
                '}';
    }
}
