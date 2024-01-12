# AvusSIC Orientation Retake Exam

## Getting Started

- **Fork** this repository under your own account
- Clone your forked repository to your computer
- Create a `.gitignore` file so generated files won't be committed
- Commit your progress frequently and with descriptive commit messages
- All your answers and solutions should go in this repository
- Take care of style guide
- Take care of the naming of classes, fields, variables, files, etc.
- Upload your solution to [GradeScope](https://www.gradescope.com/)

## Keep in mind

- You can use any resource online, but **please work individually**
- AI help is not allowed (eg. chatGPT, copilot, ...)
- **Don't just copy-paste** your answers and solutions,
  you need to understand every line of your code
- **Don't push your work** to GitHub until your mentor announces
  that the time is up
- At the end of the exam push your solution to **GitHub** and upload it to GradeScope

## Tasks

# Tourist Information

Build a web application for tourists to find the best attractions.

## Highlights

### It has one frontend page which can:

- `GET /`: list all attractions and form to add a new attraction 

### It has a backend which can:

- list the attractions
  - all `GET /api/attractions` or
  - cheapest `GET /api/attractions?category=<categoryName>`
- save attractions
  - based on form data `POST /add`
  - based on JSON data `POST /api/attractions`
- edit details about attraction `PUT /api/attractions/<id>`

## Database

There are two tables, one is "attraction" and another is "category".
In this application, attraction can have only one category, but category can
have more attractions assigned.

- Category:
  - id, name

- Attraction:
  - id, city, price, longitude(decimal), latitude(decimal), category_id,
    duration, recommended_age

## Endpoints

Create the following endpoints:

### GET `/`

The main page is rendered:

![](assets/backend-main.png)

- all known attractions are listed in a table containing these data: name, city, price,
  latitude, longitude, category name, duration, recommended age
- a form is displayed to add a new attraction
  - form has to contain a field for: name, city, price, longitude, latitude,
    category (select from existing categories), duration, recommended age

- the form should be submitted to the POST `/add` endpoint

### POST `/add`

A new attraction is saved, based on form POST data:

- validate the user input, every field is *required*
  - the price, duration and recommended age must be a positive number
  - the latitude and longitude must be a decimal number
  - the category must be an existing category
  - display an error message if the validation is failed on the main page
- save the new attraction to the database (if all fields are provided and befit
  the database constraints)
- redirect to the main page

### POST `/api/attractions`

A new attraction is saved, based on JSON data.

Assume that the request body contains a JSON object with the following fields:
```json
{
    "name": "Pulitzer",
    "city": "Budapest",
    "price": 1200,
    "longitude": 47.4841,
    "latitude": 19.0602,
    "category": "restaurant",
    "duration": 60,
    "recommendedAge": 3
}
```

- validate the user input, every field is *required*
  - the price, duration and recommended age must be a positive number
  - the latitude and longitude must be a decimal number
  - the category must be an existing category
  - send an error response message if the validation is failed in JSON format and with 400 status code:
    - `{"error":"Incorrect provided data"}`
- save the new attraction to the database (if all fields are provided and befit
  the database constraints)

On success the JSON response should contain the whole new entity and with 201 status code:
```json
{
    "id": 3,
    "name": "Pulitzer",
    "city": "Budapest",
    "price": 1200,
    "longitude": 47.4841,
    "latitude": 19.0602,
    "category": "restaurant",
    "duration": 60,
    "recommendedAge": 3
}
```

### PUT `/api/attractions/<id>`

An existing attraction is updated, based on JSON data.

Assume that the request body contains a JSON object with the following fields:
```json
{
    "name": "Pulitzer",
    "city": "Budapest",
    "price": 1200,
    "longitude": 47.4841,
    "latitude": 19.0602,
    "category": "restaurant",
    "duration": 60,
    "recommendedAge": 6
}
```

- validate the user input, every field is *required*
  - the price, duration and recommended age must be a positive number
  - the latitude and longitude must be a decimal number
  - the category must be an existing category
  - send an error response message if the validation is failed in JSON format and with 400 status code:
    - `{"error":"Incorrect provided data"}`
- update the existing attraction in the database (if all fields are provided and befit
  the database constraints)
- send the updated entity in JSON format and with 200 status code:

```json
{
  "name": "Pulitzer",
  "city": "Budapest",
  "price": 1200,
  "longitude": 47.4841,
  "latitude": 19.0602,
  "category": "restaurant",
  "duration": 60,
  "recommendedAge": 6
}
```

- when there is no attraction with the given id send an error response message in JSON format with 404 status code:
  - `{"error":"Attraction not found"}`

### GET `/api/attractions?category=<categoryName>`

List the cheapest attraction if the category specified
in request parameter else it should list all attractions in **JSON** format.

If the category does not exist in the database return a 404 status code and the following JSON payload:

```json
{
  "error": "Category not found."
}
```

- example uri for cheapest: /api/attractions?category=restaurant

example response:

```json
{
    "attraction":
        {
            "id": 3,
            "name": "Pulitzer",
            "city": "Budapest",
            "price": 1200,
            "longitude": 47.4841,
            "latitude": 19.0602,
            "category": "restaurant",
            "duration": 60,
            "recommendedAge": 3
        }
}
```

- when the category is not specified: /api/attractions

example response:

```json
{
  "attractions": [
    {
      "id": 1,
      "name": "Pulitzer",
      "city": "Budapest",
      "price": 1200,
      "longitude": 47.4841,
      "latitude": 19.0602,
      "category": "restaurant",
      "duration": 60,
      "recommendedAge": 3
    },
    {
      "id": 2,
      "name": "Pulitzer",
      "city": "Budapest",
      "price": 1200,
      "longitude": 47.4841,
      "latitude": 19.0602,
      "category": "restaurant",
      "duration": 60,
      "recommendedAge": 3
    },
    {
      "id": 3,
      "name": "Pulitzer",
      "city": "Budapest",
      "price": 1200,
      "longitude": 47.4841,
      "latitude": 19.0602,
      "category": "restaurant",
      "duration": 60,
      "recommendedAge": 3
    }
  ]
}
```

## SQL

Given the following table named `apprentices`

| id | name           | cohort_id |
|:---|:---------------|:----------|
| 1  | Benedek Mihály | 1         |
| 2  | Jana Jechová   | 2         |
| 3  | Oldřich Dostál | 1         |
| 4  | Bo Tsai        | 2         |
| 5  | Barta Ema      | 3         |
| 6  | Chan Juan Yeh  | 3         |

And given the following table named `cohorts`

| id | name    |
|----|:--------|
| 1  | Vulpes  |
| 2  | Velox   |
| 3  | Lagopsu |

- Write an SQL statement to update the `Lagopsu` to `Lagopus`

```sql

UPDATE cohorts SET name = 'Lagopus' WHERE id = 3

```
  
- Write an SQL statement to insert `Doris D. Steves` to the `Vulpes` cohort

```sql
INSERT INTO apprentices VALUES (7, 'Doris D. Steves', 1)

```

- List cohorts that have more than 2 apprentices.

```sql
SELECT cohorts.name FROM cohorts JOIN apprentices ON cohort_id = cohorts.id WHERE cohort_id HAVING COUNT(cohort_id) > 2
```

- Find all apprentices who belong to cohorts with a name that starts with the letter 'V'.

```sql

```
