import java.time.LocalDate;
public class Customer {
    private String Fname;
    private String Lname;
    private final LocalDate DoB;
    private String  email;
    private String  phone;

    public Customer(String Fname,String Lname,LocalDate DoB,String email, String phone){
        this.Fname=Fname;
        this.Lname=Lname;
        this.DoB=DoB;
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

    public LocalDate getDoB() {
        return DoB;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

// add setters
    public void setFname(String fname) {
        Fname = fname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public LocalDate setDoB() {
        return DoB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
