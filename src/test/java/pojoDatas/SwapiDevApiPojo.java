package pojoDatas;

import java.util.List;

public class SwapiDevApiPojo {

  /*  {
        "name": "Star Destroyer",
            "model": "Imperial I-class Star Destroyer",
            "manufacturer": "Kuat Drive Yards",
            "cost_in_credits": "150000000",
            "length": "1,600",
            "max_atmosphering_speed": "975",
            "crew": "47,060",
            "passengers": "n/a",
            "cargo_capacity": "36000000",
            "consumables": "2 years",
            "hyperdrive_rating": "2.0",
            "MGLT": "60",
            "starship_class": "Star Destroyer",
            "pilots": [],
        "films": [
        "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/"
    ],
        "created": "2014-12-10T15:08:19.848000Z",
            "edited": "2014-12-20T21:23:49.870000Z",
            "url": "https://swapi.dev/api/starships/3/"
    }
     */


    private String name;
    private String model;
    private String manufacturer;
    private int cost_in_credits;
    private double length;
    private int max_atmosphering_speed;
    private double crew;
    private String passengers;
    private int cargo_capacity;
    private String consumables;
    private double hyperdrive_rating;
    private int MGLT;
    private String starship_class;
    private String created;
    private String edited;
    private String url;



    public SwapiDevApiPojo(String star_destroyer, String s, String kuat_drive_yards, int i, double v, int i1, double v1, String s1, int i2, String s2, double v2, int i3, String star_destroyer1, String s3, String s4, String s5) {
    }
}