#! /usr/bin/ env groovy
package com.example

class Docker implements Serializable {

    def script
    Docker (script) {
        this.script = script
    }

   /* collective groovy class/ the function that has all logic/info centerally in this class
   def buildDocker (String imgName) {
        script.echo 'Building the docker image... '
        script.withCredentials([script.usernamePassword(credentialsId: 'sameh-dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')])
                {
                    script.sh  "docker build -t $imgName simplefile_Examples/com-pipeline/ "
                    script.sh  " echo $script.PASS | docker login -u $script.USER --password-stdin "
                    script.sh  " docker push $imgName "
                }
    } */
  // Next: separate groovy classes:

    def dockerbuild (String imgName) {
         script.sh  "docker build -t $imgName simplefile_Examples/com-pipeline/ "
    }

    def dockerLogin () {
        script.withCredentials([script.usernamePassword(credentialsId: 'sameh-dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASS')])
           {
              script.sh " echo $script.PASS | docker login -u $script.USER --password-stdin "

                }
    }

    def buildpush (String imgName) {
                        script.sh  " docker push $imgName "
                    }

}