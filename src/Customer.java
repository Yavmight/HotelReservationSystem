public class Customer {
    private String Fname;
    private String Lname;
    private int age;
    private String  email;
    private int phone;

    public Customer(String Fname,String Lname,int age,String email, int phone){
        this.Fname=Fname;
        this.Lname=Fname;
        this.age=age;
        this.email=email;
        this.phone=phone;
    }
 //add getters


    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

// add setters
    public void setFname(String fname) {
        Fname = fname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
