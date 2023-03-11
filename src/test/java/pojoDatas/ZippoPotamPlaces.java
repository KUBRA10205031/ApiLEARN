package pojoDatas;

public class ZippoPotamPlaces {


/*     {
        "post code": "34010",
            "country": "Turkey",
            "country abbreviation": "TR",
            "places": [
        {
            "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
        }
    ]
    }
}
*/

/*
*
* POJO CLASS : PLAİN OLD JAVA OBJECT
* Expected Data veya ACTUAL Data ları depolamak için yani tutmak için kullanıyoruz.
* pojo nasıl oluşturulur?
* 1-Field'lar --> var         PRİVATE  ---> her bir json için
* 2-Getter and Setter
* 3-Parametresiz Constructor
* 4-Parametreli Constructor
* 5-toString()
*
 */

private String placeName;
private String longitude;
private String state;
private String stateAbbreviation;
private String latitude;

public ZippoPotamPlaces(){

}

    public ZippoPotamPlaces(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "{" +
                "placeName='" + placeName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }



}
