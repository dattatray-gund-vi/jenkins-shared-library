#!/usr/bin/env groovy

import com.example.constants.ApplicationConstants

def call(String name = null) {
    script {
        def resource = libraryResource 'config.properties'
        echo "$resource"
        def properties = new Properties()
        properties.load(new StringReader(resource))

        echo "$properties"

        def configname = properties.getProperty(ApplicationConstants.NAME)
        echo "Greeting: $configname"
    }
}
