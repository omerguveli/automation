pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3' 
        jdk 'JDK 21'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('API Tests') {
            steps {
                sh 'mvn test -Dtest=ApiTestRunner'
            }
        }

        stage('UI Tests') {
            steps {
                sh 'mvn test -Dtest=UiTestRunner'
            }
        }
    }

    post {
        always {
            cucumber 'target/cucumber.json'
            junit 'target/surefire-reports/*.xml'
            
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target',
                reportFiles: 'cucumber-reports.html',
                reportName: 'Cucumber Report'
            ])
        }
    }
}
