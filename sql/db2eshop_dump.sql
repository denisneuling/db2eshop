--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- Name: armor(bytea); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION armor(bytea) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_armor';


ALTER FUNCTION public.armor(bytea) OWNER TO admin;

--
-- Name: booking_import(); Type: FUNCTION; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE FUNCTION booking_import() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
  DECLARE
  	price double precision;   
   	turn double precision;
   	stornog double precision;
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
END;  $$;


ALTER FUNCTION public.booking_import() OWNER TO _s0538542__db2eshop_generic;

--
-- Name: booking_sale(); Type: FUNCTION; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE FUNCTION booking_sale() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
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
END;  $$;


ALTER FUNCTION public.booking_sale() OWNER TO _s0538542__db2eshop_generic;

--
-- Name: call_turnover(); Type: FUNCTION; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE FUNCTION call_turnover() RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE
book record;
turn double precision;
book2 record;
turn2 double precision;
barticle integer;
BEGIN
turn:=0;
for book in 
SELECT amount FROM booking where date=CURRENT_DATE
LOOP
	turn:=turn+(book.amount);
END LOOP;
RAISE NOTICE 'Daily Sales: %',turn;

turn2:=0;
for book2 in
SELECT amount FROM booking where date > CURRENT_DATE - INTERVAL '12 months'
LOOP
  turn2:=turn2+(book2.amount);
END LOOP;
RAISE NOTICE 'Year Sales: %',turn2;

END; $$;


ALTER FUNCTION public.call_turnover() OWNER TO _s0538542__db2eshop_generic;

--
-- Name: crypt(text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION crypt(text, text) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_crypt';


ALTER FUNCTION public.crypt(text, text) OWNER TO admin;

--
-- Name: dearmor(text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION dearmor(text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_dearmor';


ALTER FUNCTION public.dearmor(text) OWNER TO admin;

--
-- Name: decrypt(bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION decrypt(bytea, bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_decrypt';


ALTER FUNCTION public.decrypt(bytea, bytea, text) OWNER TO admin;

--
-- Name: decrypt_iv(bytea, bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION decrypt_iv(bytea, bytea, bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_decrypt_iv';


ALTER FUNCTION public.decrypt_iv(bytea, bytea, bytea, text) OWNER TO admin;

--
-- Name: digest(text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION digest(text, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_digest';


ALTER FUNCTION public.digest(text, text) OWNER TO admin;

--
-- Name: digest(bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION digest(bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_digest';


ALTER FUNCTION public.digest(bytea, text) OWNER TO admin;

--
-- Name: encrypt(bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION encrypt(bytea, bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_encrypt';


ALTER FUNCTION public.encrypt(bytea, bytea, text) OWNER TO admin;

--
-- Name: encrypt_iv(bytea, bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION encrypt_iv(bytea, bytea, bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_encrypt_iv';


ALTER FUNCTION public.encrypt_iv(bytea, bytea, bytea, text) OWNER TO admin;

--
-- Name: gen_random_bytes(integer); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION gen_random_bytes(integer) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pg_random_bytes';


ALTER FUNCTION public.gen_random_bytes(integer) OWNER TO admin;

--
-- Name: gen_salt(text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION gen_salt(text) RETURNS text
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pg_gen_salt';


ALTER FUNCTION public.gen_salt(text) OWNER TO admin;

--
-- Name: gen_salt(text, integer); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION gen_salt(text, integer) RETURNS text
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pg_gen_salt_rounds';


ALTER FUNCTION public.gen_salt(text, integer) OWNER TO admin;

--
-- Name: hmac(text, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION hmac(text, text, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_hmac';


ALTER FUNCTION public.hmac(text, text, text) OWNER TO admin;

--
-- Name: hmac(bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION hmac(bytea, bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pg_hmac';


ALTER FUNCTION public.hmac(bytea, bytea, text) OWNER TO admin;

--
-- Name: pgp_key_id(bytea); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_key_id(bytea) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_key_id_w';


ALTER FUNCTION public.pgp_key_id(bytea) OWNER TO admin;

--
-- Name: pgp_pub_decrypt(bytea, bytea); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_decrypt(bytea, bytea) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_decrypt_text';


ALTER FUNCTION public.pgp_pub_decrypt(bytea, bytea) OWNER TO admin;

--
-- Name: pgp_pub_decrypt(bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_decrypt(bytea, bytea, text) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_decrypt_text';


ALTER FUNCTION public.pgp_pub_decrypt(bytea, bytea, text) OWNER TO admin;

--
-- Name: pgp_pub_decrypt(bytea, bytea, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_decrypt(bytea, bytea, text, text) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_decrypt_text';


ALTER FUNCTION public.pgp_pub_decrypt(bytea, bytea, text, text) OWNER TO admin;

--
-- Name: pgp_pub_decrypt_bytea(bytea, bytea); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_decrypt_bytea(bytea, bytea) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_decrypt_bytea';


ALTER FUNCTION public.pgp_pub_decrypt_bytea(bytea, bytea) OWNER TO admin;

--
-- Name: pgp_pub_decrypt_bytea(bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_decrypt_bytea(bytea, bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_decrypt_bytea';


ALTER FUNCTION public.pgp_pub_decrypt_bytea(bytea, bytea, text) OWNER TO admin;

--
-- Name: pgp_pub_decrypt_bytea(bytea, bytea, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_decrypt_bytea(bytea, bytea, text, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_decrypt_bytea';


ALTER FUNCTION public.pgp_pub_decrypt_bytea(bytea, bytea, text, text) OWNER TO admin;

--
-- Name: pgp_pub_encrypt(text, bytea); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_encrypt(text, bytea) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_encrypt_text';


ALTER FUNCTION public.pgp_pub_encrypt(text, bytea) OWNER TO admin;

--
-- Name: pgp_pub_encrypt(text, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_encrypt(text, bytea, text) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_encrypt_text';


ALTER FUNCTION public.pgp_pub_encrypt(text, bytea, text) OWNER TO admin;

--
-- Name: pgp_pub_encrypt_bytea(bytea, bytea); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_encrypt_bytea(bytea, bytea) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_encrypt_bytea';


ALTER FUNCTION public.pgp_pub_encrypt_bytea(bytea, bytea) OWNER TO admin;

--
-- Name: pgp_pub_encrypt_bytea(bytea, bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_pub_encrypt_bytea(bytea, bytea, text) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_pub_encrypt_bytea';


ALTER FUNCTION public.pgp_pub_encrypt_bytea(bytea, bytea, text) OWNER TO admin;

--
-- Name: pgp_sym_decrypt(bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_decrypt(bytea, text) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_decrypt_text';


ALTER FUNCTION public.pgp_sym_decrypt(bytea, text) OWNER TO admin;

--
-- Name: pgp_sym_decrypt(bytea, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_decrypt(bytea, text, text) RETURNS text
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_decrypt_text';


ALTER FUNCTION public.pgp_sym_decrypt(bytea, text, text) OWNER TO admin;

--
-- Name: pgp_sym_decrypt_bytea(bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_decrypt_bytea(bytea, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_decrypt_bytea';


ALTER FUNCTION public.pgp_sym_decrypt_bytea(bytea, text) OWNER TO admin;

--
-- Name: pgp_sym_decrypt_bytea(bytea, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_decrypt_bytea(bytea, text, text) RETURNS bytea
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_decrypt_bytea';


ALTER FUNCTION public.pgp_sym_decrypt_bytea(bytea, text, text) OWNER TO admin;

--
-- Name: pgp_sym_encrypt(text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_encrypt(text, text) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_encrypt_text';


ALTER FUNCTION public.pgp_sym_encrypt(text, text) OWNER TO admin;

--
-- Name: pgp_sym_encrypt(text, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_encrypt(text, text, text) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_encrypt_text';


ALTER FUNCTION public.pgp_sym_encrypt(text, text, text) OWNER TO admin;

--
-- Name: pgp_sym_encrypt_bytea(bytea, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_encrypt_bytea(bytea, text) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_encrypt_bytea';


ALTER FUNCTION public.pgp_sym_encrypt_bytea(bytea, text) OWNER TO admin;

--
-- Name: pgp_sym_encrypt_bytea(bytea, text, text); Type: FUNCTION; Schema: public; Owner: admin
--

CREATE FUNCTION pgp_sym_encrypt_bytea(bytea, text, text) RETURNS bytea
    LANGUAGE c STRICT
    AS '$libdir/pgcrypto', 'pgp_sym_encrypt_bytea';


ALTER FUNCTION public.pgp_sym_encrypt_bytea(bytea, text, text) OWNER TO admin;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: article; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE article (
    id bigint NOT NULL,
    description text NOT NULL,
    name character varying(255) NOT NULL,
    purchaseprice double precision NOT NULL,
    retailprice double precision NOT NULL,
    articletype_id bigint,
    CONSTRAINT article_purchaseprice_check CHECK ((purchaseprice >= (0)::double precision)),
    CONSTRAINT article_retailprice_check CHECK ((retailprice >= (0)::double precision))
);


ALTER TABLE public.article OWNER TO _s0538542__db2eshop_generic;

--
-- Name: article_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.article_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: article_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE article_id_seq OWNED BY article.id;


--
-- Name: articletype; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE articletype (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.articletype OWNER TO _s0538542__db2eshop_generic;

--
-- Name: articletype_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE articletype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.articletype_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: articletype_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE articletype_id_seq OWNED BY articletype.id;


--
-- Name: booking; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE booking (
    id bigint NOT NULL,
    amount double precision NOT NULL,
    date date NOT NULL,
    type character varying(255) NOT NULL
);


ALTER TABLE public.booking OWNER TO _s0538542__db2eshop_generic;

--
-- Name: booking_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE booking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.booking_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE booking_id_seq OWNED BY booking.id;


--
-- Name: customer; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE customer (
    id bigint NOT NULL,
    birthday date NOT NULL,
    city character varying(255) NOT NULL,
    prename character varying(255) NOT NULL,
    street character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    telephone character varying(255) NOT NULL,
    zipcode bigint NOT NULL,
    CONSTRAINT customer_zipcode_check CHECK ((zipcode >= 0))
);


ALTER TABLE public.customer OWNER TO _s0538542__db2eshop_generic;

--
-- Name: customer_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE customer_id_seq OWNED BY customer.id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE employee (
    id bigint NOT NULL,
    prename character varying(255) NOT NULL,
    surname character varying(255) NOT NULL
);


ALTER TABLE public.employee OWNER TO _s0538542__db2eshop_generic;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;


--
-- Name: import; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE import (
    id bigint NOT NULL,
    count bigint NOT NULL,
    date date NOT NULL,
    article_id bigint NOT NULL,
    employee_id bigint NOT NULL,
    supplier_id bigint NOT NULL,
    CONSTRAINT import_count_check CHECK ((count >= 0))
);


ALTER TABLE public.import OWNER TO _s0538542__db2eshop_generic;

--
-- Name: import_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE import_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.import_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: import_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE import_id_seq OWNED BY import.id;


--
-- Name: sale; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE sale (
    id bigint NOT NULL,
    count bigint NOT NULL,
    date date NOT NULL,
    article_id bigint NOT NULL,
    customer_id bigint NOT NULL,
    shipping_id bigint,
    CONSTRAINT sale_count_check CHECK ((count >= 0))
);


ALTER TABLE public.sale OWNER TO _s0538542__db2eshop_generic;

--
-- Name: sale_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE sale_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sale_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE sale_id_seq OWNED BY sale.id;


--
-- Name: shipping; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE shipping (
    id bigint NOT NULL,
    city character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    telephone character varying(255) NOT NULL,
    zipcode bigint NOT NULL,
    CONSTRAINT shipping_zipcode_check CHECK ((zipcode >= 0))
);


ALTER TABLE public.shipping OWNER TO _s0538542__db2eshop_generic;

--
-- Name: shipping_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE shipping_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.shipping_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: shipping_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE shipping_id_seq OWNED BY shipping.id;


--
-- Name: supplier; Type: TABLE; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

CREATE TABLE supplier (
    id bigint NOT NULL,
    city character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    telephone character varying(255) NOT NULL,
    zipcode bigint NOT NULL,
    CONSTRAINT supplier_zipcode_check CHECK ((zipcode >= 0))
);


ALTER TABLE public.supplier OWNER TO _s0538542__db2eshop_generic;

--
-- Name: supplier_id_seq; Type: SEQUENCE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE SEQUENCE supplier_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.supplier_id_seq OWNER TO _s0538542__db2eshop_generic;

--
-- Name: supplier_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER SEQUENCE supplier_id_seq OWNED BY supplier.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY article ALTER COLUMN id SET DEFAULT nextval('article_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY articletype ALTER COLUMN id SET DEFAULT nextval('articletype_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY booking ALTER COLUMN id SET DEFAULT nextval('booking_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY customer ALTER COLUMN id SET DEFAULT nextval('customer_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY import ALTER COLUMN id SET DEFAULT nextval('import_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY sale ALTER COLUMN id SET DEFAULT nextval('sale_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY shipping ALTER COLUMN id SET DEFAULT nextval('shipping_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY supplier ALTER COLUMN id SET DEFAULT nextval('supplier_id_seq'::regclass);


--
-- Data for Name: article; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY article (id, description, name, purchaseprice, retailprice, articletype_id) FROM stdin;
5	vero eos sed et sit quis dolor dolor consetetur Nam veniam odio imperdiet eum tempor Lorem liber At vulputate in vero justo duis invidunt Stet dolor est sit esse minim consetetur et ut nulla dolor vero enim odio Stet rebum ipsum ut labore congue odio no.	Scrambled eggs	2.83000000000000007	0.82999999999999996	1
6	amet dolore vel feugiat no accusam no nulla consetetur diam odio voluptua erat dolor erat At dolore Lorem invidunt no sed labore nulla sadipscing in ipsum sit assum congue justo gubergren diam ut diam euismod suscipit et clita et facilisis blandit cum l.	Donuts	3.16000000000000014	1.15999999999999992	2
7	Lorem tation vero et ullamcorper nonumy enim exerci nostrud diam voluptua at kasd clita nisl feugiat ipsum dolores magna nonummy eirmod nibh exerci ut velit ea lobortis dolores et invidunt magna dolores dolore sed sit mazim soluta Lorem justo nonummy At.	slice of ham	5.75999999999999979	3.75999999999999979	2
8	cum quis Lorem iriure accusam kasd ea justo labore rebum congue ut eos clita tation clita enim dolor Ut erat nulla elitr diam velit cum velit consetetur lobortis Lorem sanctus elitr iriure vero et clita diam consetetur magna illum tempor nulla hendrerit.	Ham	8.0600000000000005	6.05999999999999961	1
9	minim dolore sed gubergren amet dolor velit Duis tation duo et amet erat eum Lorem erat ipsum elitr et veniam sit sadipscing eu vero elitr magna in sit ipsum soluta kasd sea diam eros kasd sea nonumy in accusam diam vel veniam dolor nisl vel rebum ipsum.	Ginger beer	8.50999999999999979	6.50999999999999979	2
10	nonumy diam at est sanctus takimata dignissim aliquyam sadipscing Duis voluptua sadipscing ipsum magna kasd et invidunt sed sadipscing velit delenit ad invidunt iriure voluptua dolore et congue vero dolores justo At sanctus sit clita tempor kasd diam du.	Venison steaks	4.83000000000000007	2.83000000000000007	1
11	dolores At odio adipiscing nobis Stet liber kasd ipsum et invidunt sadipscing.	Meatloaf	2.79999999999999982	0.800000000000000044	2
12	rebum et dolores hendrerit at imperdiet amet clita zzril placerat nostrud clita diam nulla nonumy qui nisl dolor consequat aliquip eirmod et magna diam magna quis feugait et sea nonumy et ipsum sed duis nulla elit volutpat nonumy Lorem in ipsum illum ve.	Chocolate peanut butter pie	9.32000000000000028	7.32000000000000028	2
13	diam iriure diam At vel illum accusam adipiscing nisl euismod erat wisi dolor est augue amet et clita elitr dolor invidunt placerat justo magna illum clita ut delenit dolor at vero illum voluptua gubergren nonumy dignissim nisl sed Nam diam diam facilis.	High school sandwich	4.03000000000000025	2.0299999999999998	1
14	eos ullamcorper exerci ipsum clita gubergren illum in et consectetuer delenit at ut et labore takimata sadipscing sit diam tincidunt tincidunt nonumy eirmod dolore eu eirmod magna consequat nulla dolores invidunt justo sed et dolore consequat eirmod gub.	Peanuts	10.3499999999999996	8.34999999999999964	1
15	eos ea sed consetetur kasd dolor velit sea no Stet imperdiet consequat elit esse nonumy dolor nonumy sit labore magna sed blandit blandit et eirmod Stet aliquip sit labore molestie ipsum ipsum feugiat elitr et dolor te velit exerci feugiat Lorem nulla a.	Milk	11.3599999999999994	9.35999999999999943	1
16	takimata sanctus illum sed volutpat adipiscing Lorem eum tempor invidunt ut illum amet suscipit dolor nonumy aliquip vel nostrud diam et velit velit dolore in minim takimata suscipit Lorem sea et amet ipsum Lorem dolore magna duo gubergren dolor in cum .	Popcorn	4.41000000000000014	2.41000000000000014	2
17	eirmod Lorem labore aliquyam sanctus molestie et sadipscing sit ipsum dolore doming eos justo voluptua dolore augue Duis in justo aliquyam nonummy ut accusam sadipscing illum amet vero nulla sit delenit vero aliquam aliquyam eos dolor dolor erat elitr k.	Apples	3.85999999999999988	1.8600000000000001	2
18	sadipscing dolor voluptua clita et dolore sed Lorem consetetur takimata feugiat ut ipsum dolore ut et et consequat congue dolor sed Stet tempor justo elitr dignissim laoreet et ipsum iusto nonumy elitr nonumy sadipscing sanctus sadipscing elitr tincidun.	Turkey sandwich, whole wheat, lettuce, dollop of mayonnaise	3.33999999999999986	1.34000000000000008	2
19	laoreet amet iriure molestie takimata magna vero diam dolore dolores ad nulla ipsum aliquyam diam accumsan quod.	Huckleberry pie, heated, ice cream on the side	8.78999999999999915	6.79000000000000004	2
20	aliquam facer ipsum ea sadipscing Stet sed facilisi Lorem clita accusam Stet amet vel et justo augue sed iriure lobortis aliquip autem vulputate elitr justo et ea eleifend liber augue tempor duo duo justo justo vero nonummy odio vel vel eos dolor illum .	Cherry coke	6.87999999999999989	4.87999999999999989	1
21	gubergren clita dolores Lorem At et magna nulla magna nulla takimata ipsum sit invidunt assum sea eros sea in et Lorem ea accusam Stet ut tempor enim ea Nam sanctus At Stet At amet ipsum sed enim sed liber sed takimata dolore in rebum eos justo dolor ac.	Rare steak	7.90000000000000036	5.90000000000000036	1
22	laoreet justo Stet est erat Ut odio elitr, amet ipsum erat nonummy tincidunt et dolores dolore diam facilisis Lorem accumsan no dolor ex gubergren accusam nonumy Lorem ut feugiat Lorem ea accusam voluptua ut id quod tation amet ea nibh Lorem sea commodo.	Mound of sweet breads, saut�ed with chestnuts and Canadian bacon	3.20000000000000018	1.19999999999999996	2
23	elitr duo commodo justo sit voluptua consetetur sanctus eu exerci volutpat vero praesent et exerci dolor dignissim nonummy et invidunt At accusam accusam et eirmod gubergren clita ipsum gubergren ea magna dolores erat vel et erat eu hendrerit erat conse.	Chamomile tea	11.1400000000000006	9.14000000000000057	1
24	sanctus clita ullamcorper diam in consetetur clita justo dolor Stet invidunt sanctus exerci ex ut ut vero tempor justo labore eros magna sit nonumy consetetur tempor elitr et adipiscing liber nonumy takimata zzril Lorem sit ea ea clita voluptua dolores .	Grapefruit juice, just as long as those grapefruits are freshly squeezed	8.88000000000000078	6.87999999999999989	2
25	eum ipsum iriure hendrerit clita nulla kasd adipiscing tincidunt duo magna aliquam eos sed Ut consetetur adipiscing nulla et sea invidunt diam ipsum invidunt et et congue gubergren erat sed rebum esse ad in kasd ut lobortis eirmod elitr esse mazim dolor.	Gruel	11.9399999999999995	9.9399999999999995	2
26	et nonummy possim ad eos ipsum dolore amet nostrud ut ea Lorem nisl sed accusam dolore accusam et sanctus accumsan elitr nobis eos lobortis exerci esse liber consequat ex hendrerit et option eirmod qui kasd Lorem hendrerit aliquam kasd amet voluptua ill.	Local mushrooms	9.39000000000000057	7.38999999999999968	1
27	erat Ut dolor elitr dolore sed ut clita ut elitr Stet amet et nonumy lobortis eirmod vel delenit praesent tincidunt augue amet iriure kasd rebum eos dolore dolores diam nisl kasd vero zzril in At at aliquyam gubergren wisi ex eos vel amet amet placerat .	Weenie roast	4.71999999999999975	2.7200000000000002	1
28	exerci in accusam ullamcorper tation eos no vero diam Ut sit et vero rebum nihil ea magna qui dolore blandit dolor ad dolore et blandit vero accusam et At et invidunt velit clita magna kasd aliquam sit augue facilisi dolore aliquyam sed kasd ea kasd ver.	Deviled eggs	3.41999999999999993	1.41999999999999993	1
29	nulla duo ipsum voluptua invidunt in invidunt diam takimata et feugiat nibh velit aliquip vel rebum no clita illum aliquyam elitr clita commodo Ut accusam dolore Stet dolore Lorem adipiscing eum ea nonumy et ut et sanctus te eirmod sea et diam labore co.	Coconut	6.20999999999999996	4.20999999999999996	2
31	amet invidunt invidunt diam erat Lorem justo ut consectetuer euismod autem sadipscing in aliquyam velit kasd dolore et vero dolor praesent rebum labore iriure tempor esse takimata sit te euismod et aliquip kasd in dolore dolor consetetur no sit no dolor.	bacon super crispy, almost burned, cremated	9.1899999999999995	7.19000000000000039	2
32	nonumy diam Lorem consectetuer At Lorem et sea magna veniam labore amet quis justo at vero sea consectetuer ex et et eirmod kasd autem et zzril nonummy nonumy minim ipsum eos ut nihil diam dolores sadipscing amet eirmod no sanctus erat consectetuer erat.	$1000 poker chip from One-Eyed Jacks	7.40000000000000036	5.40000000000000036	1
33	magna wisi congue sadipscing quis eum sed voluptua et sanctus congue dolor amet augue sanctus justo possim accumsan amet diam eirmod duo ad nulla sadipscing magna tation no eum ea ex autem Stet Lorem aliquip magna kasd dolores tincidunt molestie dolore .	Sparkling cider	7.41000000000000014	5.41000000000000014	2
35	dolor rebum vero dolore suscipit ea amet amet voluptua tation adipiscing diam tincidunt et adipiscing et autem amet in voluptua delenit est ea invidunt euismod takimata et erat rebum labore dolor Stet labore sanctus sit At sit euismod delenit dolore eli.	Black coffee (black as midnight on a moonless night)	7.76999999999999957	5.76999999999999957	1
36	diam minim sed consetetur et aliquyam ut consetetur consetetur accusam ipsum vero feugait aliquip sadipscing rebum duo suscipit duo feugait consequat ipsum aliquyam cum ipsum clita ea dolores ad amet et dolore et et minim diam clita dolore et ullamcorpe.	Double scotch on the rocks (two of them)	7.08999999999999986	5.08999999999999986	2
37	suscipit consetetur dolores voluptua erat est laoreet consectetuer ipsum amet elitr eum magna diam et sit At dolore sit zzril diam At ea facilisis Lorem et elitr dolor facilisi dolore eum justo accumsan aliquip sea consectetuer duo nostrud feugait lupta.	A cherry	5.63999999999999968	3.64000000000000012	1
39	erat illum vulputate labore Consetetur sit erat nulla delenit aliquyam labore ea at justo odio erat eos ut sea dolore sit Lorem et magna ea dolores et gubergren Lorem dolor nonumy dolore magna et aliquam clita ipsum sadipscing ut consequat sit vulputate.	Leg of lamb (crush some garlic; fresh mint)	9.24000000000000021	7.24000000000000021	1
40	sed magna et sit gubergren eros kasd ullamcorper duo diam in consequat Ut erat nonummy cum ut sit consequat justo vero Lorem labore odio diam sit Lorem ut no vel dignissim sea sed vero ea ipsum nonumy elitr duo ea ea eos et dolores duo accusam magna lab.	One smoked cheese pig	7.01999999999999957	5.01999999999999957	1
41	sanctus consectetuer sed et nulla sed et amet veniam takimata et ipsum dolores Lorem clita ut Stet sed aliquam eleifend et dolore lobortis vel amet invidunt iusto elitr et et ea hendrerit possim vero ea dolor dolore aliquyam dolore in luptatum ea sed ju.	Three berry pie	11.7300000000000004	9.73000000000000043	1
43	voluptua sed gubergren sit clita rebum kasd suscipit vero feugiat imperdiet ullamcorper voluptua ad dolor nostrud ea id gubergren sea velit augue ut amet Nam molestie.	Red herring	8.3100000000000005	6.30999999999999961	2
44	dolor et ipsum vero at in nonumy sit sanctus et sanctus autem clita qui suscipit takimata ipsum kasd sanctus eos at suscipit Stet takimata et sit sit sit ipsum nobis eum tempor justo ipsum ea clita dolores nulla mazim rebum nostrud dolore at aliquip est.	Omelet (white veal sausage, morel mushrooms)	5.36000000000000032	3.35999999999999988	2
45	eirmod amet diam duo aliquip est sit sed justo Stet amet aliquyam iriure eos id diam amet euismod enim et et amet no vero te At kasd eros sit dolor invidunt consequat facilisi labore eu sit sanctus labore in et ipsum aliquip Lorem odio vero ipsum no sed.	Tuna fish, whole wheat	10.6999999999999993	8.69999999999999929	1
46	dolore gubergren At consetetur kasd voluptua dolore ipsum et eum ex hendrerit duo gubergren dolore consetetur facilisis ea delenit kasd takimata magna feugiat commodo diam ullamcorper magna ea accusam autem molestie Duis sadipscing exerci et suscipit eu.	Diet lasagna	10.6600000000000001	8.66000000000000014	1
47	diam et ad tempor ipsum no wisi doming dolore nulla kasd nulla erat ut vel gubergren amet justo ut molestie sed iriure vero vero sed no Stet consetetur et consequat et amet quod erat erat elitr erat vel no nonumy luptatum sed Stet sit iusto blandit temp.	A couple of bottles	5.25	3.25	2
48	amet et vulputate esse eos At clita at sit iusto hendrerit dolores et dolor dolore molestie est diam nonumy et iusto sit consequat nibh tation duo vel kasd sit elit magna.	Baguettes with brie and butter	8.89000000000000057	6.88999999999999968	1
50	vero cum Lorem no luptatum aliquyam dolore dolore zzril diam magna consetetur facilisi amet Nam consectetuer Stet diam magna mazim gubergren dolor sed Lorem Lorem ea rebum consetetur elit dolor sanctus nonummy magna nibh dolore rebum erat magna Stet tem.	Cocaine	6.92999999999999972	4.92999999999999972	1
51	sit nisl ut Stet dolor erat consetetur sadipscing ad est invidunt sed magna et ut amet vulputate sed dolor elitr liber erat amet eros consequat laoreet takimata aliquyam sit et no sit ex tempor no sanctus diam duo takimata amet ea wisi et feugait aliquy.	Beer	11.0099999999999998	9.00999999999999979	1
52	takimata te sadipscing commodo nibh et At gubergren vulputate iusto et diam amet amet Lorem sed volutpat Ut dolore dolore ipsum erat nonummy luptatum Lorem nulla consetetur amet sanctus erat tempor ut et accumsan rebum augue dolore elitr invidunt ex tem.	Jello	7.25	5.25	2
53	labore aliquip sanctus iusto consequat amet blandit elit dolor at ea vero magna clita dignissim tempor diam vero et eos nisl option eos iriure elitr, sit minim Lorem ea consetetur ut sit velit luptatum elitr, dolor Stet at facilisi esse justo at sed Ste.	Waldorf salad	6.92999999999999972	4.92999999999999972	2
\.


--
-- Name: article_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('article_id_seq', 54, true);


--
-- Data for Name: articletype; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY articletype (id, name) FROM stdin;
1	Food
2	Drink
3	Goodie
\.


--
-- Name: articletype_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('articletype_id_seq', 3, true);


--
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY booking (id, amount, date, type) FROM stdin;
1	-183.799999999999983	2013-01-24	IMPORT
2	-124.200000000000003	2013-01-24	IMPORT
3	-64	2013-01-24	IMPORT
4	-130.409999999999997	2013-01-24	IMPORT
5	-184.340000000000003	2013-01-24	IMPORT
6	-210.25	2013-01-24	IMPORT
7	-231.140000000000015	2013-01-24	IMPORT
8	-92.3400000000000034	2013-01-24	IMPORT
9	-202.019999999999982	2013-01-24	IMPORT
10	-117.920000000000002	2013-01-24	IMPORT
11	-202.019999999999982	2013-01-24	IMPORT
12	-199.439999999999998	2013-01-24	IMPORT
13	-82.0799999999999983	2013-01-24	IMPORT
14	-104.780000000000001	2013-01-24	IMPORT
15	-249.919999999999987	2013-01-24	IMPORT
16	-209.789999999999992	2013-01-24	IMPORT
17	-166.319999999999993	2013-01-24	IMPORT
18	-213.360000000000014	2013-01-24	IMPORT
19	-72.7999999999999972	2013-01-24	IMPORT
20	-245.080000000000013	2013-01-24	IMPORT
21	-103.839999999999989	2013-01-24	IMPORT
22	-124.079999999999998	2013-01-24	IMPORT
23	-104.219999999999999	2013-01-24	IMPORT
24	-186.689999999999998	2013-01-24	IMPORT
25	-96.5	2013-01-24	IMPORT
26	-284	2013-01-24	IMPORT
27	-288.899999999999977	2013-01-24	IMPORT
28	-135.240000000000009	2013-01-24	IMPORT
29	-195.580000000000013	2013-01-24	IMPORT
30	-237.329999999999984	2013-01-24	IMPORT
92	151.439999999999998	2013-01-24	IMPORT
154	26.0399999999999991	2013-01-24	SALE
155	39.759999999999998	2013-01-24	SALE
156	11.5399999999999991	2013-01-24	SALE
157	53.1000000000000014	2013-01-24	SALE
158	34.509999999999998	2013-01-24	SALE
159	54.8400000000000034	2013-01-24	SALE
160	5.41000000000000014	2013-01-24	SALE
161	61.1099999999999994	2013-01-24	SALE
162	17.3200000000000003	2013-01-24	SALE
163	17.3099999999999987	2013-01-24	SALE
164	14.4800000000000004	2013-01-24	SALE
165	7.32000000000000028	2013-01-24	SALE
166	34.509999999999998	2013-01-24	SALE
167	13.0199999999999996	2013-01-24	SALE
168	8.11999999999999922	2013-01-24	SALE
169	16.25	2013-01-24	SALE
170	16.2399999999999984	2013-01-24	SALE
171	46.7999999999999972	2013-01-24	SALE
172	29.2800000000000011	2013-01-24	SALE
173	17.7000000000000028	2013-01-24	SALE
174	43.9200000000000017	2013-01-24	SALE
175	2.40000000000000036	2013-01-24	SALE
176	65.8799999999999955	2013-01-24	SALE
177	64.710000000000008	2013-01-24	SALE
178	57.9200000000000017	2013-01-24	SALE
179	8.40000000000000036	2013-01-24	SALE
180	50.1999999999999957	2013-01-24	SALE
181	68.1099999999999994	2013-01-24	SALE
182	19.5199999999999996	2013-01-24	SALE
183	18.9299999999999997	2013-01-24	SALE
\.


--
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('booking_id_seq', 183, true);


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY customer (id, birthday, city, prename, street, surname, telephone, zipcode) FROM stdin;
1	1962-07-22	BILLINGS	Lukas	PHEASANT LN 143	Greenbank	70630 32818	10701
2	1978-07-17	LITTLE ROCK	Marah	SHADY OAKS RD 42	Telfar	72202 58687	10486
3	1981-07-21	SPRINGFIELD	Tyler	RAKES RD 187	Hartwell	34882 3287	70646
4	1967-02-23	JACKSON	Stefanie	ABBEVILLE CT 197	Manners	42061 20885	35112
5	1982-06-30	HONOLULU	Leah	MIRAMIR LN 61	Lee	12670 13314	31802
6	1950-12-14	FLAGSTAFF	Elena	LOVING ST 84	Emerson	77885 53845	67237
7	1985-04-18	MONTGOMERY	Helene	HAGA ST 77	Decew	80222 20387	42057
8	1950-01-03	SHREVEPORT	Finn	CAREY PITZER CT 120	Burkhalter	34083 80768	20213
9	1970-01-28	COLUMBUS	Antonio	MINNESOTA AV 85	Wardup	32158 73536	23030
10	1948-06-09	SAVANNAH	Marc	COWBOY WAY 90	Goodyear	8834 17423	3543
\.


--
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('customer_id_seq', 10, true);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY employee (id, prename, surname) FROM stdin;
1	Finn	Hill
2	Lukas	Clarke
3	Cheyenne	Grand
4	Nadine	Burdick
5	Kristin	Edmundson
6	Alexander	O'dell
7	Noel	Haining
8	Isabella	Starling
9	Frank	Grayston
10	Kevin	Walker
\.


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('employee_id_seq', 10, true);


--
-- Data for Name: import; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY import (id, count, date, article_id, employee_id, supplier_id) FROM stdin;
1	20	1956-07-10	31	5	5
2	20	1949-09-19	29	7	2
3	20	1993-11-21	22	9	5
4	27	1985-06-28	10	6	4
5	26	1947-04-05	36	4	2
6	29	1990-01-05	52	4	2
7	26	1991-11-10	48	10	5
8	27	1959-09-27	28	3	2
9	26	1953-11-02	35	6	7
10	22	1982-06-25	44	7	4
11	26	1987-06-03	35	4	7
14	26	1970-04-27	13	3	4
15	22	1980-10-02	15	4	7
16	27	1953-11-18	35	5	7
17	24	1959-11-28	53	8	7
18	24	1980-06-15	48	7	7
19	26	1984-07-22	11	4	2
20	22	1963-06-06	23	5	5
21	22	1955-12-31	27	3	2
22	22	1971-09-27	37	5	5
23	27	1954-06-20	17	9	2
24	21	1990-12-22	48	4	4
25	25	1976-10-31	17	7	7
26	25	1970-02-12	15	6	2
27	27	1960-03-20	45	5	2
28	28	1952-04-14	10	10	5
29	22	1980-09-16	48	6	2
30	27	1984-11-29	19	3	7
13	24	1970-07-06	28	8	7
\.


--
-- Name: import_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('import_id_seq', 30, true);


--
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY sale (id, count, date, article_id, customer_id, shipping_id) FROM stdin;
123	4	1983-05-09	9	7	9
124	4	1964-05-06	25	6	9
125	2	1955-09-14	35	8	3
126	9	1975-01-13	21	3	5
127	7	1948-10-26	50	6	9
128	6	1962-12-06	23	7	6
129	1	1981-05-11	33	7	6
130	9	1991-02-22	19	9	6
131	2	1973-03-14	46	8	9
132	3	1977-02-14	35	7	6
133	2	1984-11-15	39	9	5
134	1	1989-01-18	12	2	9
135	7	1979-10-12	50	6	9
136	2	1993-06-27	9	9	6
137	4	1958-06-03	13	7	5
138	5	1949-04-01	47	10	6
139	8	1979-11-26	13	9	5
140	5	1989-05-20	15	10	9
141	6	1969-06-26	20	7	3
142	3	1976-10-18	21	8	6
143	9	1974-03-03	20	10	3
144	3	1954-02-01	11	10	9
145	9	1952-01-14	12	5	3
146	9	1984-03-30	31	4	6
147	8	1965-11-15	39	9	3
148	7	1979-02-08	22	8	9
149	10	1960-12-16	40	7	5
150	7	1990-04-11	41	6	3
151	4	1973-05-27	20	10	9
152	3	1951-10-10	43	9	3
\.


--
-- Name: sale_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('sale_id_seq', 152, true);


--
-- Data for Name: shipping; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY shipping (id, city, name, telephone, zipcode) FROM stdin;
1	PADUCAH KY	GLS	63188 80745	27172
3	PROVIDENCE	UPS	46376 51827	40035
5	INDIANAPOLIS	Hermes	25081 20253	88063
6	PADUCAH KY	Deutsche Post	25557 12531	56242
9	ATLANTA	DPD	83725 37074	37025
\.


--
-- Name: shipping_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('shipping_id_seq', 10, true);


--
-- Data for Name: supplier; Type: TABLE DATA; Schema: public; Owner: _s0538542__db2eshop_generic
--

COPY supplier (id, city, name, telephone, zipcode) FROM stdin;
1	CHICAGO	Hermes	45220 24183	2364
2	WICHITA	DHL	54786 14345	10138
4	GREENSBORO-WNSTN-SALM	DPD	38356 51652	47817
5	NEW ORLEANS	Deutsche Post	2208 56608	61731
7	SAN ANTONIO	GLS	54887 77360	70671
\.


--
-- Name: supplier_id_seq; Type: SEQUENCE SET; Schema: public; Owner: _s0538542__db2eshop_generic
--

SELECT pg_catalog.setval('supplier_id_seq', 10, true);


--
-- Name: article_name_key; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY article
    ADD CONSTRAINT article_name_key UNIQUE (name);


--
-- Name: article_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY article
    ADD CONSTRAINT article_pkey PRIMARY KEY (id);


--
-- Name: articletype_name_key; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY articletype
    ADD CONSTRAINT articletype_name_key UNIQUE (name);


--
-- Name: articletype_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY articletype
    ADD CONSTRAINT articletype_pkey PRIMARY KEY (id);


--
-- Name: booking_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);


--
-- Name: customer_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: import_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY import
    ADD CONSTRAINT import_pkey PRIMARY KEY (id);


--
-- Name: sale_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (id);


--
-- Name: shipping_name_key; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY shipping
    ADD CONSTRAINT shipping_name_key UNIQUE (name);


--
-- Name: shipping_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY shipping
    ADD CONSTRAINT shipping_pkey PRIMARY KEY (id);


--
-- Name: supplier_name_key; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY supplier
    ADD CONSTRAINT supplier_name_key UNIQUE (name);


--
-- Name: supplier_pkey; Type: CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic; Tablespace: 
--

ALTER TABLE ONLY supplier
    ADD CONSTRAINT supplier_pkey PRIMARY KEY (id);


--
-- Name: booking_delete; Type: RULE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE RULE booking_delete AS ON DELETE TO import DO INSERT INTO booking (id, amount, date, type) VALUES (nextval('booking_id_seq'::regclass), ((SELECT article.retailprice FROM article WHERE (article.id = old.article_id)) * (old.count)::double precision), '2013-01-24'::date, 'IMPORT'::character varying);


--
-- Name: booking_delete; Type: RULE; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE RULE booking_delete AS ON DELETE TO sale DO INSERT INTO booking (id, amount, date, type) VALUES (nextval('booking_id_seq'::regclass), (((SELECT article.purchaseprice FROM article WHERE (article.id = old.article_id)) * (old.count)::double precision) * ((-1))::double precision), '2013-01-24'::date, 'SALE'::character varying);


--
-- Name: get_booking_import_insert; Type: TRIGGER; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE TRIGGER get_booking_import_insert AFTER INSERT ON import FOR EACH ROW EXECUTE PROCEDURE booking_import();


--
-- Name: get_booking_sale_insert; Type: TRIGGER; Schema: public; Owner: _s0538542__db2eshop_generic
--

CREATE TRIGGER get_booking_sale_insert AFTER INSERT ON sale FOR EACH ROW EXECUTE PROCEDURE booking_sale();


--
-- Name: fk27346717ad175b; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT fk27346717ad175b FOREIGN KEY (article_id) REFERENCES article(id);


--
-- Name: fk27346718f245b9; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT fk27346718f245b9 FOREIGN KEY (shipping_id) REFERENCES shipping(id);


--
-- Name: fk273467b0ecd7b9; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT fk273467b0ecd7b9 FOREIGN KEY (customer_id) REFERENCES customer(id);


--
-- Name: fk379164d6357cd0bb; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY article
    ADD CONSTRAINT fk379164d6357cd0bb FOREIGN KEY (articletype_id) REFERENCES articletype(id);


--
-- Name: fk82c65fc517ad175b; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY import
    ADD CONSTRAINT fk82c65fc517ad175b FOREIGN KEY (article_id) REFERENCES article(id);


--
-- Name: fk82c65fc57409a5b9; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY import
    ADD CONSTRAINT fk82c65fc57409a5b9 FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- Name: fk82c65fc5761a68f9; Type: FK CONSTRAINT; Schema: public; Owner: _s0538542__db2eshop_generic
--

ALTER TABLE ONLY import
    ADD CONSTRAINT fk82c65fc5761a68f9 FOREIGN KEY (supplier_id) REFERENCES supplier(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

