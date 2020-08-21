**Get all products**
----
  Returns json data about all stored products.

* **URL**

  /products

* **Method:**

  `GET`
  
*  **URL Params**

    None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 12, name : "Computer", details : "Neuster Desktop PC", price : 999.99, category : 1 }]`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Create new product**
----
  Creates a new product in the system.

* **URL**

  /products

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  **Required:**
  
  `{ id : <int>, name : <string>, details : <string>, price : <double>, category : <int> }`

* **Success Response:**

  * **Code:** 201 <br />
 
* **Error Response:**
  
  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Show product**
----
  Returns json data about a single prodcut.

* **URL**

  /product/:productID

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `productID=[int]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 201 <br />
    **Content:** `{ id : 12, name : "Computer", details : "Neuster Desktop PC", price : 999.99, category : 1 }`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Product not found" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Updates product**
----
  Update an existing product.

* **URL**

  /product/:productID/:name/:details/:price/:category

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:**
 
   `productID=[int]`
   `name=[string]`
   `details=[string]`
   `price=[double]`
   `category=[int]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Product not found" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Delete product**
----
  Deletes an existing product.

* **URL**

  /product/:productID

* **Method:**

  `DELETE`
  
*  **URL Params**

   **Required:**
 
   `productID=[int]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Product not found" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
