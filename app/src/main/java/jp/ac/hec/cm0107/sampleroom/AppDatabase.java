package jp.ac.hec.cm0107.sampleroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {ShopInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShopInfoDao shopInfoDao();

}
