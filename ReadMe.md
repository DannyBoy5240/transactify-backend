# Transaction Manager Backend

## Overview
A Spring Boot-based backend application that provides RESTful APIs for managing transactions. The backend allows users to perform CRUD operations on transactions, calculate account balances, and integrates with a React frontend.

## Features
- Add new transactions (credit or debit).
- Fetch transactions by account number or transaction ID.
- Calculate account balances dynamically.
- Delete transactions by transaction ID.
- Integrated with H2 in-memory database for testing and development.

## Technologies Used
- **Java**: Backend programming language.
- **Spring Boot**: For building the application and REST APIs.
- **Spring Data JPA**: For database operations.
- **H2 Database**: In-memory database for testing and development.
- **Maven**: Build and dependency management tool.

## How to start
1. Build the project
   ```
   mvn clean install
   ```
2. Run the application
   ```
   mvn spring-boot:run
   ```
3. Access the backend server
   ```
   http://localhost:8080
   ```

## API Endpoints
- Base URL
```
http://localhost:8080/transactions
```
- Endpoints
  1. Create Transaction: `POST /transactions`
    ```
    Request Body
      {
          "accountNumber": "123456",
          "amount": 100.0,
          "creditOrDebit": "CREDIT"
      }
    ```

  2. Get Transactions by Account Number: `GET /transactions/{accountNumber}`
      ```
      Response
        {
          "transactions": [
              {
                  "transactionId": 1,
                  "accountNumber": "123456",
                  "amount": 100.0,
                  "creditOrDebit": "CREDIT"
              }
          ],
          "balance": 100.0
        }
      ```

  3. Delete Transaction: `DELETE /transactions/{transactionId}`

## Testing the API
* Use `Postman` or `curl` to test the API endpoints.
    ```
    curl -X POST http://localhost:8080/transactions \
     -H "Content-Type: application/json" \
     -d '{"accountNumber":"123456","amount":100.0,"creditOrDebit":"CREDIT"}' 
    ```
