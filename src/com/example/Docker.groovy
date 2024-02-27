#! /usr/bin/ env groovy
package com.example

class Docker implements Serializable {

    def script
    Docker (script) {
        this.script = script
    }

    def buildDocker (String imgName) {

        script.echo 'Building the docker image... '
        script.withCredentials([usernamePassword(credentialsId: 'sameh-dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')])
                {
                    script.sh  "docker build -t $imgName simplefile_Examples/com-pipeline/ "
                    script.sh  " echo $script.PASS | docker login -u $script.USER --password-stdin "
                    script.sh  " docker push $imgName "
                }

    }


}