pipeline{

    agent any

    stages {

        stage ('Compile Stage') {
            steps {
               bat 'mvn clean install'
            }
        }
        stage ('Test Stage') {

            steps {
                    bat 'mvn clean verify'
            }
         }

    }
    node{
        publishHTML(target: [
                reportName : 'Serenity',
                reportDir:   'target/site/serenity',
                reportFiles: 'index.html',
                keepAll:     true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])
    }
}