FROM registry.cn-hangzhou.aliyuncs.com/docker_respo/java8:1.0

#RUN echo "http://mirrors.aliyun.com/alpine/v3.4/main" > /etc/apk/repositories

# Install base packages 时区
#RUN apk update && apk add curl bash tree tzdata \
#    && cp -r -f /usr/share/zoneinfo/Hongkong /etc/localtime \
#    && echo -ne "Alpine Linux 3.4 image. (`uname -rsv`)\n" >> /root/.built

ENV JHIPSTER_SLEEP 0

# add directly the war
ADD *.war /app.war

RUN sh -c 'touch /app.war'
VOLUME /tmp
EXPOSE 8908
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
    sleep ${JHIPSTER_SLEEP} && \
    java -Djava.security.egd=file:/dev/./urandom -jar ${JAVA_OPTS} /app.war
