#! /bin/bash
echo [INFO] Package the war in target dir.

mvn clean package -Dmaven.test.skip=true
	