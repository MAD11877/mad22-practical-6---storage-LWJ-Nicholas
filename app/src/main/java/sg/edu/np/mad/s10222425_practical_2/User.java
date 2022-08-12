package sg.edu.np.mad.s10222425_practical_2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String description;
    int id;
    boolean followed;

    public User(String n, String desc, int num, boolean follow){
        name = n;
        description = desc;
        id = num;
        followed = follow;
    }

}