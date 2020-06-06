pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

               sh 'mvn clean install'


            }
        }
    stage ('Test Stage') {

            steps {


                    sh 'mvn clean verify'



            }
        }
    }
}