if [ -n "$PID" ]; then
    echo "Killing process with ID: $PID"
    kill $PID
else
    echo "No process found on port 8080"
fi

rm /home/dwwangtianqi1/backend/email-security-demo-0.0.1-SNAPSHOT.jar
s3cmd get s3://ai-mail-03/backend/email-security-demo-0.0.1-SNAPSHOT.jar /home/dwwangtianqi1/backend/
chmod 700 /home/dwwangtianqi1/backend/email-security-demo-0.0.1-SNAPSHOT.jar
nohup /home/dwwangtianqi1/env/amazon-corretto-17.0.12.7.1-linux-x64/bin/java -Dfile.encoding="UTF-8" -Dsun.jnu.encoding="UTF-8" -jar /home/dwwangtianqi1/backend/email-security-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=test &

echo finshed