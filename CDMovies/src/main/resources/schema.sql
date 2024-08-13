create table if not exists movies (
    id bigint identity primary key,
    title varchar(255),
    director varchar(255),
    rating varchar(255),
    year int
)