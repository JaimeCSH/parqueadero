insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into cliente(cedula,nombre) values('1234','test');
insert into vehiculo(cliente,placa) values('1','test');
insert into vehiculo(cliente,placa) values('1','test-2');
insert into servicio (vehiculo, fecha_entrada, activo) values ('1', '2021-04-13 08:08:52', '1');
