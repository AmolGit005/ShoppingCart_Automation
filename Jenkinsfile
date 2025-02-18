pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/AmolGit005/ShoppingCart_Automation.git'
        CREDENTIALS_ID = 'AmolGit005'  // Replace with your stored credentials ID
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: CREDENTIALS_ID, url: REPO_URL
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'make build || mvn clean package'  // Modify based on your build tool
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'make test || mvn test'  // Modify based on your testing setup
            }
        }

    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
