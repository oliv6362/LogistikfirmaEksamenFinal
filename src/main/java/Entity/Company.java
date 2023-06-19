package Entity;

public class Company {

    int companyID;
    String companyName;

    public Company() {
    }

    public Company(int companyID) {
        this.companyID = companyID;
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company(int companyID, String companyName) {
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public int getCompanyID() {
        return companyID;
    }
    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
