FROM openjdk:13 AS build

RUN mkdir -p /workspace
WORKDIR /workspace
COPY . .
RUN yum install -y wget unzip
RUN wget -O /tmp/gradle.zip https://services.gradle.org/distributions/gradle-6.8.3-bin.zip && \
    unzip /tmp/gradle.zip -d /opt && \
    mv /opt/gradle-6.8.3 /opt/gradle

RUN /opt/gradle/bin/gradle test
RUN /opt/gradle/bin/gradle build

# --

FROM openjdk:13 AS deploy

RUN mkdir -p /opt/app
COPY --from=build /workspace/build/libs/demo-0.0.1-SNAPSHOT.war /opt/app/myapp.war

ENTRYPOINT ["java", "-jar", "/opt/app/myapp.war"]

