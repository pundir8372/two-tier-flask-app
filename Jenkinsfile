@Library("Shared") _
pipeline {
    agent { label "dev" }
    
   
    
    stages {
        stage("Code Clone") {
            steps {
                script{
                    code_checkout(url:"https://github.com/pundir8372/two-tier-flask-app.git", branch:"master")
                }
                
            }
        }

        stage("Build") {
            steps {
                script{
                    docker_build(ImageName:"two-tier-flask-app" , ImageTag:"latest")
                }
                
            }
        }

        stage("Push to DockerHub") {
            steps {
                script{
                    docker_push(ImageName:"two-tier-flask-app",ImageTag:"latest")
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
            sendNotification(buildStatus:'SUCCESS', ProjectName:'two-tier-flask-app')
        }

        failure {
            echo "Pipeline failed. Please check the logs."
            sendNotification(buildStatus:'FAILURE', ProjectName:'two-tier-flask-app')
        }
    }
}
