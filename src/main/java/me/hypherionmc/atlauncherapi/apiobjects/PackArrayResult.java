package me.hypherionmc.atlauncherapi.apiobjects;

import me.hypherionmc.atlauncherapi.apiobjects.helpers.PackObject;

import java.util.List;

/***
 * List of modpack info
 */
public class PackArrayResult {

    private final boolean error;
    private final int code;
    private final String message;
    private final List<PackObject> data;

    private PackArrayResult(boolean error, int code, String message, List<PackObject> data) {
        this.error = error;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /***
     * Get the error code returned by the API in the case of failure
     * @return
     */
    public int getCode() {
        return code;
    }

    /***
     * Check if the API call encountered an error
     * @return
     */
    public boolean isError() {
        return error;
    }

    /***
     * Returns a PackObject containing the modpack info
     * @return
     */
    public List<PackObject> getData() {
        return data;
    }

    /***
     * Get the error message returned by the api. (NULL when no error)
     * @return
     */
    public String getMessage() {
        return message;
    }
}
