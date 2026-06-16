pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/2002Umesh/Capstone_Project'
            }
        }

        stage('Build') {
            steps {
                dir('Capstone_Project') {
                    bat 'mvn clean'
                }
            }
        }

        stage('Compile') {
            steps {
                dir('Capstone_Project') {
                    bat 'mvn compile'
                }
            }
        }

        stage('Test') {
            steps {
                dir('Capstone_Project') {
                    bat 'mvn test'
                }
            }

            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                dir('Capstone_Project') {
                    bat 'mvn package'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('Capstone_Project') {
                    bat 'docker build -t cucumber-framework .'
                }
            }
        }

        stage('Docker Run') {
            steps {
                dir('Capstone_Project') {
                    bat 'docker run cucumber-framework'
                }
            }
        }
    }

    post {
        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}