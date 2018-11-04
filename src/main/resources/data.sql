INSERT INTO users (id, username, password, first_name, last_name, role, uc, dc, um, dm) values (1, 'admin', 'a', 'Mladen', 'R', 'ADMIN', 'admin', null, null, null);

INSERT INTO homes (id, user_id, alias, street_name, street_number, home_number, city, uc, dc, um, dm) values (1, 1, 'My Home - 23', 'Generala Stefanika', '9', '23', 'Beograd', 'admin', null, null, null);
INSERT INTO homes (id, user_id, alias, street_name, street_number, home_number, city, uc, dc, um, dm) values (2, 1, 'My Home - 19', 'Generala Stefanika', '9', '19', 'Beograd', 'admin', null, null, null);

INSERT INTO product_groups (id, name, description, home_id, uc, dc, um, dm) values (1, 'Za kupatilo', 'Ovo je opis', 1, 1, null, null, null);