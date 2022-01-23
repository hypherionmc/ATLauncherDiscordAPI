# ATLauncher JAVA API

![Latest](https://maven.firstdarkdev.xyz/api/badge/latest/releases/me/hypherionmc/ATLauncherDiscordAPI?color=40c14a&name=ATLauncherDiscordAPI)

---

**What is this?**

This is a simple-to-use [API for ATLauncher](https://wiki.atlauncher.com/api-docs/v1/information) Modpacks intended to be used with Discord bots (Like release notification bots), but can be used to pull data from their API as needed.

---

**But why?**

I needed to add ATLauncher support to discord bot to notify my server members, as well as the members of other servers when someone releases an update for an ATLauncher modpack. I could not find a complete API that did what I needed, so I wrote my own.

---

#### What does this API support?

* Getting full information about a single modpack
* Getting full information of all modpacks
* Getting the latest news from the launcher

---

### How do I use this in my project?

The latest release of this library is hosted on my Maven and can be used with Gradle based projects.

To use the Library in your project, add `https://maven.firstdarkdev.xyz/releases` as a repository.

Add the following to your build.gradle file under dependencies:
`implementation "me.hypherionmc:ATLauncherDiscordAPI:VERSION"`

![](https://maven.firstdarkdev.xyz/api/badge/latest/releases/me/hypherionmc/ATLauncherDiscordAPI?name=VERSION)

Basic example for using this library

```java
// Create a new APIClient and specify the user agent for your app.
// The useragent is now a requirement by ATLauncher
ATLauncherAPIClient apiClient = new ATLauncherAPIClient("YourAppName user@gmail.com");

Optional<PackResult> packOptional = apiClient.getPackInfo("MysticsCubicChunksModpack"); // Retrieve the info of a single pack

packOptional.ifPresent(pack -> { // Check if the API Call succeeded
    if (!pack.isError()) { // Check if the API did not give an error (Like pack not found, etc)
        System.out.println(pack.getData().getName()); // Print the display name of the pack to the console
    }
});
```

Need more help? Join my [discord server](https://discord.gg/PdVnXf9) 
