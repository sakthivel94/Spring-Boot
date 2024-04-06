pipeline {
  agent any

  tools {
    maven 'maven'
  }

  stages {
    stage('Checkout SCM') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        dir('C:/ProgramData/Jenkins/.jenkins/workspace/college/employee/employee') {
          bat 'mvn clean -Dmaven.test.skip package'
        }
      }
    }

    stage('Run') {
      environment {
       JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'
        PATH = "${env.JAVA_HOME}\\bin;${env.PATH}"
      }
      steps {
        script {
          def jarFilePath = 'C:/ProgramData/Jenkins/.jenkins/workspace/college/employee/employee/target/demo-0.0.1-SNAPSHOT.jar'
          def batchScript = "cmd /c \"java -jar ${jarFilePath}\""
          bat label: 'Run JAR in Background', script: batchScript
        }
      }
    }
  }
}
