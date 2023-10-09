CREATE USER `java-springboot-svc`;
GRANT ALL ON `java-springboot-svc`.* TO 'java-springboot-svc'@'%';
ALTER USER 'java-springboot-svc'@'%' IDENTIFIED WITH mysql_native_password BY 'java-springboot-svc';
FLUSH PRIVILEGES;
