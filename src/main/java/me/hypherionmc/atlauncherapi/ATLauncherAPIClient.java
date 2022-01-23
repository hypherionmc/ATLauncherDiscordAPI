package me.hypherionmc.atlauncherapi;

import com.google.gson.Gson;
import me.hypherionmc.atlauncherapi.apibase.APIEndpoints;
import me.hypherionmc.atlauncherapi.apibase.UserAgentInterceptor;
import me.hypherionmc.atlauncherapi.apiobjects.*;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ATLauncherAPIClient {

    /* Private API Variables */
    private final OkHttpClient client;
    private final Logger logger = Logger.getLogger("AT-API");
    private final UserAgentInterceptor userAgentInterceptor;
    private final Gson gson = new Gson();

    /***
     * Create a new APIClient object
     * @param userAgent - This should be the Name of your app and contact information. For example "MyCoolApp myuser@gmail.com"
     */
    public ATLauncherAPIClient(String userAgent) {
        userAgentInterceptor = new UserAgentInterceptor(userAgent);
        client = new OkHttpClient().newBuilder()
                .callTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .addNetworkInterceptor(userAgentInterceptor)
                .build();
    }

    /**
     * Private internal call to make API requests
     *
     * @param endPoint - The API endpoint to contact
     * @param params   - Optional parameters to pass to the API call
     * @return - Returns a response from the API
     * @throws IOException - Thrown if an API call fails
     */
    private Response runQuery(APIEndpoints endPoint, String params) throws IOException {
        Request request = new Request.Builder().url(endPoint + params).cacheControl(new CacheControl.Builder().noCache().build()).build();
        return client.newCall(request).execute();
    }

    /***
     * Get info about a modpack
     * @param safename - The name of the modpack to search for (Case Sensitive and NO SPACES ALLOWED)
     * @return
     */
    public Optional<PackResult> getPackInfo(String safename) {
        try {
            Response response = runQuery(APIEndpoints.PACK, safename + "/");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
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
            Response response = runQuery(APIEndpoints.PACK, safename + "/" + version + "/");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackVersionResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    /***
     * Get a collection of basic information of all published modpacks
     * @return
     */
    public Optional<SimplePackResult> getSimplePackInfo() {
        try {
            Response response = runQuery(APIEndpoints.SIMPLE_PACKS, "");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), SimplePackResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks
     * @return
     */
    public Optional<PackArrayResult> getAllPacks() {
        try {
            Response response = runQuery(APIEndpoints.FULL_PACKS, "");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.log(Level.SEVERE, ex.getMessage());

        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks marked as public
     * @return
     */
    public Optional<PackArrayResult> getPublicPacks() {
        try {
            Response response = runQuery(APIEndpoints.PUBLIC_PACKS, "");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks marked as semi-public
     * @return
     */
    public Optional<PackArrayResult> getSemiPublicPacks() {
        try {
            Response response = runQuery(APIEndpoints.SEMI_PUBLIC_PACKS, "");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    /***
     * Gets the full info about ALL published modpacks marked as private
     * @return
     */
    public Optional<PackArrayResult> getPrivatePacks() {
        try {
            Response response = runQuery(APIEndpoints.PRIVATE_PACKS, "");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), PackArrayResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    /***
     * Get the latest ATLauncher news
     * @return
     */
    public Optional<NewsResult> getLauncherNews() {
        try {
            Response response = runQuery(APIEndpoints.NEWS, "");
            if (response.isSuccessful()) {
                return Optional.ofNullable(gson.fromJson(response.body().string(), NewsResult.class));
            } else {
                throw new Exception("Could not retrieve result from API");
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
