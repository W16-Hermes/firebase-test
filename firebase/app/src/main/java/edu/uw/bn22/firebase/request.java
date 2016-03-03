package edu.uw.bn22.firebase;

import java.util.Date;

/**
 * Created by bruceng on 3/3/16.
 */
public class request {
    private String title;
    private String name;
    private String restuarantName;

    public request(String t, String n, String r) {
        title = t;
        name = n;
        restuarantName = r;
    }

    public String toString() {
        return "{title: hello, name: world, restaurantName: lalala}";
    }
}
