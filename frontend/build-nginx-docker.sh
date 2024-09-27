docker rmi dosoar.net/email-security-frontend
docker build -t dosoar.net/email-security-frontend .
docker save -o email-security-frontend.tar dosoar.net/email-security-frontend