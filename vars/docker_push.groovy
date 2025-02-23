def call(String imageName, String imageTag, String dockerHubUser) {
  withCredentials([usernamePassword(credentialsId: 'dockerHubCreds', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
    // Login to DockerHub
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    
    // Tag the Docker image
    sh "docker image tag ${imageName}:${imageTag} ${dockerHubUser}/${imageName}:${imageTag}"
    
    // Push the Docker image
    sh "docker push ${dockerHubUser}/${imageName}:${imageTag}"
    
   
  }
}
