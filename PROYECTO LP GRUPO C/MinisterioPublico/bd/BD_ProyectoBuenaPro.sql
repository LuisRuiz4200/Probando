Drop database if exists ProyectoBuenaPro;
Create database ProyectoBuenaPro;
use ProyectoBuenaPro;


create table tb_tipoUser(
id_tipoUser int not null,
des_tipoUser varchar(25) not null,

primary key (id_tipoUser)

);

create table tb_usuario (

codigo_user int not null,
nombre_user varchar(25),
apellido_user varchar (25),
usuario_user char (10) not null,
clave_user  char  (10) ,
fechaNac_user date,
tipo_user int,
estado_user varchar(25),

primary key (codigo_user),
foreign key (tipo_user) references tb_tipoUser(id_tipoUser)

);


create table tb_objetoPedido (

id_objetoPedido int not null,
des_objetoPedido varchar(25),

primary key (id_objetoPedido)
);

create table tb_tipoPedido (

id_tipoPedido int not null,
des_tipoPedido varchar(40),

primary key (id_tipoPedido)

);

create table tb_pedido(

id_ped char (10) not null,
entidad_ped varchar (25) ,
ruc_ped varchar(25),
id_tipoPedido int not null,
id_objetoPedido int not null,
descripcion_ped varchar(300),
fecha_ped date,
estado_ped varchar(25),

primary key (id_ped),
foreign key (id_tipoPedido) references tb_tipoPedido (id_tipoPedido),
foreign key (id_objetoPedido) references tb_objetoPedido(id_objetoPedido) 

);

create table tb_CEP_pedido (

id_ped char (10) not null,
id_miembroCEP char(10) not null,
nombre_miembroCEP varchar (25),
apellido_miemborCEP varchar (25),
dni_miembroCEP varchar(25),
funcion_miembroCEP varchar(25),
dependencia_miembroCEP varchar(25),

primary key (id_ped, id_miembroCEP),
foreign key(id_ped) references tb_pedido (id_ped)
);

create table tb_participante (

id_ped char (10) not null,
codigo_parti char (10) not null,
empresa_parti varchar (25),
ruc_parti varchar(25),
correo_parti varchar(50),
telefono_parti int,
estado_parti varchar(25),

primary key ( id_ped, codigo_parti),
foreign key (id_ped) references tb_pedido(id_ped),
index (codigo_parti)
);

create table tb_propuesta (

id_ped char(10) not null,
id_prop char(10) not null,
codigo_parti char (10) not null,
fecha_prop date,
desTecnica_prop varchar (500),
desEconomica_prop varchar (500),
estado_prop varchar (25),

primary key (id_ped, id_prop),
foreign key (id_ped) references tb_pedido (id_ped),
foreign key (codigo_parti) references tb_participante (codigo_parti),
index (id_prop)
);

create table tb_apelacion (

id_apel char (10) not null,
id_prop char (10) not null,
fecha_apel date,
descripcion_apel varchar (500) ,
estado_apel varchar (25),

primary key (id_apel),
foreign key (id_prop) references tb_propuesta (id_prop),
index (id_apel)
);

/*CUADRO COMPARATIVO*/
create table tb_evaluacionPropuesta (

id_prop char (10) not null,
id_evaProp char (10) not null,
puntTecnica_evaProp decimal,
puntEconomica_evaProp decimal,
fecha_evaProp date,
estado_evaProp varchar(25),

primary key (id_prop, id_evaProp),
foreign key (id_prop) references tb_propuesta (id_prop)
);

create table tb_actaPropuesta (

id_actaProp char (10) not null,
id_prop char (10) not null,
fecha_actaProp date,
descripcion_actaProp varchar (500),
tipo_actaProp varchar (25),
estado_actaProp varchar (25),

primary key (id_actaProp),
foreign key (id_prop) references tb_propuesta (id_prop),
index (id_prop)
);

create table tb_proyectoPronunciamientoApelacion (

id_pronApel char (10) not null,
id_apel char (10) not null,
nomGerenteAJ_pronApel varchar (25),
dniGerenteAJ_pronApel varchar (25),
fecha_pronApel date,
descripcion_pronApel varchar(500),
estado_pronApel varchar(25),

primary key (id_pronApel),
foreign key (id_apel) references tb_apelacion (id_apel)
);

/*INSERTS*/


/*insert into tb_tipoUser values ('1','Administrador');
insert into tb_tipoUser values ('2','Miembro del CEP');
insert into tb_tipoUser values ('3','Asistente de logistica');
insert into tb_tipoUser values ('4','Asesor juricio');

insert into tb_objetoPedido values ('1','Bien');
insert into tb_objetoPedido values ('2','Servicio');
insert into tb_objetoPedido values ('3','Obra');


insert into tb_tipoPedido values ('1','Licitacion Publica');
insert into tb_tipoPedido values ('2','Concurso Publica');
insert into tb_tipoPedido values ('3','Adjudicacion Directa');
insert into tb_tipoPedido values ('4','Adjudicacion Directa Selectiva');
insert into tb_tipoPedido values ('5','Adjudicacion de Menor Cuantia');*/


select * from tb_tipoPedido;

select * from tb_pedido;

select * from tb_objetoPedido;

select * from tb_participante;


