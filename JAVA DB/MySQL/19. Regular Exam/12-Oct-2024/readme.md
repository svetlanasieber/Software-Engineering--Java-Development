# MySQL Exam
# Summer Olympics

The Summer Olympic Games, often called the "Olympics," are a major international multi-sport event held every four years. Organised by the International Olympic Committee (IOC), they feature a wide range of sports and disciplines, drawing athletes from around the world to compete at the highest level.
The modern Summer Olympics were first held in 1896 in Athens, Greece. They were inspired by the ancient Olympic Games that took place in Olympia, Greece, from around 776 BC to 393 AD. Pierre de Coubertin revived the modern Games.
This task only affects individual sports with mixed participants (male/female). All athletes are fictional and have no relation to actual athletes.

![image](https://github.com/user-attachments/assets/aba65102-87e6-4cde-8f2b-e6ec67f0d099)

# Summer Olympics Database Design

## Section 0: Database Overview

The Summer Olympics Database needs to hold information about countries, sports, disciplines, athletes, and medals. Your task is to create a database called `summer_olympics` and several tables.

### Tables

- `countries` – contains information about the countries.
- `sports` – contains information about the sports.
- `disciplines` – contains information about the disciplines.
  - Each discipline has a sport.
- `athletes` – contains information about the athletes.
  - Each athlete has a country.
- `medals` – contains information about the medals.
- `disciplines_athletes_medals` – a many-to-many mapping table between disciplines, athletes, and medals.

### Relationships

- Each athlete has disciplines and medals.
- No two athletes can win the same type of medal (e.g., gold, silver, bronze) in the same discipline.

## Section 1: Data Definition Language (DDL) – 40 pts

You need to implement the following tables:

### `countries` Table

| Column Name | Data Type    | Constraints                    |
|-------------|--------------|---------------------------------|
| `id`        | Integer      | Primary Key, AUTO_INCREMENT     |
| `name`      | VARCHAR(40)  | NOT NULL, UNIQUE                |

### `sports` Table

| Column Name | Data Type    | Constraints                    |
|-------------|--------------|---------------------------------|
| `id`        | Integer      | Primary Key, AUTO_INCREMENT     |
| `name`      | VARCHAR(20)  | NOT NULL, UNIQUE                |

### `disciplines` Table

| Column Name | Data Type    | Constraints                    |
|-------------|--------------|---------------------------------|
| `id`        | Integer      | Primary Key, AUTO_INCREMENT     |
| `name`      | VARCHAR(40)  | NOT NULL, UNIQUE                |
| `sport_id`  | Integer      | NOT NULL, Foreign Key (sports)  |

### `athletes` Table

| Column Name  | Data Type    | Constraints                    |
|--------------|--------------|---------------------------------|
| `id`         | Integer      | Primary Key, AUTO_INCREMENT     |
| `first_name` | VARCHAR(40)  | NOT NULL                       |
| `last_name`  | VARCHAR(40)  | NOT NULL                       |
| `age`        | Integer      | NOT NULL                       |
| `country_id` | Integer      | NOT NULL, Foreign Key (countries) |

### `medals` Table

| Column Name | Data Type    | Constraints                    |
|-------------|--------------|---------------------------------|
| `id`        | Integer      | Primary Key, AUTO_INCREMENT     |
| `type`      | VARCHAR(10)  | NOT NULL, UNIQUE                |

### `disciplines_athletes_medals` Table

| Column Name    | Data Type    | Constraints                    |
|----------------|--------------|---------------------------------|
| `discipline_id` | Integer      | NOT NULL, Foreign Key (disciplines) |
| `athlete_id`    | Integer      | NOT NULL, Foreign Key (athletes)    |
| `medal_id`      | Integer      | NOT NULL, Foreign Key (medals)      |

## Section 2: Data Manipulation Language (DML) – 30 pts

Here are some data manipulation tasks:

### Insert Task

Insert records into the `athletes` table for all athletes from countries whose names start with "A". Update the following fields:

- `first_name` – Uppercase the first name.
- `last_name` – Append "comes from" and the country name to the last name.
- `age` – Add the athlete’s `age` and `country_id` values.
- `country_id` – Keep the same value.

### Update Task

Remove the word "weight" from any discipline containing it.

### Delete Task

Delete all athletes older than 35 years.

## Section 3: Querying – 50 pts

This section involves querying the database for different results. Below are the required queries:

### Query 1: Countries Without Athletes

Write a query to return the `id` and `name` of the first 15 countries that do not have any athletes. Sort the results in descending order by country name.

Required Columns:

- `id` (country)
- `name` (country)

Example:

| id  | name                |
|-----|---------------------|
| 190 | Yemen               |
| 189 | Virgin Islands US    |
| 188 | Virgin Islands British|
| ... | ...                 |

### Query 2: Youngest Medalists

Extract the `full_name` and `age` of the two youngest athletes who have won at least one medal. Sort by `id` in ascending order.

Required Columns:

- `full_name` (first_name + " " + last_name)
- `age`

Example:

| full_name      | age |
|----------------|-----|
| Melissa Olson  | 17  |
| Nathan Cox     | 17  |

### Query 3: Athletes Without Medals

Write a query to return all athletes who have not won any medals. Sort by `id` in ascending order.

Required Columns:

- `id` (athlete)
- `first_name` (athlete)
- `last_name` (athlete)

Example:

| id  | first_name | last_name  |
|-----|------------|------------|
| 18  | Courtney   | Henry      |
| 22  | Danielle   | Dominguez  |

### Query 4: Athletes with Medals Divided by Sports

Extract the `id`, `first_name`, `last_name`, `medals_count`, and `sport` of the top 10 athletes who have won medals. Sort the results by `medals_count` (descending) and `first_name` (ascending).

Required Columns:

- `id` (athlete)
- `first_name` (athlete)
- `last_name` (athlete)
- `medals_count` (total medals won by an athlete)
- `sport`

Example:

| id  | first_name | last_name | medals_count | sport    |
|-----|------------|-----------|--------------|----------|
| 20  | Daniel     | King      | 4            | Cycling  |
| 41  | Jerry      | Little    | 3            | Fencing  |

### Query 5: Age Groups of Athletes

Extract the `full_name` and `age_group` of the athletes. The `age_group` should be one of the following based on the athlete’s age:

- "Teenager" if 18 years old or younger.
- "Young adult" if between 18 (exclusive) and 25 years old (inclusive).
- "Adult" if 26 years old or older.

Sort by `age` (descending) and `first_name` (ascending).

Required Columns:

- `full_name` (first_name + " " + last_name)
- `age_group`

Example:

| full_name     | age_group   |
|---------------|-------------|
| James Soto    | Adult       |
| Joseph Cook   | Adult       |
| Melissa Olson | Teenager    |

## Section 4: Programmability – 30 pts

### Task 1: Total Medals by Country

Create a user-defined function `udf_total_medals_count_by_country(name VARCHAR(40))` that receives a `country_name` and returns the total number of medals won by athletes from that country.

Required Columns:

- `country_name`
- `count_of_medals`

Example Query:

```sql
SELECT c.name, udf_total_medals_count_by_country('Bahamas') AS count_of_medals
FROM countries c
WHERE c.name = 'Bahamas';


Task 2: Update Athlete's Information
Create a stored procedure udp_first_name_to_upper_case(letter CHAR(1)) that updates the first_name column by capitalizing all letters for athletes whose first name ends with the given letter. The given letter will always be lowercase.
