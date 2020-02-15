use gamebar;
ALTER TABLE products
ADD FOREIGN KEY (category_id) REFERENCES categories(id);