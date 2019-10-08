###启动

#!/bin/sh

moduleName="sky-tools"
pidPath="/var/run/$moduleName-tpid"

rm -f $pidPath

#清除日志文件
#rm -rf run_8081.log

#测试环境
nohup java -Xms512m -Xmx512mg -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m -Xss256k -jar ./$moduleName.jar -server>> ./run_8081.log 2>&1 &
#生产环境
#nohup java -Xms4g -Xmx12g -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=1024m -Xss256k -jar ./$moduleName.jar -server>> ./run_8081.log 2>&1 &

echo $! > $pidPath