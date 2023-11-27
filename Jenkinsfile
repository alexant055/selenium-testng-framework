pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
    	stage('Unit Test') {
    		steps {
    		     sh "mvn clean test"
    		}
    		
    		post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    emailext (attachLog: true, 
                    body: '''Hello, Here is the test result of the latest build.Thanks,''', 
                    compressLog: true,  
                    subject: 'Selenium-TestNG-Report', 
                    to: 'alexander.kirubhakaran@gmail.com')
                }
            }
    	}
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean package -Dmaven.test.skip"
            }
        }
    }
}
