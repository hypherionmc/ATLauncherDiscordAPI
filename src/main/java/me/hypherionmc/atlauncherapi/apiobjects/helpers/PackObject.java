package me.hypherionmc.atlauncherapi.apiobjects.helpers;

import java.util.List;

/***
 * An object return from the API containing all the info about a modpack
 */
public class PackObject {

    private final int id;
    private final String name;
    private final String safeName;
    private final String type;
    private final List<VersionsObject> versions;
    private final String description;
    private final String supportURL;
    private final String websiteURL;


    private PackObject(int id, String name, String safeName, String type, List<VersionsObject> versions, String description, String supportURL, String websiteURL) {
        this.id = id;
        this.name = name;
        this.safeName = safeName;
        this.type = type;
        this.versions = versions;
        this.description = description;
        this.supportURL = supportURL;
        this.websiteURL = websiteURL;
    }

    /***
     * Gets the ID of the modpack
     * @return - INT
     */
    public int getPackId() {
        return id;
    }

    /***
     * Gets the Website URL of the modpack
     * @return
     */
    public String getWebsiteURL() {
        return websiteURL;
    }

    /***
     * Gets the pack type
     * @return (public, private, semipublic)
     */
    public String getType() {
        return type;
    }

    /***
     * Get the support URL for the modpack
     * @return
     */
    public String getSupportURL() {
        return supportURL;
    }

    /***
     * Gets the Safename of the Modpack (used in the URLs)
     * @return
     */
    public String getSafeName() {
        return safeName;
    }

    /***
     * Gets the description of the Modpack
     * @return
     */
    public String getDescription() {
        return description;
    }

    /***
     * Gets the Display name of the Modpack
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * Gets a list of all the published versions of the modpack
     * @return
     */
    public List<VersionsObject> getVersions() {
        return versions;
    }

    /***
     * Get the ATLauncher Info Page URL for the modpack
     * @return
     */
    public String getLink() {
        return "https://atlauncher.com/pack/" + getSafeName();
    }
}
