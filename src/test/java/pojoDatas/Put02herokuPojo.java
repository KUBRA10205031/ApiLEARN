package pojoDatas;

public class Put02herokuPojo {
 /*
            "bookingdates" : {
        "checkin" : "2022-01-01",
                "checkout" : "2023-01-01"
    }

  */

    private String checkin;
    private String checkout;

    public Put02herokuPojo() {
    }

    public Put02herokuPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Put02herokuPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
