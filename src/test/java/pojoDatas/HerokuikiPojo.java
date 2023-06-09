package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerokuikiPojo {

  /*  {
        "bookingid": 3844,
            "booking": {
        "firstname": "Drake",
                "lastname": "F.",
                "totalprice": 4000,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2022-09-05",
                    "checkout": "2023-06-01"
        },
        "additionalneeds": "Full Stack Test Automation Course with API and Appium"
    }
    }

   */
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private HerokuilkPojo bookingdates;
    private String additionalneeds;

  public HerokuikiPojo() {
  }

  public HerokuikiPojo(String firstname, String lastname, int totalprice, boolean depositpaid, HerokuilkPojo bookingdates, String additionalneeds) {
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

  public HerokuilkPojo getBookingdates() {
    return bookingdates;
  }

  public void setBookingdates(HerokuilkPojo bookingdates) {
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
    return "HerokuikiPojo{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", totalprice=" + totalprice +
            ", depositpaid=" + depositpaid +
            ", bookingdates=" + bookingdates +
            ", additionalneeds='" + additionalneeds + '\'' +
            '}';
  }
}
