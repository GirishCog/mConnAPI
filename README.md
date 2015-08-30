# iMaven


URL for git webservice
http://localhost:8080/ws_iGitHub/rest/igithub/gitClone

POST Service Below data goes to body part


{"localProjectPath":"/Users/jcon787/Downloads/personal/CTS/iGitProject",
"password":"password",
"remoteUrl":"https://github.com/MuleSoftAccelerators/PrototypeGitHubClient.git",
"branch":"master",
"branchId":"CR001",
"projectName":"projectName",
"userID":"u999"}




URL for maven webservice
http://localhost:8080/ws_iMaven/rest/imaven/install


POST Service Below data goes to body part

{"mavenPath":"/Program Files/Apache Software Foundation/apache-maven-3.3.3",
"mavenLogPath":"/Users/jcon787/Downloads/personal/CTS/iGitProject/CR001/mavenLog",
"logFileName":"logFile.txt",
"branchId":"CR001",
"warFileName":"PrototypeGitHubClient.war",
"mavenProjectPath":"/Users/jcon787/Downloads/personal/CTS/iGitProject/CR001/projectName",
"moveWarFileTo":"/Users/jcon787/Downloads/personal/CTS/iGitProject/CR001/MavenBuild"}
