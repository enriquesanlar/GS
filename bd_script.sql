create database Ejemplo;
use Ejemplo;

create table attendance (attendance_id integer not null auto_increment, attended bit not null, employee_id integer, primary key (attendance_id)) engine=InnoDB;
create table employee (id integer not null auto_increment, last_name varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
alter table attendance add constraint FKr7q0h8jfngkyybll6o9r3h9ua foreign key (employee_id) references employee (id);

drop procedure if exists insertAttendance;
DELIMITER //
CREATE PROCEDURE insertAttendance(IN attended boolean, IN date_ date, IN employee int, out res int)
BEGIN
	if (select count(*) from attendance where date = date_ and employee_id = employee ) = 0 then
		insert into attendance(attended,employee_id,date) values (attended, employee, date_);
        if row_count() = 1 then set res = last_insert_id();
		else set res = -1;
		end if;
	else set res = -2;
    end if;
    
END //

DELIMITER ;

drop procedure if exists insertEmployee;
DELIMITER //
CREATE PROCEDURE insertEmployee(IN last_name varchar(255), IN name_ varchar(255),  out res int)
BEGIN
    insert into employee(last_name,name) values (last_name, name_);
    if row_count() = 1 then set res = last_insert_id();
    else set res = -1;
    end if;
END //

DELIMITER ;

drop procedure if exists getEmployee;
DELIMITER //
CREATE PROCEDURE getEmployee(IN employee_id int)
BEGIN
    SELECT * FROM ejemplo.employee WHERE id = employee_id;
END //

DELIMITER ;

drop procedure if exists getEmployees_;
DELIMITER //
CREATE PROCEDURE getEmployees_()
BEGIN
    SELECT * FROM ejemplo.employee;
END //

DELIMITER ;


drop procedure if exists getAttendanceById;
DELIMITER //
CREATE PROCEDURE getAttendanceById(IN employee_id_ int)
BEGIN
    SELECT * FROM ejemplo.attendance WHERE employee_id = employee_id_;
END //

DELIMITER ;
