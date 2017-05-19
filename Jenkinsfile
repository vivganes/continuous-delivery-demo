#!groovy
node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'C:\\Users\\Vivek\\source-codes\\continuous-delivery-demo\\'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean test"
      } else {
         bat(/"${mvnHome}\bin\mvn" clean test/)
      }
      junit '**/target/surefire-reports/TEST-*.xml'
   }
   stage('Test') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean verify package -Pintegration-tests"
      } else {
         bat(/"${mvnHome}\bin\mvn" clean verify package -Pintegration-tests/)
      }
      junit '**/target/failsafe-reports/TEST-*.xml'
      step([$class: 'CucumberReportPublisher', fileExcludePattern: '', fileIncludePattern: 'cucumber.json', ignoreFailedTests: false, jenkinsBasePath: '', jsonReportDirectory: 'target/', missingFails: false, parallelTesting: false, pendingFails: false, skippedFails: false, undefinedFails: false])
   }
   stage('Staging'){
         bat(/copy target\tasklist.war C:\Users\Vivek\source-codes\tomcat-staging\webapps\tasklist.war/)
   }
   stage('Human Verification'){
         input 'Does staging environment look good?'
   }
   stage('Deploy'){
         bat(/copy target\tasklist.war C:\Users\Vivek\source-codes\tomcat-prod\webapps\tasklist.war/)
   }
}