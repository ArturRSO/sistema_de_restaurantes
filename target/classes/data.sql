insert into RESTAURANTES_MODEL values(1,'Restaurante Um');
insert into RESTAURANTES_MODEL values(2,'Restaurante Dois');
insert into RESTAURANTES_MODEL values(3,'Restaurante Tres');

insert into PRATOS_MODEL values(1, 'Prato 1', 10.00, (select id from RESTAURANTES_MODEL where nome = 'Restaurante Um'));
insert into PRATOS_MODEL values(2, 'Prato 2', 10.00, (select id from RESTAURANTES_MODEL where nome = 'Restaurante Dois'));
insert into PRATOS_MODEL values(3, 'Prato 3', 10.00, (select id from RESTAURANTES_MODEL where nome = 'Restaurante Tres'));