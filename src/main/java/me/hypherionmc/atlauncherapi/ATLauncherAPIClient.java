package me.hypherionmc.atlauncherapi;

import com.google.gson.Gson;
import me.hypherionmc.atlauncherapi.apiobjects.PackArrayResult;
import me.hypherionmc.atlauncherapi.apiobjects.PackResult;
import me.hypherionmc.atlauncherapi.apiobjects.PackVersionResult;
import me.hypherionmc.atlauncherapi.apiobjects.SimplePackResult;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ATLauncherAPIClient {

    /* Private API Variables */
    private final OkHttpClient client = new OkHttpClient().newBuilder().callTimeout(1,TimeUnit.MINUTES).connectTimeout(1,TimeUnit.MINUTES).readTimeout(1,TimeUnit.MINUTES).build();
    private final String apiurl = "https://api.atlauncher.com/v1/";

    /***
     * Get info about a modpack
     * @param safename - The name of the modpack to search for (Case Sensitive and NO SPACES ALLOWED)
     * @return
     */
    public Optional<PackResult> getPackInfo(String safename) {
        try {
            Request request = new Request.Builder().url(apiurl + "pack/" + safename + "/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    /***
     * Get basic information about a single version of the modpack
     * @param safename - The name of the modpack to search for (Case Sensitive and NO SPACES ALLOWED)
     * @param version - Version to lookup (Use latest to get the newest version)
     * @return
     */
    public Optional<PackVersionResult> getPackVersion(String safename, String version) {
        try {
            Request request = new Request.Builder().url(apiurl + "pack/" + safename + "/" + version + "/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackVersionResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    /***
     * Get a collection of basic information of all published modpacks
     * @return
     */
    public Optional<SimplePackResult> getSimplePackInfo() {
        try {
            Request request = new Request.Builder().url(apiurl + "packs/simple/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), SimplePackResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks
     * @return
     */
    public Optional<PackArrayResult> getAllPacks() {
        try {
            Request request = new Request.Builder().url(apiurl + "packs/full/all/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks marked as public
     * @return
     */
    public Optional<PackArrayResult> getPublicPacks() {
        try {
            Request request = new Request.Builder().url(apiurl + "packs/full/public/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks marked as semi-public
     * @return
     */
    public Optional<PackArrayResult> getSemiPublicPacks() {
        try {
            Request request = new Request.Builder().url(apiurl + "packs/full/semipublic/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks marked as private
     * @return
     */
    public Optional<PackArrayResult> getPrivatePacks() {
        try {
            Request request = new Request.Builder().url(apiurl + "packs/full/private/").cacheControl(new CacheControl.Builder().noCache().build()).build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }
}
