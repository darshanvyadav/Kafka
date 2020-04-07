# Kafka Notes  

useful commands to run on docker :

docker run --rm -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost landoop/fast-data-dev:latest


	   
	   docker exec -it recursing_gates /bin/bash
	   
	   docker-compose run 8cdf2b781c4c bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
	   
	   docker exec -it 8cdf2b781c4c bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
	   
recursing_gates 	   

docker exec -it recursing_gates /bin/bash




Zookeper in local : 
go to software : zookeper : bin : 
1) run command: ./zkServer.sh

2) 



bin/kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 3 --topic darshan
 
 
 $ docker exec -t -e JMX_PORT="" (docker ps -q --filter 'label=com.docker.swarm.service.name=broker'|head -n1) /opt/kafka/bin/kafka-topics.sh --zookeeper tasks.zookeeper:2181 --partitions=3 --replication-factor=3 --create --topic DArshan
 
 
 Directory structure of kafka : 
******************************************************* 

docker exec -it ReplaceContainerName /bin/bash

root@fast-data-dev / $ cd opt
root@fast-data-dev opt $ ls -l
total 8
drwxr-xr-x 3 root root 4096 May 28 19:26 caddy
drwxr-xr-x 1 root root 4096 May 28 19:18 landoop
root@fast-data-dev opt $ cd landoop
root@fast-data-dev landoop $ ls -l
total 16
-rw-r--r-- 1 root root  776 May 28 19:18 build.info
drwxr-xr-x 4 root root 4096 May 28 19:17 connectors
drwxr-xr-x 1 root root 4096 Dec  3  2018 kafka
drwxr-xr-x 4 root root 4096 May 28 19:18 tools
root@fast-data-dev landoop $ cd kafka
root@fast-data-dev kafka $ history
********************************************************

docker-compose run <container name> <command>

docker-compose run pensive_mahavira bin/kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 3 --topic darshan

docker exec -it <container name> <command>

docker exec -it pensive_mahavira bin/kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 3 --topic darshan

*******************************************************

running zookeper in local doc : 

B. ZooKeeper Installation
1. Go to your ZooKeeper config directory. For me its C:\zookeeper-3.4.7\conf

2. Rename file “zoo_sample.cfg” to “zoo.cfg”

3. Open zoo.cfg in any text editor, like Notepad; I prefer Notepad++.

4. Find and edit dataDir=/tmp/zookeeper to '\zookeeper-3.4.7\data'  

5. Add an entry in the System Environment Variables as we did for Java.

a. Add ZOOKEEPER_HOME = C:\zookeeper-3.4.7 to the System Variables.

b. Edit the System Variable named “Path” and add ;%ZOOKEEPER_HOME%\bin; 

6. You can change the default Zookeeper port in zoo.cfg file (Default port 2181).

7. Run ZooKeeper by opening a new cmd and type zkserver.

8. You will see the command prompt with some details, like the image below:


******************************************************************************************


best way to run kafka in local : 
go to kafka main folder : 
and execute bellow command 

Run this command .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties to start Zookeeper
Run this command .\bin\windows\kafka-server-start.bat .\config\server.properties to start Kafka