# Inventory Management System API
A Spring Boot backend API to manage products in a warehouse. This API allows full CRUD operations on products, stock management, and low-stock alerts.

________________________________________

## Project Overview
This project was developed as part of the ASE Challenge (Associate Software Engineer). It demonstrates backend development skills using Spring Boot, JPA, and MySQL, focusing on:

- Product management (Create, Read, Update, Delete)  
- Stock increase and decrease with validation (no negative stock allowed)  
- Low-stock alerts (products below a threshold)  
- Proper error handling with HTTP status codes  

________________________________________

## Core Features / API Endpoints
1) **Get all products**  
`GET /products/getall`  

2) **Get product by ID**  
`GET /products/getbyid?id={id}`  

3) **Save new product**  
`POST /products/save`  
Body: JSON of Products  

4) **Update full product by ID**  
`PUT /products/update/{id}`  
Body: JSON of Products  

5) **Partial update product by ID**  
`PATCH /products/update/{id}`  
Body: JSON of Products (only fields to update)  

6) **Delete product by ID**  
`DELETE /products/delete?id={id}`  

7) **Increase stock**  
`POST /products/{id}/increseStock?amount={amount}`  

8) **Decrease stock**  
`POST /products/{id}/decreaseStock?amount={amount}`  

9) **Get low stock products**  
`GET /products/getLowStock`  

________________________________________

## Database Table (Products)
| Column               | Type     | Constraints |
|----------------------|---------|-------------|
| pid                  | INT     | Primary Key, Auto Increment |
| name                 | VARCHAR | NOT NULL |
| description          | VARCHAR | Nullable |
| stock_quantity       | INT     | NOT NULL, Default 0, Must be ≥ 0 |
| low_stock_threshold  | INT     | Default 5, Must be ≥ 0 |

________________________________________

## Installation & Setup (Using Spring Tool Suite)
1. Clone the repository:  
    git clone https://github.com/SamataKamble8/inventory-management-api.git
2. Open in Spring Tool Suite (STS):  
   - Launch STS.  
   - Go to File → Import → Maven → Existing Maven Projects.  
   - Select the project folder and finish the import.  

3. Configure MySQL database in `src/main/resources/application.properties`:  
    spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update

4. Run the application:  
   - Right-click on the project → Run As → Spring Boot App  
   - Or run `InventoryManagementSystemApiApplication.java` as a Java application.  

5. Test the APIs:  
   - **Option 1: Using Spring Tool Suite Console**  
     - All unit test cases are written in the `ProductsServiceTest` class.  
     - You can run the test class directly in STS:  
       Right-click on the `ProductsServiceTest` class → Run As → JUnit Test  
     - This will execute all tests for CRUD operations, stock management, and low stock checks.  
   - **Option 2: Using Postman (recommended)**  
     - Example: `GET http://localhost:8080/products/getall`  
     - Example: `POST http://localhost:8080/products/save` with JSON body  

________________________________________

## Assumptions & Design Choices
- Stock quantity cannot go below 0  
- Low stock threshold defaults to 5  
- PATCH endpoint allows updating only the fields provided  
- HTTP status codes are used for proper error handling:  
  - `400 BAD REQUEST` → Invalid input / insufficient stock  
  - `404 NOT FOUND` → Product not found  

________________________________________

## Bonus / Additional Features
- Validations using `@NotNull`, `@NotBlank`, and `@Min` annotations  
- Proper exception handling with `ResponseStatusException`  
- Unit tests cover all major operations  
- API tested both in STS console and Postman  

________________________________________

**Author:** 
Samata Gulab Kamble
LinkedIn - www.linkedin.com/in/samata-kamble-817900191
GitHub- https://github.com/SamataKamble8

