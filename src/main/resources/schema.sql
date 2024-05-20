CREATE TABLE Invoice (
    id int AUTO_INCREMENT PRIMARY KEY,
    invoice VARCHAR(255) NOT NULL,
    customer VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    invoiceDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL
);
