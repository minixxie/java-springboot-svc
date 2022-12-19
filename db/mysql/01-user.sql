CREATE USER `demo-svc`;
GRANT ALL ON `demo-svc`.* TO 'demo-svc'@'%';
ALTER USER 'demo-svc'@'%' IDENTIFIED WITH mysql_native_password BY 'demo-svc';
FLUSH PRIVILEGES;
