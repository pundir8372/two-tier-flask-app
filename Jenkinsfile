pipeline {
    agent { label "dev" }
    
   
    
    stages {
        stage("Code Clone") {
            steps {
                git url: "https://github.com/pundir8372/two-tier-flask-app.git", branch: "master"
            }
        }

        stage("Build") {
            steps {
                sh "docker build -t flask-app ."
            }
        }

        stage("Push to DockerHub") {
            steps {
                withCredentials([usernamePassword(credentialsId: "dockerHubCreds", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                    sh 'echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin'
                    sh "docker image tag flask-app:latest $dockerHubUser/two-tier-flask-app:latest"
                    sh "docker push $dockerHubUser/two-tier-flask-app:latest"
                }
            }
        }

        stage("Deploy") {
            steps {
                sh "docker compose down && docker compose up -d --build"
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
            emailext (
                subject: "SUCCESS: Jenkins Pipeline for two-tier-flask-app",
                to: "pundirsahil320@gmail.com",
                from: "jenkins@example.com",
                 body: 'Build success for two-tier-flask-app',
            )
        }

        failure {
            echo "Pipeline failed. Please check the logs."
            emailext (
                subject: "FAILURE: Jenkins Pipeline for two-tier-flask-app",
                to: "pundirsahil320@gmail.com",
                from: "jenkins@example.com",
                 body: 'Build Failed for two-tier-flask-app',
            )
        }
    }
}
