CREATE OR REPLACE FUNCTION booking_sale()
  RETURNS trigger as $$
  DECLARE
  	price double precision;   
   	turn double precision;
   	ident integer;
  BEGIN
	 	SELECT article_id INTO ident 
      		FROM sale
    		WHERE id=new.id;
	 	SELECT retailprice INTO price
	  		FROM article
	  		WHERE article.id=ident;
	 	turn:=new.count*price;
	INSERT INTO booking(id, date, amount, type)
    	VALUES(DEFAULT , current_date, turn, 'SALE');
RETURN NULL;
END;  $$
language 'plpgsql';


CREATE TRIGGER get_booking_sale_insert AFTER INSERT
        ON sale FOR EACH ROW
        EXECUTE PROCEDURE booking_sale();  
  
        
CREATE OR REPLACE FUNCTION booking_import()
  RETURNS trigger as $$
  DECLARE
  	price double precision;   
   	turn double precision;
   	ident integer;
  BEGIN
	    SELECT article_id INTO ident 
      		FROM import
    		WHERE id=new.id;
	 	SELECT purchaseprice INTO price
	  		FROM article
	  		WHERE article.id=ident;
	 	turn:=(new.count*price)*(-1);
	INSERT INTO booking(id, date, amount, type)
    	VALUES(DEFAULT , current_date, turn, 'IMPORT');
RETURN NULL;
END;  $$
language 'plpgsql';


CREATE TRIGGER get_booking_import_insert AFTER INSERT
        ON import FOR EACH ROW
        EXECUTE PROCEDURE booking_import(); 
            

CREATE OR REPLACE RULE booking_delete AS ON DELETE TO import DO INSERT INTO booking (id, amount, date, type) VALUES (nextval('booking_id_seq'), ((SELECT article.retailprice FROM article WHERE (article.id = old.article_id)) * (old.count)), ('now'), 'IMPORT');	


CREATE OR REPLACE RULE booking_delete AS ON DELETE TO sale DO INSERT INTO booking (id, amount, date, type) VALUES (nextval('booking_id_seq'), ((SELECT article.purchaseprice FROM article WHERE (article.id = old.article_id)) * (old.count) * (-1)), ('now'), 'SALE');


CREATE OR REPLACE FUNCTION call_turnover()
  RETURNS VOID as $$
  DECLARE
	book record;
	turn double precision;
	book2 record;
	turn2 double precision;
	barticle integer;
  BEGIN
	turn:=0;
	for book in SELECT amount FROM booking where date=CURRENT_DATE
	LOOP
		turn:=turn+(book.amount);
	END LOOP;
	RAISE NOTICE 'Daily Sales: %',turn;

	turn2:=0;
	for book2 in SELECT amount FROM booking where date > CURRENT_DATE - INTERVAL '12 months'
	LOOP
  	  turn2:=turn2+(book2.amount);
	END LOOP;
	RAISE NOTICE 'Year Sales: %',turn2;
END; $$
language 'plpgsql';
