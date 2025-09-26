pipeline {
    agent any

    tools {
        maven 'Maven'   // must match name in Jenkins Global Tool Config
        jdk 'Java21'    // or Java17 if you configured that
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/cabdiasismohamed/GroupTask-Tests.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                bat 'mvn verify'
            }
            post {
                always {
                    junit 'target/failsafe-reports/*.xml'
                }
            }
        }
    }
}
