# StoreManagement

The products api has 4 methods:
- retrieve all products: GET /products
- retrieve a product with a specific id: GET /products/{id}
- create a new product: POST /products   -- the payload is a serialized ProductDto object
- update an existing product: PUT /products/{id}   -- the payload is a serialized ProductDto object

The retrieval methods are available to any roles, STANDARD or ADMIN.
The create and update methods are available only to users with the role ADMIN.

STANDARD user:
user1
password1

ADMIN user:
user2
password2

I use an H2 in memory database which is prepopulated with three products