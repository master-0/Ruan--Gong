# 使用java环境
FROM java:8
# 缓存目录
VOLUME tmp
# 将当前项目的jar包添加到容器中
ADD target/springboot-mybatis-0.0.1-SNAPSHOT.jar /RestHome.jar
# 当容器启动时 执行启动命令
ENTRYPOINT ["java","-jar","/RestHome.jar"]
