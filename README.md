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

### To create Tables - 

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
FOREIGN KEY (LenderID) REFERENCES LenderAggregation(LenderID)
);

## Loan API Endpoint -

Url - localhost:8080/loans/update

Sample Request -

{
    "loanId": 123,
    "customerId": 456,
    "lenderId": 789,
    "amount": 10000.0,
    "remainingAmount": 7500.0,
    "interest": 250.0,
    "penalty": 50.0,
    "cancelled": false,
    "paymentDate": "05-07-2023",
    "dueDate": "05-08-2023"
}

## Important Files -

1. LoansController - Consists of the Loan API.
2. LoanServiceImpl - Validates and Saves Loan Data to DB.
3. AggregationComponent - Aggregates Loan Data and Saves to DB.
4. AlertComponent - Retrieves all the loans which have exceeded their due dates.

