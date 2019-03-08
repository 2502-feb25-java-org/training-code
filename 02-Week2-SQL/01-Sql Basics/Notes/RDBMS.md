# RDBMS
Relational Database Management System, relational referring to relational data (i.e. tables).

**Schema** Like packages/namespaces, groupings of tables expressing some database logical structure.

**SQL implementations** There is PostgreSQL is an Enterprise Database like Oracle, SQL Server, but there are others like MySQL/MariaSQL as well as non relational SQL databases (NoSQL).

**Candidate Key** A column that can uniquely identify a row (or entry) and thus is a potential candidate for a primary key.

**Composite Key** A primary key consisting of multiple columns.

**Primary Key** Unique (in that table), non-null candidate key.

**Foreign Key** A key that points to another primary key of a row (either in another table, or the same).

**Multiplicity** Refers to the relationship between linked tables. One-to-One (University, President), One-to-Many (University, Students), Many-to-Many (Students, Teachers). In 1:1, FKs will be within same table. 1:many, FKs will be in the other table. many:many, FKs will be in a junction/transition/join/lookup table.

**Referential Integrity** Enforcing data relationships, changes reflected between foreign keys. No orphans, all child rows must have their parent rows deleted as well.

**Domain Integrity** Column data is restricted to allowed range of allowed type.

**ERD** Entity-Relational Diagram