package jp.ac.hec.cm0107.sampleroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShopInfoDao {
    @Query("SELECT * FROM shop_info")
    List<ShopInfo> getAllShop();

    @Insert
    void insertShop(ShopInfo shopInfo);
}
