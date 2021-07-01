pipeline {
    agent any

    tools { 
        maven "Maven"
    }

    stages {
        stage('Build') {
            steps {
                echo "Building"
                sh "mvn package -DskipTests"
            }
        }
        stage('Testing') {
            steps {
                echo "Testing"
            }
        }
        stage('Deployment') {
            when {
                expression { env.BRANCH_NAME == 'main' }
            }
            steps {
                echo "Deploying"
            }
        }
    }
}