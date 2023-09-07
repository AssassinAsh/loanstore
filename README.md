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

To create Tables - 

CREATE TABLE Loans (
LoanID INT PRIMARY KEY,
CustomerID INT,
LenderID INT,
Amount DECIMAL(10, 2),
RemainingAmount DECIMAL(10, 2),
PaymentDate DATE,
InterestPerDay DECIMAL(5, 2),
DueDate DATE,
PenaltyPerDay DECIMAL(5, 2),
Cancelled BOOLEAN
);

