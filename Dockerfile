FROM openjdk:17.0.2-oracle

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./leaf-server/target/leaf.jar .
CMD ["java","-jar","leaf.jar"]