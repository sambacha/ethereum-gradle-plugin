import org.jetbrains.changelog.closure
import org.jetbrains.changelog.date

plugins {
	`java-gradle-plugin`
	`kotlin-dsl`
	`maven-publish`
	kotlin("jvm") version "1.3.72"
	id("com.gradle.plugin-publish") version "0.11.0"
	id("net.researchgate.release") version "2.8.1"
	id("org.jetbrains.changelog") version "0.5.0"
	id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("com.github.ben-manes.versions") version "0.28.0"
	id("com.gradle.plugin-publish") version "0.11.0"
}

apply(plugin = "io.spring.dependency-management")
apply(from = "${project.rootDir}/gradle/versions.gradle")



group = "com.contractshark.ethereum.gradle"
version = "0.1.0"



repositories {
	mavenLocal()
	jcenter()
	maven {
		setUrl("https://plugins.gradle.org/m2/")
	}
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
}

tasks {
	test {
		useJUnitPlatform()
		testLogging.showStandardStreams = true
	}
	"afterReleaseBuild" {
		dependsOn("publish", "publishPlugins", "patchChangelog")
	}
}
gradlePlugin {
	plugins {
		create("ethereum-gradle-plugin") {
			id = "com.contractshark.ethereum-plugin"
			implementationClass = "com.contractshark.gradle.ethereum.EthereumPlugin"
			description = "Gradle plugin aimed for easing compilation of Solidity/Vyper sources with docker"
			displayName = "Gradle plugin to run ethereum projects with python virtual env."
		}
	}
}

pluginBundle {
	website = "https://github.com/contractshark/ethereum-gradle-plugin"
	vcsUrl = "https://github.com/contractshark/ethereum-gradle-plugin"
	description = "Gradle plugin to run ethereum projects."
	tags = listOf("ethereum", "venv", "numpy", "miniconda", "conda", "solidity", "kotlin-dsl", "docker")

}

dependencies {
	gradleApi()
	implementation("org.web3j:core")
	implementation("org.web3j:abi")
	implementation("org.web3j:utils")
}


publishing {
	repositories {
		mavenLocal()
	}
}

changelog {
	header = closure {
		"[${project.version}] - ${date()}"
	}
}
