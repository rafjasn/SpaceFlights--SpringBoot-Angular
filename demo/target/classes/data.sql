insert into flight(id,arrival_date,departure_date,number_of_seats, price)
values(10002, sysdate(), sysdate(), 12, 12);
insert into flight(id,arrival_date,departure_date,number_of_seats, price)
values(10003,  sysdate(), sysdate(), 12, 12);
insert into flight(id, arrival_date,departure_date,number_of_seats, price)
values(10004,  sysdate(), sysdate(), 12, 12);
insert into flight(id,arrival_date,departure_date,number_of_seats, price)
values(10005,  sysdate(), sysdate(), 12, 12);
insert into flight(id,arrival_date,departure_date,number_of_seats, price)
values(10006,  sysdate(), sysdate(), 12, 12);

insert into tourist(id, first_name, last_name, gender, country, remarks, date_of_birth)
values(100, 'name', 'lname', 'yes', 'dhg', 'wreshydfh', sysdate());

insert into tourist(id, first_name, last_name, gender, country, remarks, date_of_birth)
values(101, 'name', 'lname', 'yes', 'dhg', 'wreshydfh', sysdate());

insert into tourist(id, first_name, last_name, gender, country, remarks, date_of_birth)
values(102, 'name', 'lname', 'yes', 'dhg', 'wreshydfh', sysdate());

insert into tourist(id, first_name, last_name, gender, country, remarks, date_of_birth)
values(103, 'name', 'lname', 'yes', 'dhg', 'wreshydfh', sysdate());



insert into tourist_projects(employees_id, projects_id)
values(100, 10002);