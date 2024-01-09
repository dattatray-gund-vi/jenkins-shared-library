#!/usr/bin/env groovy
import com.example.SystemConfig
import com.example.Utils
import com.example.constants.ApplicationConstants

def call(String name = null) {
    script {
        def systemConfig = loadSystemConfig()
        def updatedName = name ?: systemConfig.getProperty(ApplicationConstants.NAME)
        Utils utils = new Utils()
        echo "Greeting: ${utils.sayHello(updatedName)}"
    }
}

private Properties loadSystemConfig() {
   libraryResource {
       def r = getProperties()
       r.forEach { k, v ->
           echo "Key: $k, Value: $v"
       }
   }

    echo "Loading system config from: $resource"

    def config = libraryResource 'config.properties'
    def sysConfig = new Properties()
    sysConfig.load(new StringReader(config))
    return sysConfig
}
