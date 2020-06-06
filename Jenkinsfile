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
}