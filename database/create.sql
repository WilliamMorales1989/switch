create table TRANSACTION_SP(
Id number,
DeviceId number not null,
ProcessId number not null,
IdEmpresa number,
Negocio varchar2(3),
Secuencia number,
IdAccount number,
CItem number,
Ubicacion number(20),
Accion number,
Credito number,
IdServicio number,
IdPaquetes varchar2(500),
IdEventos varchar2(500),
TipoA number,
EstadoC varchar2(2),
FormaPago varchar2(4),
TipoC varchar2(2),
TipoPromocion varchar2(20),
DatoC1 varchar2(20),
DatoC2 varchar2(20),
CodigoCanal varchar2(10),
DescEvento varchar2(50),
ComienzoEventoFechaIni date,
ComienzoEventoTiempoIni date,
FinalEventoFechaFin date,
FinalEventoTiempoFin date,
DuracionEvento number,
Interstitial varchar2(4),
TiempoLibre varchar2(4),
Mpaa varchar2(4),
ContenidoViolento varchar2(4),
ContenidoSexual varchar2(4),
Lenguaje varchar2(4),
Rating varchar2(4),
TiempoCompra varchar2(10),
Paquete varchar2(4),
TiempoDisplay varchar2(10),
CostoEvento varchar2(4),
PrecioEvento varchar2(4),
AnyTime varchar2(10),
isValid varchar2(1),
dfrom date,
dto date,
Interface number,
Action number
);

alter table TRANSACTION_SP add constraint PK_TRANSACTION_SP primary key(Id,DeviceId);

create table TRANSACTION_SP_RESPONSE(
Id number,
device_id number,
interface number,
request_id number,
request_date date,
CodError number,
DetMensaje varchar2(500),
DatosExtrasTVP varchar2(500)
);

alter table TRANSACTION_SP_RESPONSE add constraint FK_TRANSACTION_SP_RESPONSE 
foreign key (device_id,request_id) references TRANSACTION_SP (DeviceId,Id);

create sequence TRANSACTION_SP_RESPONSE_SEQ start with 1 increment by 1 nocache nocycle;

CREATE TABLE INTERFAZ_APROVISIONAMIENTO (
		IA_ID NUMBER(19 , 0) NOT NULL,
		IA_CONTROLLER VARCHAR2(255),
		IA_ACTIVITY_TYPE VARCHAR2(255),
		IA_INTERFACECODE VARCHAR2(255),
		IA_ORDER NUMBER(10 , 0),
		IA_SYSTEM VARCHAR2(255)
	);

CREATE UNIQUE INDEX SYS_C0039718 ON INTERFAZ_APROVISIONAMIENTO (IA_ID ASC);

ALTER TABLE INTERFAZ_APROVISIONAMIENTO ADD CONSTRAINT SYS_C0039718 PRIMARY KEY (IA_ID);
