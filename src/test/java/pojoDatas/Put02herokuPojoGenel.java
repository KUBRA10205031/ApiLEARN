package pojoDatas;

public class Put02herokuPojoGenel {

 /*   {
        "firstname" : "Drake",
            "lastname" : "F..",
            "totalprice" : 4000,
            "depositpaid" : true,
            "bookingdates" : {
        "checkin" : "2022-01-01",
                "checkout" : "2023-01-01"
    },
        "additionalneeds" : "API and Appium"
    }

  */

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Put02herokuPojo bookingdates;
    private String additionalneeds;

    public Put02herokuPojoGenel() {
    }

    public Put02herokuPojoGenel(String firstname, String lastname, int totalprice, boolean depositpaid, Put02herokuPojo bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Put02herokuPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Put02herokuPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "Put02herokuPojoGenel{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
