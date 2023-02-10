create table customer(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO customer(name) VALUES('Yushi');
INSERT INTO customer(name) VALUES('Mike');
INSERT INTO customer(name) VALUES('Jasen');
INSERT INTO customer(name) VALUES('Kevin');
INSERT INTO customer(name) VALUES('David');

create table transaction(
   id INT NOT NULL AUTO_INCREMENT,
   customer_id INT NOT NULL,
   date  DATETIME NOT NULL,
   amount INT NOT NULL, 
   PRIMARY KEY ( id ),
   FOREIGN KEY (customer_id) REFERENCES customer(id)
);

INSERT INTO transaction (customer_id,date,amount) VALUES(1, '2022-12-10', 120);
INSERT INTO transaction (customer_id,date,amount) VALUES(1, '2022-12-11', 45);
INSERT INTO transaction (customer_id,date,amount) VALUES(1, '2023-01-02', 56);
INSERT INTO transaction (customer_id,date,amount) VALUES(1, '2023-01-05', 112);
INSERT INTO transaction (customer_id,date,amount) VALUES(1, '2023-02-02', 230);
INSERT INTO transaction (customer_id,date,amount) VALUES(1, '2023-02-05', 76);

INSERT INTO transaction (customer_id,date,amount) VALUES(2, '2022-12-08', 33);
INSERT INTO transaction (customer_id,date,amount) VALUES(2, '2022-12-25', 178);
INSERT INTO transaction (customer_id,date,amount) VALUES(2, '2023-01-03', 90);
INSERT INTO transaction (customer_id,date,amount) VALUES(2, '2023-01-11', 160);
INSERT INTO transaction (customer_id,date,amount) VALUES(2, '2023-02-01', 200);
INSERT INTO transaction (customer_id,date,amount) VALUES(2, '2023-02-02', 49);

INSERT INTO transaction (customer_id,date,amount) VALUES(3, '2022-12-23', 90);
INSERT INTO transaction (customer_id,date,amount) VALUES(3, '2022-12-25', 200);
INSERT INTO transaction (customer_id,date,amount) VALUES(3, '2023-01-03', 80);
INSERT INTO transaction (customer_id,date,amount) VALUES(3, '2023-01-11', 130);
INSERT INTO transaction (customer_id,date,amount) VALUES(3, '2023-02-01', 119);
INSERT INTO transaction (customer_id,date,amount) VALUES(3, '2023-02-02', 32);

INSERT INTO transaction (customer_id,date,amount) VALUES(4, '2022-12-23', 21);
INSERT INTO transaction (customer_id,date,amount) VALUES(4, '2022-12-25', 120);
INSERT INTO transaction (customer_id,date,amount) VALUES(4, '2023-01-03', 92);
INSERT INTO transaction (customer_id,date,amount) VALUES(4, '2023-01-11', 178);
INSERT INTO transaction (customer_id,date,amount) VALUES(4, '2023-02-01', 169);
INSERT INTO transaction (customer_id,date,amount) VALUES(4, '2023-02-02', 17);