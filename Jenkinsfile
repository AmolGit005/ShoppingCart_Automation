pipeline {
    agent any

    triggers {
        cron('0 2 * * *') // Schedule to run daily at 2:00 AM
    }

    stages {
        stage('Build') {
            steps {
                dir('C:\Users\Admin\.jenkins\workspace\ShoppingCart_Automation') { // Replace with the actual path
                    bat 'mvn clean install' // Build the project
                }
            }
        }

        stage('Test') {
            steps {
                dir('C:\Users\Admin\.jenkins\workspace\ShoppingCart_Automation') {
                    bat 'mvn test' // Run the tests
                }
            }
        }
    }
}