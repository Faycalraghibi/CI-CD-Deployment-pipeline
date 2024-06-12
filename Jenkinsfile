pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        REPO_NAME = 'faycalraghibi/ci-cd-deployment-pipeline'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Faycalraghibi/CI-CD-Deployment-pipeline.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    dockerImage = docker.build("${env.REPO_NAME}:${env.BUILD_ID}")
                }
            }
        }
        stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                sh './deploy.sh'
            }
        }
    }
}

