package me.hypherionmc.atlauncherapi.apiobjects;

import me.hypherionmc.atlauncherapi.apiobjects.helpers.PackObject;

public class PackResult {

    private final boolean error;
    private final int code;
    private final String message;
    private final PackObject data;

    private PackResult(boolean error, int code, String message, PackObject data) {
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

    public PackObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
