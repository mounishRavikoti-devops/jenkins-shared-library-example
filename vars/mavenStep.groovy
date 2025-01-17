// vars/helloWorld.groovy
import static by.bulgak.jenkins.lib.Constants.MAVEN;
def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    def maven = tool "maven";
    print maven;
    stage("${config.name}"){
        sh "touch ${config.filename}"
	    sh "cp ${config.filename} ${config.destpath}"
    }
}


