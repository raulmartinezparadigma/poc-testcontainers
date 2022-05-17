# CentOS 7 with ECI settings (dockerLauncher.rb)
FROM dcos-registry.pre.eci.geci:5000/eci/centos:7

RUN yum -y install unzip wget


# Using CI process
ENV http_proxy="##HTTP_PROXY##" \
    https_proxy="##HTTP_PROXY##" \
    no_proxy="localhost,127.0.0.0/8,127.0.1.1,127.0.1.1*,local.home,*.geci,*.eci,*.int,*.mesos"

# Install Oracle Java 8u131 Server JRE x64
RUN curl http://nexus.elcorteingles.int/service/local/repositories/eci-docker-software/content/com/oracle/java/jre/1.8.0_131/jre-1.8.0_131-server.zip > jre-1.8.0_131-server.zip && \ 
    mkdir -p /usr/java/ && \
    unzip /jre-1.8.0_131-server.zip -d /usr/java/jdk1.8.0_131/ && \
    rm -f /jre-1.8.0_131-server.zip && \
    export JAVA_DIR=$(ls -1 -d /usr/java/*) && \
    ln -s $JAVA_DIR /usr/java/latest && \
    ln -s $JAVA_DIR /usr/java/default && \
    alternatives --install /usr/bin/java java $JAVA_DIR/bin/java 20000 && \
    alternatives --install /usr/bin/javac javac $JAVA_DIR/bin/javac 20000 && \
    alternatives --install /usr/bin/jar jar $JAVA_DIR/bin/jar 20000

ENV JAVA_HOME=/usr/java/default

RUN curl http://nexus.elcorteingles.int/service/local/repositories/GC/content/es/eci/ic/nexusDownloader/1.0.1.0/nexusDownloader-1.0.1.0.zip > nexusDownloader-1.0.1.0.zip && \
unzip nexusDownloader-1.0.1.0.zip && rm -f nexusDownloader-1.0.1.0.zip && chmod +x nexus_downloader.sh


ENV BUILD_VERSION=##BUILD_VERSION##
ENV GROUP_ID=com.eci.poctestcontainers.ms
ENV ARTIFACT_ID=poc-testcontainers-ms-example


# Install Microservice (.JAR) and configuration
RUN ./nexus_downloader.sh $GROUP_ID $ARTIFACT_ID $BUILD_VERSION jar fat && \
	mv $ARTIFACT_ID-*.jar /poc-testcontainers-ms-example.jar && \
	./nexus_downloader.sh $GROUP_ID $ARTIFACT_ID $BUILD_VERSION zip configuration && \
    mv $ARTIFACT_ID-*-configuration.zip /configuration.zip && \
    unzip /configuration.zip && \
    rm -f /configuration.zip
    
# Using CI process (hay que ponerlos al final porque sino los coge para las descargas con el curl)
#ENV http_proxy="##HTTP_PROXY##"
#ENV https_proxy="##HTTP_PROXY##"