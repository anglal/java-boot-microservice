
# DB scripts
# 3. Microservice 3(slry-ms)

create database psgresqldb;
\c psgresqldb
CREATE USER "slry-ms-user" WITH PASSWORD 'slry-ms-userpassword';

GRANT CONNECT ON DATABASE psgresqldb to "slry-ms-user";


log in to user from terminal

psql -d psgresqldb -U slry-ms-user -W





# Notes:

# Macs

To use from sql from terminal 

create .zshrc file in ~ directory
and export path to the postgress.app
and source the change

These are not exact syntax, just the steps




# password/no-password login

HBA file
pg_hba.conf

Lines to change
# local   all             all                                     trust
  local   all             all                                     md5




if unable to run psql on terminal

go to ~ and source .zshrc

>> cd ~
>> source .zshrc

If postgres.app does not show databases on ui

Lines to change
# local   all             all                                     trust
  local   all             all                                     md5

# 2. 



GRANT ALL PRIVILEGES ON DATABASE "psgresqldb" to "slry-ms-user";
# 3. 

