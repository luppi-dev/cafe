CREATE TABLE user_ (
	id serial PRIMARY KEY,
	exposed_id UUID NOT NULL,
	name VARCHAR NOT NULL,
	email VARCHAR UNIQUE NOT NULL,
	hashed_password VARCHAR NOT NULL,
	salt_hash BYTEA NOT NULL,
	created_at DATE DEFAULT NOW()
);

CREATE TYPE financial_category AS ENUM (
	'trip',
	'investment',
	'family',
	'study',
	'leisure',
	'shopping',
	'asset',
	'rent',
	'bill',
	'grocery'
);

CREATE TABLE financial_goal_ (
	id serial PRIMARY KEY,
	exposed_id UUID NOT NULL,
	user_id INTEGER REFERENCES user_(id),
	name varchar NOT NULL,
	description VARCHAR,
	category financial_category NOT NULL,
	target_amount numeric(12, 2) NOT NULL,
	current_amount numeric(12, 2) DEFAULT 0,
	target_date date,
	created_at DATE DEFAULT NOW()
);

CREATE TABLE income_distribution_ (
    id SERIAL PRIMARY KEY,
    exposed_id UUID NOT NULL,
    user_id INTEGER REFERENCES user_(id),
    name VARCHAR NOT NULL,
    description VARCHAR,
    category financial_category NOT NULL,
    percentage numeric(5, 2) NOT NULL,
    created_at DATE DEFAULT NOW()
);

ALTER TABLE user_ ADD UNIQUE(exposed_id);
ALTER TABLE financial_goal_ ADD UNIQUE(exposed_id);
ALTER TABLE income_distribution_ ADD UNIQUE(exposed_id);