def call(String dockerHubUser, String dockerHubPass, String ImageName, String ImageTag) {
    sh """
        echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
        docker image tag $ImageName:$ImageTag $dockerHubUser/$ImageName:$ImageTag
        docker push $dockerHubUser/$ImageName:$ImageTag
    """
}
