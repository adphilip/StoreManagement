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

I haven't implemented the provider class because I don't have a database server available.
I would have implemented it with JPA, creating a ProductEntity class annotated with the necessary annotations 
for retrieving from the database and then creating. I would have either added a new layer, for repositories, or it would
have been easier to rename from Provider to Repository and use the existing class.