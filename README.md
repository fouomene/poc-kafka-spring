# poc-kafka-spring
Apache Kafka is a distributed and fault-tolerant stream processing system.  

In this POC, we'll cover Spring support for Kafka and the level of abstractions it provides over native Kafka Java client APIs.  

Spring Kafka brings the simple and typical Spring template programming model with a KafkaTemplate and Message-driven POJOs via @KafkaListener annotation.


# Step 1: Get Kafka

Download https://kafka.apache.org the latest Kafka release and extract it:

$ tar -xzf kafka_2.13-3.2.0.tgz
$ cd kafka_2.13-3.2.0


#Step 2: Start the Kafka environment

NOTE: Your local environment must have Java 8+ installed.

Run the following commands in order to start all services in the correct order:

-Start the ZooKeeper service
-Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
$ bin/zookeeper-server-start.sh config/zookeeper.properties

or window

$ .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Open another terminal session and run:

- Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

or window

$ .\bin\windows\kafka-server-start.bat .\config\server.properties

Once all services have successfully launched, you will have a basic Kafka environment running and ready to use. 

#Step 3: Run spring boot app poc-kafka-spring


Test Producer  

POST http://localhost:8080/api/v1/createuser
Content-Type: application/json
{
  "name": "Daniel Fouomene",
  "email": "daniel.fouomene@afrinnov.xyz"
}
