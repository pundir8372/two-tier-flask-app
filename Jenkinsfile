@Library("Shared") _
pipeline {
    agent { label "dev" }
    
   
    
    stages {
        stage("Code Clone") {
            steps {
                script{
                    code_checkout("https://github.com/pundir8372/two-tier-flask-app.git", "master")
                }
                
            }
        }

        stage("Build") {
            steps {
                script{
                    docker_build("two-tier-flask-app" , "latest")
                }
                
            }
        }

        stage("Push to DockerHub") {
            steps {
                script{
                    docker_push("two-tier-flask-app", "latest", "pundirsahil")
                }
                
               
            }
        }

        stage("Deploy") {
            steps {
                script{
                    deploy()
                }
                
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
            sendNotification('SUCCESS', 'two-tier-flask-app')
        }

        failure {
            echo "Pipeline failed. Please check the logs."
            sendNotification('FAILURE', 'two-tier-flask-app')
        }
    }
}
