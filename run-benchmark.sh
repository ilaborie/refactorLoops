#!/usr/bin/env bash


#############################################################
### IMPORTANT !                                           ###
###-------------------------------------------------------###
### You should have SDKMAN! installed (http://sdkman.io/) ###
#############################################################


#FORK=10
#ITER=10
#W_ITER=10
#FORMAT=json

FORK=5
ITER=10
W_ITER=10
FORMAT=json

JAR=perfs/target/benchmarks.jar

# Compile Benchmarks
echo "Compile benchmarks ..."
mvn clean package -q

# SDKMAN!
export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"
sdkman_auto_answer=true

# JVM List
JvmList=(
    "8.0.202.hs-adpt"
    "11.0.2-open"
    "12.0.0-open"
    "1.0.0-rc-14-grl"
)
for Jvm in ${JvmList[*]}
do
    echo "Try benchmarks on [Java $Jvm]"
    sdk use java ${Jvm} # <!> might trigger installation
    java -jar ${JAR} -bm ss -foe true -f 0 -rf ${FORMAT} -v SILENT
done


for Jvm in ${JvmList[*]}
do
    echo "Run benchmarks on [Java $Jvm] with ${FORK} fork, ${ITER} iterations, and ${W_ITER} wramup iteration"
    sdk use java ${Jvm} # <!> might trigger installation
    java -jar ${JAR} -f ${FORK} -i ${ITER} -wi ${W_ITER} -rf ${FORMAT} -rff "jmh-result_${Jvm}.$FORMAT"
done


echo "Rollback to default Java"
sdk use java
