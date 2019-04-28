#!groovy
node {
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        checkout scm
    }
    stage('Build') {
        // Run the maven build - Clean + compile + Unit tests (This is the CI part)
        bat(/mvn clean test/)
        //Collect Unit test reports to show in Jenkins
        junit '**/target/surefire-reports/TEST-*.xml'
    }
    stage('Test') {
        // Run the maven build for Integration & UI Automation tests
        bat(/mvn clean verify package -Pintegration-tests/)

        // Collect Integration Test reports to show in Jenkins
        junit '**/target/failsafe-reports/TEST-*.xml'

        // Collect Cucumber test (UI Automation) reports to show in Jenkins
        step([$class: 'CucumberReportPublisher', fileExcludePattern: '', fileIncludePattern: 'cucumber.json', ignoreFailedTests: false, jenkinsBasePath: '', jsonReportDirectory: 'target/', missingFails: false, parallelTesting: false, pendingFails: false, skippedFails: false, undefinedFails: false])
    }
    stage('Staging') {
        //Deploy to staging environment
        bat 'scripts/deploy-stage.bat'
    }
    stage('Human Verification') {
        // User Acceptance Test - Manual Step
        input 'Does staging environment look good?'
    }
    stage('Deploy') {
        // Deploy to production environment
        bat 'scripts/deploy-prod.bat'
    }
}