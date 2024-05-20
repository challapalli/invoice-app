# Invoice App

Invoice App is a Spring Boot application that provides RESTful APIs for managing invoices.

## API Endpoints

### Get All Invoices

- **URL:** `/invoice`
- **Method:** `GET`
- **Description:** Retrieves all invoices.
- **Response:** JSON array of invoices.

### Create Invoice

- **URL:** `/invoice`
- **Method:** `POST`
- **Description:** Creates a new invoice.
- **Request Body:** JSON object representing the new invoice.
- **Response:** JSON object representing the created invoice.

### Update Invoice

- **URL:** `/invoice/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing invoice with the specified ID.
- **Parameters:** `id` (String) - ID of the invoice to update.
- **Request Body:** JSON object representing the updated invoice.
- **Response:** JSON object representing the updated invoice.

### Delete Invoice

- **URL:** `/invoice/{id}`
- **Method:** `DELETE`
- **Description:** Deletes the invoice with the specified ID.
- **Parameters:** `id` (String) - ID of the invoice to delete.
- **Response:** HTTP status code indicating success or failure.

## Sample JSON Structure for Invoice

```json
{
  "id": "123456",
  "invoice": "INV001",
  "customer": "Apple",
  "email": "support@apple.com"
  "invoiceDate": "2024-05-18T12:37:48.040Z"
  "dueDate": "2024-05-18T12:37:48.040Z"
  "status": "Approved"
  "amount": 2566
}
