# SQL
## Sublanguages
**DCL** Data Control Language, setting user permissions (GRANT, REVOKE)

**DDL** Data Definition Language, working with database structure (CREATE, ALTER, TRUNCATE, DROP) EX:
```sql
CREATE TABLE (Schema)[TableName]
(Column definitions (Constraints))


ALTER TABLE [TableName]
ADD (Column) [Column definition]
ADD (Constraint clause)
DROP [column] [cascade]
DROP Constraint
ALTER COLUMN [definition]
```

**DML** Data Manipulation Language, working with the rows of data itself (INSERT, UPDATE, DELETE) EX:
```sql
INSERT INTO [TableName] [columns]
VALUES (data input)
SELECT (drop entire result set into table)
```

**DQL** Data Query Language, retrieving rows of data (SELECT). EX:
```sql
SELECT [columnList]
FROM [tableList]
WHERE [conditionList]
GROUP BY [columnList] // aggregate functions
HAVING [condition]  // aggregate functions
ORDER BY [columnList]
```

**TCL** Transaction Control Language, managing transactions (COMMIT, ROLLBACK, SAVEPOINT)
```sql
SAVEPOINT this_point;
INSERT ...
INSERT ...
INSERT ... --Error here
ROLLBACK TO this_point; --Undo last 3 inserts
INSERT ...
COMMIT; --Only last insert will commit
```

**Sequences** Generate numeric sequence, mostl for creating/managing primary keys.

**Views** Virtual table that displays the results of a SELECT statement, lets you reuse and store complex queries

**Indexes** Physical ordering of a column or group of columns, having unique indexes

**Alias** The `AS` or `IS` keyword allows you to set a Table name or column name as a short variable.

**Aggregate Functions** (AVG, MIN, MAX, SUM, COUNT) perform an action on an entire column

**Scalar functions** (LOWER, UPPER) operate on individual entries

## Joins
Combine rows from two tables based on some logical relationship between them (columns)
### Types
1. Inner Join, selects records with matching values from TableA and TableB
1. Left (Outer) Join, TableA primary, selects all records from A with matching values from B (non-matching values included as null)
1. Right (Outer) Join, TableB is primary, opposte of Left Join.
1. Cross Join, Cartesian join of two tables, if TableA has 5 rows, and TableB has 3 rows, the cross join will have 15 rows
1. Subquery is a query nested in the WHERE clause of a SELECT statement, in orde3r to further restrict the data returned. There are correlated and non-correlated. Correlated subqueries depend on the outer query to exist, meaning they cannot execute independently.

## Unions
1. UNION returns distinct rows present in either return set
1. UNION ALL returns all rows in both sets (including duplicates)
1. INTERSECT returns distinct rows present in both sets
1. MINUS returns all rows present in first set but not in second