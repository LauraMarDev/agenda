-- Inserindo dados em Tipo
INSERT INTO TBL_TIPO (NAME) VALUES ('Família');
INSERT INTO TBL_TIPO (NAME) VALUES ('Trabalho');
INSERT INTO TBL_TIPO (NAME) VALUES ('Faculdade');
INSERT INTO TBL_TIPO (NAME) VALUES ('Amigos');

-- Inserindo dados em Contato
INSERT INTO TBL_CONTATO (NICKNAME, FULLNAME, OCCUPATION, BIRTHDAY, ADDRESS, EMAIL, NUMBER, TYPE_ID, FAVORITE) 
VALUES ('Alan', 'Alan Nogueira', 'Secretário', '1988-05-05', 'Itu', 'alan.nogueira@gmail.com', '(11)11111-1111', 2, FALSE);
INSERT INTO TBL_CONTATO (NICKNAME, FULLNAME, OCCUPATION, BIRTHDAY, ADDRESS, EMAIL, NUMBER, TYPE_ID, FAVORITE) 
VALUES ('Bruno', 'Bruno Araújo', 'Secretário', '1999-04-04', 'Itu', 'bruno.araujo@gmail.com', '(11)22222-2222', 2, FALSE);
INSERT INTO TBL_CONTATO (NICKNAME, FULLNAME, OCCUPATION, BIRTHDAY, ADDRESS, EMAIL, NUMBER, TYPE_ID, FAVORITE) 
VALUES ('Carina', 'Carina Oliveira', 'Bibliotecário', '2001-12-01', 'Sorocaba', 'carina.oliveira@gmail.com', '(11)33333-3333', 4, FALSE);
INSERT INTO TBL_CONTATO (NICKNAME, FULLNAME, OCCUPATION, BIRTHDAY, ADDRESS, EMAIL, NUMBER, TYPE_ID, FAVORITE) 
VALUES ('Daniela', 'Daniela Mendes', 'Cozinheira', '1983-07-28', 'São Paulo', 'daniela.mendes@gmail.com', '(11)44444-4444', 3, FALSE);