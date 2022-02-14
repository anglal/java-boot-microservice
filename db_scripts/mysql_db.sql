
# DB scripts
# 1. Microservice 1(pi-ms)

create database msqldbx;
use msqldbx;
create user 'pi-ms-user'@'%' identified by 'pi-ms-userpassword';
grant all on msqldbx.* to 'pi-ms-user'@'%';


# 2. Microservice 2(wrk-ms)

create database msqldby;
use msqldby;
create user 'wrk-ms-user'@'%' identified by 'wrk-ms-userpassword';
grant all on msqldby.* to 'wrk-ms-user'@'%';



