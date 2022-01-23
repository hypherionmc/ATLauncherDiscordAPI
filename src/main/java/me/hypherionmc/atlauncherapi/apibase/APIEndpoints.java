package me.hypherionmc.atlauncherapi.apibase;

public enum APIEndpoints {
    PACK("pack/"),
    SIMPLE_PACKS("packs/simple"),
    FULL_PACKS("packs/full/all"),
    PUBLIC_PACKS("packs/full/public"),
    SEMI_PUBLIC_PACKS("packs/full/semipublic"),
    PRIVATE_PACKS("packs/full/private"),
    NEWS("news");

    private final String endpoint;

    APIEndpoints(String url) {
        String apiurl = "https://api.atlauncher.com/v1/";
        endpoint = apiurl + url;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
