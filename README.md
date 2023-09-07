# loanstore

## Database Queries -

To create Database -
CREATE SCHEMA loanstore;

To create User to Access DB -
CREATE USER greychain@localhost IDENTIFIED BY 'chaingrey';

To use the DB -
USE loanstore;

To grant all privileges to the user -
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, INDEX, ALTER, CREATE TEMPORARY TABLES ON loanstore.* TO 'greychain'@'localhost';

To create Tables - 

CREATE TABLE LenderAggregation (
LenderId INT PRIMARY KEY,
TotalRemainingAmount DECIMAL(10, 2),
TotalInterest DECIMAL(10, 2),
TotalPenalty DECIMAL(10, 2)
);

CREATE TABLE InterestAggregation (
InterestRate INT PRIMARY KEY,
TotalRemainingAmount DECIMAL(10, 2),
TotalInterest DECIMAL(10, 2),
TotalPenalty DECIMAL(10, 2)
);

CREATE TABLE CustomerAggregation (
CustomerId INT PRIMARY KEY,
TotalRemainingAmount DECIMAL(10, 2),
TotalInterest DECIMAL(10, 2),
TotalPenalty DECIMAL(10, 2)
);

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
Cancelled BOOLEAN,
FOREIGN KEY (CustomerId) REFERENCES CustomerAggregation(CustomerId),
FOREIGN KEY (LenderID) REFERENCES LenderAggregation(LenderID),
FOREIGN KEY (InterestPerDay) REFERENCES InterestAggregation(InterestRate)
);


