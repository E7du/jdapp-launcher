#!/usr/bin/env bash

JAVA_CMD="java"
CPATH="./:lib/*:./:services/*"
CFG_PATH="conf/"
LOG4J_CFG="log4j.configuration=${CFG_PATH}log4j.properties"
DUBBO_CFG="dubbo.properties.file=${CFG_PATH}dubbo.properties"

${JAVA_CMD} -cp ${CPATH} -D${LOG4J_CFG} -D${DUBBO_CFG} org.apache.dubbo.demo.consumer.Consumer