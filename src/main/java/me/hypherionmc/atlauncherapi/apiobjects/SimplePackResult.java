package me.hypherionmc.atlauncherapi.apiobjects;

import me.hypherionmc.atlauncherapi.apiobjects.helpers.SimplePackObject;

import java.util.List;

public class SimplePackResult {

    private final boolean error;
    private final int code;
    private final String message;
    private final List<SimplePackObject> data;

    private SimplePackResult(boolean error, int code, String message, List<SimplePackObject> data) {
        this.error = error;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public boolean isError() {
        return error;
    }

    public List<SimplePackObject> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}
