pipeline {


	agent {
		node {
			label 'master'
		}
	}
	
	options {
		timestamps()
	}
	
	
	stages {
	
		stage('Build') {
		
			steps {
				
				git 'https://github.com/skanungo2007/TelecomProjectRepo.git'
				
				script {
					bat 'mvn clean install'
				}
			}
		
		}
	
	}
	
	
	post {
		
		always {
			
			step([$class : 'Publisher', reportFilenamePattern : '**/testng-results.xml'])
			
		}
	}		
	
}
