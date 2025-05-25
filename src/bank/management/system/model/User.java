package bank.management.system.model;

public class User {
    private String formId;
    private String name;
    private String account;
    private String dob;
    private String gender;
    private String email;
    private String maritalStatus;
    private String address;
    private String city;
    private String province;
    private String password;

    // Constructor
    public User(String formId, String name, String account, String dob, String gender, 
                String email, String maritalStatus, String address, String city, 
                String province, String password) {
        this.formId = formId;
        this.name = name;
        this.account = account;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.city = city;
        this.province = province;
        this.password = password;
    }

    // Getters and Setters
    public String getFormId() { return formId; }
    public void setFormId(String formId) { this.formId = formId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
} 