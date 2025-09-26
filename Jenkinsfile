pipeline {
    agent any

    tools {
        maven 'Maven'    // 👈 must match the name you configured in Jenkins > Global Tool Configuration
        jdk 'Java21'     // 👈 or Java17, depending on your setup
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/cabdiasismohamed/GroupTask-Tests.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Unit Tests') {
            steps {
                bat 'mvn test -Dgroups=unit'
            }
        }

        stage('Integration Tests') {
            steps {
                bat 'mvn test -Dgroups=integration'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
