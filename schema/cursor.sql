begin;
DECLARE
cursor_product cursor for select * from products;
FETCH 10 FROM cursor_product;
FETCH FROM cursor_product;
FETCH FROM cursor_product;
MOVE FORWARD 2 FROM cursor_products;
ROLLBACK;