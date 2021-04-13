update servicio
set fecha_salida = :fechaSalida,
	activo = :activo,
	valor_a_pagar= :valorAPagar,
	horas = :horas
where id = :id