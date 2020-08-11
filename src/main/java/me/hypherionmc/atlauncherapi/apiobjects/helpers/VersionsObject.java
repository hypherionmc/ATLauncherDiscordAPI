package me.hypherionmc.atlauncherapi.apiobjects.helpers;

public class VersionsObject {

    private final String version;
    private final String minecraft;
    private final Integer published;
    private final String ___LINK;


    private VersionsObject(String version, String minecraft, Integer published, String link) {
        this.version = version;
        this.minecraft = minecraft;
        this.published = published;
        ___LINK = link;
    }

    public String getVersion() {
        return version;
    }

    public String getMinecraft() {
        return minecraft;
    }

    public Integer getPublished() {
        return published;
    }

}
