def call(String buildStatus, String projectName) {
    def subject = "${buildStatus}: Jenkins Pipeline for ${projectName}"
    def body = "Build ${buildStatus} for ${projectName}"
    
    emailext(
        subject: subject,
        to: "pundirsahil320@gmail.com",
        from: "jenkins@example.com",
        body: body
    )
}
