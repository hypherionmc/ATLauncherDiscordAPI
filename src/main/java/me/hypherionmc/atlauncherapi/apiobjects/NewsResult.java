package me.hypherionmc.atlauncherapi.apiobjects;

import java.util.ArrayList;
import java.util.Date;

public class NewsResult {

    public boolean error;
    public int code;
    public Object message;
    public ArrayList<Data> data;

    public NewsResult(boolean error, int code, Object message, ArrayList<Data> data) {
        this.error = error;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public boolean isError() {
        return error;
    }

    public int getCode() {
        return code;
    }

    public Object getMessage() {
        return message;
    }

    public static class Data {
        public String title;
        public String content;
        public Date created_at;
    }
}
