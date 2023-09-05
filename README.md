# loanstore

## Database Queries -

To create Database -
CREATE SCHEMA loanstore;

To create User to Access DB -
CREATE USER greychain@localhost IDENTIFIED BY 'chaingrey';

To use the DB -
USE loanstore;

To grant all privileges to the user -
GRANT ALL PRIVILEGES on loanstore to greychain@localhost;