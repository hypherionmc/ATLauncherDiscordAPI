package me.hypherionmc.atlauncherapi.apiobjects;

import me.hypherionmc.atlauncherapi.apiobjects.helpers.PackVersionObject;

public class PackVersionResult {

    private final boolean error;
    private final int code;
    private final String message;
    private final PackVersionObject data;

    private PackVersionResult(boolean error, int code, String message, PackVersionObject data) {
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

    public PackVersionObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}
