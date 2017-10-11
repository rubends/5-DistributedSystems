@ echo off
IF "%java_home%"=="" (
	ECHO JAVA_HOME is not defined!
	pause
	exit)
echo "starting RMI registry"
cd out/production/RMIServer
start "RMI registry" "%java_home%/bin/rmiregistry.exe"