apply plugin: 'maven-publish'

def RELEASE_REPOSITORY_URL = "http://xxxx.yyyy.你的生产maven服务器的地址/" //TODO <--- 请修改
def SNAPSHOT_REPOSITORY_URL = "http://xxxx.yyyy.你的快照maven服务器的地址/" //TODO <--- 请修改
def NEXUS_USERNAME = "maven服务器账号" //TODO <--- 请修改
def NEXUS_PASSWORD = "maven服务器密码" //TODO <--- 请修改

afterEvaluate {
    publishing {
        repositories {
            maven {
                name("ReleaseMaven")
                url = RELEASE_REPOSITORY_URL
                credentials {
                    username = NEXUS_USERNAME
                    password = NEXUS_PASSWORD
                }
            }
            maven {
                name("SnapshotMaven")
                url = SNAPSHOT_REPOSITORY_URL
                credentials {
                    username = NEXUS_USERNAME
                    password = NEXUS_PASSWORD
                }
            }
        }
        publications {
            Production(MavenPublication) {
                from components.release
                        //artifact androidSourcesJar
                        groupId = rootProject.ext.GROUP
                artifactId = rootProject.ext.POM_ARTIFACT_ID
                version = rootProject.ext.VERSION_NAME
            }
            Develop(MavenPublication) {
                from components.debug
                        //artifact androidSourcesJar
                        groupId = rootProject.ext.GROUP
                artifactId = rootProject.ext.POM_ARTIFACT_ID
                version = "${rootProject.ext.VERSION_NAME}-SNAPSHOT"
            }
        }
    }
}
