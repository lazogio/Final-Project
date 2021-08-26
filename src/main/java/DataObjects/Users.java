package DataObjects;
public class Users {
    private String
            firstName="Giorgi",
            lastName="Lazareshvili",
            phone="571069198",
            password="Giorgi123",
            address="Tadashi",
            state="Georgia",
            city="Tbilisi",
            email;
    private String  country="Georgia";
    private int zip=2312;

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setPassword(String password) {this.password = password;}
    public void setAddress(String address) {this.address = address;}
    public void setState(String state) {this.state = state;}
    public void setCity(String city) {this.city = city;}
    public void setZip(int zip) {this.zip = zip;}
    public void setEmail(String email){
        this.email = email;
    }
    public void setCountry(String country){this.country = country;}

    public String getFirstName(){return this.firstName;}
    public String getLastName(){
        return this.lastName;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getPassword(){
        return this.password;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
    public String getState(){
        return this.state;
    }
    public String getCity(){return this.city;}
    public int getZip(){
        return this.zip;
    }
    public String getCountry(){return this.country;}
}
