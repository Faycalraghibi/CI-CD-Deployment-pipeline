pipeline {
    agent any
    tools {
        maven 'Maven' // Doit correspondre au nom de l'installation de Maven dans Jenkins
        jdk 'JDK 21' // Doit correspondre au nom de l'installation de JDK dans Jenkins
    }
    environment {
        DEPLOY_COLOR = sh(script: 'if [ $(docker ps -q --filter "name=spring-app-green") ]; then echo blue; else echo green; fi', returnStdout: true).trim()
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
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("spring-example:${env.BUILD_ID}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-credentials') {
                        docker.image("spring-example:${env.BUILD_ID}").push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh "sed -i 's/spring-app-blue/spring-app-${env.DEPLOY_COLOR}/g' deploy.sh"
                    sh './deploy.sh'
                }
            }
        }
    }
    post {
        success {
            echo 'The build and deployment were successful!'
        }
        failure {
            echo 'The build or deployment failed.'
        }
    }
}

