pipeline {
    agent any

   environment {
           GIT_EXECUTABLE = 'C:\Program Files\Git'  // Ensure this is the correct path
       }

    stages {
        stage('Verify Git')
        {
                    steps {
                        sh '"${env.GIT_EXECUTABLE}" --version'  // Verify Git path
                    }
                }

        stage('Clone Repository')
        {
                    steps {
                        sh '"${env.GIT_EXECUTABLE}" clone https://github.com/AmolGit005/ShoppingCart_Automation.git'
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
