def call(String repoUrl) {
pipeline{
agent any
stages{
  stage("Checkout Code") {
steps {
git branch: 'master',
url: "${repoUrl}"
}
}
stage('build'){
steps{
echo 'building'
bat "${params.BUILD}"
}
}
stage('test'){
steps{
echo "testing ${params.BUILD}"
bat "${params.TEST}"

}
}
}
parameters{
string(name: 'BUILD',defaultValue: 'mvn clean',description:'build command')
string(name: 'TEST',defaultValue: 'mvn test',description:'test command')
}
}
}
