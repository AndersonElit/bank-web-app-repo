
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE
);

CREATE TABLE reference_type (
    id SERIAL PRIMARY KEY,
    abbreviation VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE identification_types (
    id SERIAL PRIMARY KEY,
    abbreviation VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE occupations (
    id SERIAL PRIMARY KEY,
    abbreviation VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE genders (
    id SERIAL PRIMARY KEY,
    abbreviation VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE countries (
    id SERIAL PRIMARY KEY,
    abbreviation VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE marital_status (
    id SERIAL PRIMARY KEY,
    abbreviation VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE reference (
    id SERIAL PRIMARY KEY,
    user_id INT,
    reference_type_id INT,
    reference_name VARCHAR(50),
    contact VARCHAR(50)
);

-- Adding foreign key constraint for user_id
ALTER TABLE reference
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id)
REFERENCES users(id);

-- Adding foreign key constraint for reference_type_id
ALTER TABLE reference
ADD CONSTRAINT fk_reference_type
FOREIGN KEY (reference_type_id)
REFERENCES reference_type(id);

CREATE TABLE contact (
    id SERIAL PRIMARY KEY,
    user_id INT,
    email VARCHAR(50),
    phone VARCHAR(50),
    address VARCHAR(50)
);

-- Adding foreign key constraint for user_id
ALTER TABLE contact
ADD CONSTRAINT fk_contact_user
FOREIGN KEY (user_id)
REFERENCES users(id);

CREATE TABLE identification (
    id SERIAL PRIMARY KEY,
    user_id INT,
    identification_type_id INT,
    identification_number VARCHAR(50)
);

-- Adding foreign key constraint for user_id
ALTER TABLE identification
ADD CONSTRAINT fk_identification_user
FOREIGN KEY (user_id)
REFERENCES users(id);

-- Adding foreign key constraint for identification_type_id
ALTER TABLE identification
ADD CONSTRAINT fk_identification_type
FOREIGN KEY (identification_type_id)
REFERENCES identification_types(id);

CREATE TABLE financial_information (
    id SERIAL PRIMARY KEY,
    user_id INT,
    bank_account_number VARCHAR(50),
    income DOUBLE PRECISION
);

-- Adding foreign key constraint for user_id
ALTER TABLE financial_information
ADD CONSTRAINT fk_financial_user
FOREIGN KEY (user_id)
REFERENCES users(id);

CREATE TABLE demography (
    id SERIAL PRIMARY KEY,
    user_id INT,
    occupation_id INT,
    gender_id INT,
    country_id INT,
    marital_status_id INT
);

-- Adding foreign key constraint for user_id
ALTER TABLE demography
ADD CONSTRAINT fk_demography_user
FOREIGN KEY (user_id)
REFERENCES users(id);

-- Adding foreign key constraint for occupation_id
ALTER TABLE demography
ADD CONSTRAINT fk_demography_occupation
FOREIGN KEY (occupation_id)
REFERENCES occupations(id);

-- Adding foreign key constraint for gender_id
ALTER TABLE demography
ADD CONSTRAINT fk_demography_gender
FOREIGN KEY (gender_id)
REFERENCES genders(id);

-- Adding foreign key constraint for country_id
ALTER TABLE demography
ADD CONSTRAINT fk_demography_country
FOREIGN KEY (country_id)
REFERENCES countries(id);

-- Adding foreign key constraint for marital_status_id
ALTER TABLE demography
ADD CONSTRAINT fk_demography_marital_status
FOREIGN KEY (marital_status_id)
REFERENCES marital_status(id);





























































