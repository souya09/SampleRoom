package jp.ac.hec.cm0107.sampleroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shop_info")
public class ShopInfo {
    @PrimaryKey(autoGenerate = true)
    public int _id;


    public String name;
    public double latitude;
    public double longitude;

    // @param name;


    public ShopInfo(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
