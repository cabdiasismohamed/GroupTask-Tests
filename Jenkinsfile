pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/cabdiasismohamed/GroupTask-Tests.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn -Dtest=*Test test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                bat 'mvn -Dtest=*IT verify'
            }
            post {
                always {
                    junit 'target/failsafe-reports/*.xml'
                }
            }
        }
    }
}
