package me.hypherionmc.atlauncherapi.apiobjects.helpers;

public class PackVersionObject {

    private final String version;
    private final String minecraftVersion;
    private final boolean recommended;
    private final int published;
    private final String serverZipUrl;
    private final String changelog;


    private PackVersionObject(String version, String minecraftVersion, boolean recommended, int published, String serverZipUrl, String changelog) {
        this.version = version;
        this.minecraftVersion = minecraftVersion;
        this.recommended = recommended;
        this.published = published;
        this.serverZipUrl = serverZipUrl;
        this.changelog = changelog;
    }

    public String getVersion() {
        return version;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public int getPublished() {
        return published;
    }

    public String getChangelog() {
        return changelog;
    }

    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    public String getServerZipUrl() {
        return serverZipUrl;
    }
}
