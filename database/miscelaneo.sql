/*
 * POSTGRES
 * 
INSERT INTO "public"."transaction_sp"("id", "accion", "anytime", "citem", "codigocanal", "comienzoeventofechaini", "comienzoeventotiempoini", "contenidosexual", "contenidoviolento", "costoevento", "credito", "datoc1", "datoc2", "descevento", "deviceid", "dfrom", "dto", "duracionevento", "estadoc", "finaleventofechafin", "finaleventotiempofin", "formapago", "idaccount", "idempresa", "ideventos", "idpaquetes", "idservicio", "interstitial", "isvalid", "lenguaje", "mpaa", "negocio", "paquete", "precioevento", "processid", "rating", "secuencia", "tiempocompra", "tiempodisplay", "tiempolibre", "tipoa", "tipoc", "tipopromocion", "ubicacion")
VALUES(1, 1, '1', 1, '1', '1899-12-31 00:00:00.0', '1899-12-31 00:00:00.0', '1', '1', '1', 1, '1', '1', '1', 1, '1899-12-31 00:00:00.0', '1899-12-31 00:00:00.0', 1, '1', '1899-12-31 00:00:00.0', '1899-12-31 00:00:00.0', '1', 1, 1, '1', '1', 1, '1', 'Y', '1', '1', '1', '1', '1', 1, '1', 1, '1', '1', '1', 1, '1', '1', 1)
GO
INSERT INTO "public"."interfaz_aprovisionamiento"("ia_id", "ia_accion", "ia_activity_type", "ia_interfacecode", "ia_order", "ia_system")
VALUES(1, 2, 'ACTIVATE', '650', 1, 'TV')
GO
*/


select * from transaction_header_response
go
select * from transaction_sp_response
