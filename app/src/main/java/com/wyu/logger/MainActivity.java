package com.wyu.logger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.library.logger.AndroidLogAdapter;
import com.library.logger.Logger;
import com.library.logger.PrettyFormatStrategy;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(2)
                .build()));
//        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public void printMsg(View view) {
        Logger.d("hello world！ This is a text msg.");
    }

    public void printJson(View view) {
        String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
                "\"temp\":\"-2\",\"WD\":\"西北风\",\"WS\":\"3级\",\"SD\":\"241%\",\"WSE\":\"3\"," +
                "\"time\":\"10:61\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"}}";
        Logger.json(JSON_CONTENT);
    }

    public void printXml(View view) {
        String XML_CONTENT = "<resp><city>北京</city><updatetime>16:10</updatetime><wendu>23</wendu>" +
                "<fengli>3级</fengli><shidu>19%</shidu><fengxiang>北风</fengxiang></resp>";
        Logger.xml(XML_CONTENT);
    }

    public void printList(View view) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        Logger.d(list);
    }

}