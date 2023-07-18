package jp.ac.hec.cm0107.sampleroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "recom_map.db";
    private ShopInfoDao shopInfoDao;
    private List<ShopInfo> shopInfoList;

    private TextView txt;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        txt = findViewById(R.id.txt);
        AppDatabase db = Room.databaseBuilder(this,AppDatabase.class,DB_NAME).build();
        shopInfoDao = db.shopInfoDao();
        ShopInfo shopInfo1 = new ShopInfo("ラーメン二郎",
                35.696346,
                139.698336);
        ShopInfo shopInfo2 = new ShopInfo("風来居",
                35.695339,
                139.696587);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                shopInfoList = shopInfoDao.getAllShop();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setTextView(shopInfoList);
                    }
                });
            }
        });
//
//        ShopInfoHelper helper = new ShopInfoHelper(this);
//        helper.insert(shopInfo1);
//        helper.insert(shopInfo2);
//
//        findViewById(R.id.btnLoad).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for (ShopInfo shopInfo: shopInfoList){
//                    txt.setText(txt.getText() + shopInfo.name + "\n");
//                }
//
//
//            }
//        });

    }

    private void setTextView(List<ShopInfo> shopInfoList) {
        txt.setText("");
        for (ShopInfo shopInfo : shopInfoList){
            txt.append(shopInfo.name + "\n");
        }
    }
}