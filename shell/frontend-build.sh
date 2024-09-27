s3cmd get s3://ai-mail-03/frontend/email-security-frontend.tar /home/dwwangtianqi1/frontend/
sudo docker stop frontend-container
sudo docker rm frontend-container
sudo docker rmi dosoar.net/email-security-frontend
sudo docker load -i /home/dwwangtianqi1/frontend/email-security-frontend.tar
sudo docker run --name frontend-container -p 8888:7777 dosoar.net/email-security-frontend