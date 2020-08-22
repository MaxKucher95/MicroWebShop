**Get all Categories**
----
  Returns json data about all categories.

* **URL**

  /category

* **Method:**

  `GET`
  
*  **URL Params**

    None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, name : "Elektronik" }]`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Create category**
----
  Creates a new category.

* **URL**

  /category

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  **Required:**

  `{ id : <int>, name : <string> }`

* **Success Response:**

  * **Code:** 201 <br />
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Show category**
----
  Returns json data about a single category.

* **URL**

  /category/:categoryID

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**

   `categoryID=[int]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, name : "Elektronik" }`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Category not found" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Updates category**
----
  Update an existing category.

* **URL**

  /category/:categoryID/:name

* **Method:**

  `PUT`
  
*  **URL Params**

  **Required:**

   `categoryID=[int]`
   `name=[string]`

* **Data Params**

    None

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Category not found" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
----------------------------

**Delete category**
----
  Deletes an existing category.

* **URL**

  /category/:categoryID

* **Method:**

  `DELETE`

*  **URL Params**

   **Required:**

   `categoryID=[int]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />

* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "Category not found" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
