create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 cedula int(11) not null,
 nombre varchar(100) not null,
 primary key (id)
);

create table vehiculo (
 id int(11) not null auto_increment,
 cliente int(11) not null,
 placa varchar(100) not null,
 primary key (id),
 FOREIGN KEY (cliente) REFERENCES cliente(id)
 ON DELETE RESTRICT
);

create table servicio (
    id int(11) not null auto_increment,
    vehiculo int(11) not null,
    fecha_entrada datetime null,
    fecha_salida datetime null,
    activo int(1) null,
    valor_a_pagar double null,
    horas int(11) null,
    primary key (id),
    foreign key (vehiculo) references vehiculo(id)
    on delete restrict
);