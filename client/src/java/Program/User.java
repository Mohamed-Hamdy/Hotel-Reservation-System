package Program;

public abstract class User {

    protected int userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
    protected String city;
    protected String postalCode;
    protected String country;

    protected String password;

    protected String phone;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    public boolean verifyPassword(String pass) {
        boolean success = false;
        if (pass.equals(password)) {
            success = true;
        }
        return success;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public boolean setNewPassword(String password, String newPassword) {
        boolean success = false;

        if (password.equals(password)) {
            setPassword(newPassword);
        }

        return success;
    }

    public String getPassword() {

        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = (phone);
    }

    
    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
