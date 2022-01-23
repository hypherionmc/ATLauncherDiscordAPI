package me.hypherionmc.atlauncherapi.apibase;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class UserAgentInterceptor implements Interceptor {

    private final String useragent;

    public UserAgentInterceptor(String useragent) {
        this.useragent = useragent;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder()
                .header("User-Agent", useragent)
                .build();
        return chain.proceed(requestWithUserAgent);
    }
}
