# ATLauncher Discord JAVA API

**What is this?**

This is a simple to use API for ATLauncher modpacks intended to be used with Discord bots (Like release notification bots)


**But why?**

I needed to add ATLauncher support to discord bot to notify my server members, as well as the members of other servers when someone releases an update for an ATLauncher modpack. I could not find a complete API that did what I needed, so I wrote my own.

**Important notes**

I am not at all a professional JAVA coder, nor do I pretend to be one. This repository is here as a backup for me, and to be useful to others. If you're going to make comments about my coding, buzz off now already. If you know you can do it better, then do it and contribute to this project!

#### What does this API support?

* Getting full information about a single modpack
* Getting full information of all modpacks

### How do I use this in my project?

The latest release of this library is hosted on my Maven and can be used with Gradle based projects.

To use the Library in your project, add `https://maven.hypherionmc.me` as a repository.

Add the following to your build.gradle file under dependencies:
`implementation 'me.hypherionmc:ATLauncherDiscordAPI:1.1'`

Basic example for using this library

```java
ATLauncherAPIClient apiClient = new ATLauncherAPIClient(); // Create a new APIClient

Optional<PackResult> packOptional = apiClient.getPackInfo("MysticsCubicChunksModpack"); // Retrieve the info of a single pack

packOptional.ifPresent(pack -> { // Check if the API Call succeeded
    if (!pack.isError()) { // Check if the API did not give an error (Like pack not found, etc)
        System.out.println(pack.getData().getName()); // Print the display name of the pack to the console
    }
});
```

Need more help? Join my [discord server](https://discord.gg/vxaQdVK) 