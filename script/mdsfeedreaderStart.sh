#!/bin/sh

REL_PATH=`dirname $0`

#JAVA_PATH=/usr/bin/java
LIB_PATH=${REL_PATH}/lib
CONFIG_PATH=${REL_PATH}/config
JAR_FILE_NAME=${REL_PATH}/mdsfeedreader.jar

mkdir -p ${REL_PATH}/log
mkdir -p ${REL_PATH}/data/processed
mkdir -p ${REL_PATH}/data/error

java -jar ${JAR_FILE_NAME} $1 > /dev/null 2>&1


#delete processed files older than 24hours
find ${REL_PATH}/data/processed/* -mtime +1 -exec rm {} \;


