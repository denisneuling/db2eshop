CREATE OR REPLACE FUNCTION turnover_sale()
	RETURNS trigger as $$
   	DECLARE
   		import RECORD;
   		aid integer;
   		price numeric(15,2);
   		turnover numeric(15,2);
   		now date;
  	BEGIN 
		aid=new.id;
		SELECT INTO 	price
						retailprice
		FROM article
		WHERE id=aid;
		turnover = new.count*price;
		now = current_date;
		
		LOOP
		insert into turnover(date, turnover)
	    VALUES(now, turnover);
	  	END LOOP;
	RETURN null;
END; $$
language 'plpgsql';

CREATE TRIGGER get_turnover_sale AFTER INSERT ON sale FOR EACH ROW EXECUTE PROCEDURE turnover_sale();