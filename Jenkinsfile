pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/PratikHekad/-JenExtent_Report.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    reportDir: 'target',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }
}
