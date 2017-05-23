# continuous-delivery-demo
Demo of Continuous Delivery using Jenkins for a Java code-base with a sample application

## Pre-requisites
1. Windows computer
2. [Jenkins](https://jenkins.io) installed locally
3. [Chrome Web driver](https://sites.google.com/a/chromium.org/chromedriver/downloads) installed locally and placed at C:\
4. [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed
5. [Maven 3](https://maven.apache.org/download.cgi) installed
6. Two separate copies of Apache Tomcat running. One is considered as staging and another is considered as production environment.  Change the directory name under `scripts/deploy-prod.bat` and `scripts/deploy-stage.bat`


## Steps to create a pipeline
1. Create a Jenkins Pipeline pointing to the 'Git' repository where you checked out this repository with SCM poll of 5 minutes or so.
2. Commit to local repository (without internet connection) and see how the pipeline responds.