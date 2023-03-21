pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                
              	bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
	      stage('Test') {
            steps {
                
              	bat "test"
            }
        }
          stage('install') {
            steps {
                
              	bat "install"
            }
        }
    }
}
