pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKER_IMAGE = 'votre_image_docker'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/Faycalraghibi/CI-CD-Deployment-pipeline.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${DOCKER_IMAGE}:${env.BUILD_ID}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', "${DOCKER_CREDENTIALS_ID}") {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy to Docker') {
            steps {
                script {
                    sh './deploy.sh'
                }
            }
        }
    }
}

