package com.rbmhz.dagger2.pojo;

import java.util.ArrayList;

public class Resp {

    ArrayList<data> data;

    public ArrayList<data> getData() {
        return data;
    }

    public  class data{
        String userId;
        String id;
        String title;

        public String getUserId() {
            return userId;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }
    }

}
