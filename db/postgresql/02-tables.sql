CREATE TABLE "book" (
  id serial PRIMARY KEY,
  isbn VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL
);
GRANT ALL PRIVILEGES ON TABLE "book" TO "demo-svc";
GRANT USAGE, SELECT ON SEQUENCE "book_id_seq" TO "demo-svc";
