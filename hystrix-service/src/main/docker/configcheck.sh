#!/bin/sh

continue=0

while [ $continue -eq 0 ]
do
	status=`curl http://eurekaconfig:s3cr3tpassword@$EUREKACONFIG:8761/health`
	if [[ "`echo ${status}|grep UP `" != "" ]]; then
		continue=1
	else
		echo "Waiting for the EurekaConfig Server ($EUREKACONFIG) to come up..."
		sleep 5s
	fi

done

echo Service is up now.....
