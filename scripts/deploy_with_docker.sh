#!/bin/sh
echo "******************************************************************************************"
echo "* CONSTRUYENDO ARTEFACTOS *"
echo "******************************************************************************************"

sh ../../scripts/build.sh clean
sh ../../scripts/build.sh install

echo "******************************************************************************************"
echo "* CONSTRUYENDO DOCKER *"
echo "******************************************************************************************"

docker build -t "dcos-registry.pre.eci.geci:5000/project-example-ms-example:0.1" ../
#docker push dcos-registry.pre.eci.geci:5000/project-example-ms-example:0.1