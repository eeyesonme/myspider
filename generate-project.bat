@echo off
echo [INFO] Generating project in ./projects

if not exist projects mkdir projects
cd projects
call mvn archetype:generate -DarchetypeGroupId=io.myspider -DarchetypeArtifactId=myspider-basic-web -DarchetypeVersion=1.0.0

pause


