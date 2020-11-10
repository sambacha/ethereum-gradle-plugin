rootProject.name = "python-gradle-plugin"

include("examples:sample-python-project",
        "examples:geobuf-python-project",
        "examples:sample-python-project-groovy-dsl")

pluginManagement {
    repositories {
        mavenLocal()
        jcenter()
    gradlePluginPortal()
    maven(url = "https://dl.bintray.com/gradle/gradle-plugins")
  
    }
}