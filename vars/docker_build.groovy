def call(String ImageName, String ImageTag) {
    sh "docker build -t ${ImageName}:${ImageTag} ."
}
