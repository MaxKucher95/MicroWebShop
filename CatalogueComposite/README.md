**Delete category**
----
  Deletes an existing category with all the associated products.

* **URL**

  /catalogue/:categoryID

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

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`
