**Show all Users**
----
  Returns json data about a all users.

* **URL**

  /users

* **Method:**

  `GET`
  
*  **URL Params**

  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 12, firstName : "Max", lastName : "Exampleman", userName : "Maxemple", password : "max123", role : "user" }]`
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
-----------

**Create User**
----
  Create a new User.

* **URL**

  /users

* **Method:**

  `POST`
  
*  **URL Params**

  None

* **Data Params**

  **Required:**
  `{ id : <long>, firstName : <string>, lastName : <string>, userName : <string>, password : <string>, role : <Role> }`

* **Success Response:**

  * **Code:** 201 <br />
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
        
-----------

**Show User**
----
  Returns json data about a single user.

* **URL**

  /users/:userId

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `userId=[integer]`

* **Data Params**

    None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 12, firstName : "Max", lastName : "Exampleman", userName : "Maxemple", password : "max123", role : "user" }`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
    
-----------

**Update User**
----
  Updates an existing user.

* **URL**

  /users/:userId/:firstName/:lastName/:userName/:userPassword/:role

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required:**
 
   `userId=[integer]`
   `firstName=[string]`
   `lastName=[string]`
   `userName=[string]`
   `userPassword=[string]`
   `role=[boolean]`

* **Data Params**

    None

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
        
-----------

**Delete User**
----
  Deletes an existing user.

* **URL**

  /users/:userId

* **Method:**

  `DELETE`
  
*  **URL Params**

   **Required:**
 
   `userId=[integer]`

* **Data Params**

    None

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
