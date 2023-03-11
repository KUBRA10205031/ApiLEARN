package pojoDatas;

public class ZippoPotamPojos {


     /*  {
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
     */

   // Step 1 private variable create et.

    private String postCode;
    private String country;
    private String countryabbreviation;
    private ZippoPotamPlaces zippoPotamPlaces;

    //step 2 : Create a without parameter constructor


    public ZippoPotamPojos() {
    }
   // Step 3 : Create a with
    public ZippoPotamPojos(String postCode, String country, String countryabbreviation, ZippoPotamPlaces zippoPotamPlaces) {
        this.postCode = postCode;
        this.country = country;
        this.countryabbreviation = countryabbreviation;
        this.zippoPotamPlaces = zippoPotamPlaces;
    }

    //step 4 :

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryabbreviation() {
        return countryabbreviation;
    }

    public ZippoPotamPlaces getZippoPotamPlaces() {
        return zippoPotamPlaces;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryabbreviation(String countryabbreviation) {this.countryabbreviation = countryabbreviation;
    }

    public void setZippoPotamPlaces(ZippoPotamPlaces zippoPotamPlaces) {
        this.zippoPotamPlaces = zippoPotamPlaces;
    }


    //Step 5: toString()


    @Override
    public String toString() {
        return "ZippoPotamPojos{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryabbreviation + '\'' +
                ", zippoPotamPlaces=" + zippoPotamPlaces +
                '}';
    }
}


