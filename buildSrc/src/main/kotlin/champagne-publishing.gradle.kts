plugins {
    signing
    publishing
}

publishing {
    repositories {
        val nexusUser = project.findProperty("nexus_username")
        val nexusPassword = project.findProperty("nexus_password")
        if (nexusUser != null && nexusPassword != null) {
            maven("https://maven.shuuyu.live/snapshots") {
                name = "maven-public"
                credentials {
                    username = nexusUser.toString()
                    password = nexusPassword.toString()
                }
            }
        }
    }
}