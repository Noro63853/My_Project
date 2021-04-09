package helper;

public class UserObject {
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String city;
    private String address1;
    private String address2;
    private String province;
    private String zipCode;
    private String phoneNumber;

    public UserObject(String email, String userName, String firstName, String lastName, String password, String city, String address1, String address2, String province, String zipCode, String phoneNumber){
        this.setEmail(email);
        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(password);
        this.setCity(city);
        this.setAddress1(address1);
        this.setAddress2(address2);
        this.setProvince(province);
        this.setZipCode(zipCode);
        this.setPhoneNumber(phoneNumber);
    }

    public UserObject(String userName, String password){
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getEmail (){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getAddress1(){
        return address1;
    }
    public void setAddress1(String address1){
        this.address1 = address1;
    }
    public String getAddress2(){
        return address2;
    }
    public void setAddress2(String address2){
        this.address2 = address2;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getZipCode(){
        return zipCode;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


}
