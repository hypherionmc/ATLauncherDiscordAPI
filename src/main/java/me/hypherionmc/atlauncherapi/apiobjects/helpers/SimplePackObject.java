package me.hypherionmc.atlauncherapi.apiobjects.helpers;

public class SimplePackObject {

    private final int id;
    private final String name;
    private final String safeName;
    private final String type;
    private final String ___LINK;

    private SimplePackObject(int id, String name, String safeName, String type, String link) {
        this.id = id;
        this.name = name;
        this.safeName = safeName;
        this.type = type;
        ___LINK = link;
    }

    public String getName() {
        return name;
    }

    public String getSafeName() {
        return safeName;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getLink() {
        return "https://atlauncher.com/pack/" + getSafeName();
    }
}
