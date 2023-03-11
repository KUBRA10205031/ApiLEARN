package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerokuGenelPojo {
 /*   {
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
    private int bookingid;
    private HerokuikiPojo booking;
    private HerokuilkPojo bookingdates;
    private String additionalneeds;

    public HerokuGenelPojo() {
    }

    public HerokuGenelPojo(int bookingid, HerokuikiPojo booking, HerokuilkPojo bookingdates, String additionalneeds) {
        this.bookingid = bookingid;
        this.booking = booking;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public HerokuikiPojo getBooking() {
        return booking;
    }

    public void setBooking(HerokuikiPojo booking) {
        this.booking = booking;
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
        return "HerokuGenelPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
