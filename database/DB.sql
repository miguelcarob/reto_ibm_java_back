
drop database cinema_app;
CREATE DATABASE IF NOT EXISTS cinema_app;
use cinema_app;


 drop table if exists available_films;
 drop table if exists offers_subscribers;
 drop table if exists offer;
 drop table if exists category_films;
 drop table if exists category;

 drop table if exists actor_films;
 drop table if exists actor;

 drop table if exists director_films;
 drop table if exists director;

 drop table if exists subscribers_films;
 drop table if exists film;
 drop table if exists subscribers_points_register;
 drop table if exists cienema;
 drop table if exists subscriber;
 drop table if exists adminstrator;
 drop table if exists user_cinema;




/**
Descripcción tabla:  Usuarios 
tabla en la que se almacenan todos los usuarios de la plataforma, posee type_users en donde se sabe a que tipo usuario referencia (administrador, cinema,subscriptor)
ademas de guardar el status del usuario (saber si el usuario esta activo o se dió de baja) 

activo - 1 
dado de baja - 0

De acuerdo a la entidad debe tener minimo  
	- ID
    - Username
    - Password
    - Name
    - Surname
    - Email
 */
create table user_cinema(
	id_user_cinema integer auto_increment not null,
	username_user_cinema varchar(100),
	password_user_cinema varchar(200),
	name_user_cinema varchar(200),
	surname_user_cinema varchar(200),
	email_user_cinema varchar(200),
	type_user_cinema integer,
	state_user_cinema integer,
	primary key(id_user_cinema)
)Engine=InnoDB;

/**
Descripcción tabla: administrator
tabla que almacena la información de los suscriptores, ya que cada suscriptor debe tener una cuenta se le asigna un id_user_cinema que lo relaciona con su usuario

De acuerdo a la entidad debe tener minimo: 
	- Points
 */

create table administrator(
	id_administrator integer auto_increment,
    id_user_cinema integer,
    primary key(id_administrator)
)Engine=InnoDB;

alter table 
	administrator 
add constraint fk_administrator_user_cinema 
foreign key (id_user_cinema) references user_cinema(id_user_cinema);





/**
Descripcción tabla: Subscribers
tabla que almacena la información de los suscriptores, ya que cada suscriptor debe tener una cuenta se le asigna un id_user_cinema que lo relaciona con su usuario

De acuerdo a la entidad debe tener minimo: 
	- Points
 */
 

create table subscriber(
	id_subscriber integer auto_increment,
    current_points integer,
    id_user_cinema integer,
    primary key(id_subscriber)
)Engine=InnoDB;

alter table 
	subscriber 
add constraint fk_subscriber_user_cinema 
foreign key (id_user_cinema) references user_cinema(id_user_cinema);


/**
Descripcción tabla: cinema

tabla que almacena la información de los cinema, ya que cada cinema debe tener una cuenta se le asigna un id_user_cinema que lo relaciona con su usuario
ademas de la información requerida se agregó la ciudad para ser mas explicitos. 

De acuerdo a la entidad debe tener minimo  
	-	web
    -	Address
    
 */

create table cinema(
	id_cinema integer auto_increment,
	web_cinema varchar(400),
	adress_cinema varchar(400),
	city_cinema varchar(400),
    id_user_cinema integer,
primary key(id_cinema)
)Engine=InnoDB;



alter table 
	cinema 
add constraint fk_cinema_user_cinema 
foreign key (id_user_cinema) references user_cinema(id_user_cinema);


/**
Descripcción tabla: points_register
los usuarios van a recibir puntos por parte de los cinemas (por compra de boletas) 
ademas van a restarse puntos a los usuarios por el uso de estos en el cinema

id_points_register (consecutivo de tabla)
id_subscribers (codigo del suscriptor)
id_cinema (id del cinema que genera los puntos)
points  (cantida de puntos)
date (fecha de registro)
type_points (que hizo que se realizara el cargue de puntos) 

type points 
	- 1 añadir puntos  por alguna razón 
    - 2 eliminar puntos por alguna razón
De acuerdo a la entidad debe tener minimo  
	- No Aplica 
 */  

create table points_register(
	id_points_register integer auto_increment,
	id_subscriber integer,
	id_cinema integer,
	points_register integer,
	date_register date,
	type_points integer,
	primary key(id_points_register)
)Engine=InnoDB;

alter table 
	points_register 
add constraint fk_points_register_subscribers
foreign key (id_subscriber) references subscriber(id_subscriber);

alter table 
	points_register 
add constraint fk_points_register_cinema
foreign key (id_cinema) references cinema(id_cinema);


/**
Descripcción tabla: films
tabla que almacena la información de las peliculas  en el sistema, cuenta con información básica como titulo, descripción y año de lanzamiento
De acuerdo a la entidad debe tener minimo  
	- id
    - Title
    - Description
    - Date
 */

create table film(
	id_film integer auto_increment,
	title_film varchar(300),
    description_film varchar(500),
    release_date_film date,
	primary key(id_film)
)Engine=InnoDB;


/**
Descripcción tabla: subscribers_movies
 
 tabla que almacena información del usuario con respeto a las peliculas, guarda el id del suscriptor y el id de la pelicula y la información que quiere de esa pelicula. 
 la pelicula puede ser una ya vista , si es una pelicula para ver, o puede ser favorita. 

los usuarios (suscribers) pueden tener su lista de peliculas en donde los posibles valores pueden ser 
1) pelicula vista 
2) pelicula para ver 
3) pelicula favorita 

De acuerdo a la entidad debe tener minimo  
	- No Aplica
 */ 
 

create table subscribers_films(
	id_subscribers_films integer auto_increment,
	id_subscriber integer,
	id_film integer,
	type_film integer,
	primary key(id_subscribers_films)
)Engine=InnoDB;

alter table 
	subscribers_films
add constraint fk_subscribers_films_subscriber
foreign key (id_subscriber) references subscriber(id_subscriber);
	
alter table 
	subscribers_films
add constraint fk_subscribers_films_film
foreign key (id_film) references film(id_film);
	

/**
Descripcción tabla: director
tabla que almacena la información de todos los directores que se encuentra en la aplicación
los directores tienen el id y el nombre. 
De acuerdo a la entidad debe tener minimo   
	- id  
    - name 
 */

create table  director(
	id_director integer auto_increment,
    name_director varchar(400),
    primary key(id_director)
)Engine=InnoDB;
/**
Descripcción tabla: director_films

debido a que la relación entre director y pelicula es una relación de muchos a muchos, se establece una tercera tabla que cuenta con 
el id del director y el id de la pelicula
De acuerdo a la entidad debe tener minimo   
	No Aplica
 */
 

create table  director_films(
	id_director_films integer auto_increment,
	id_director integer,
    id_film integer,
	primary key(id_director_films)
)Engine=InnoDB;


alter table
	director_films
add constraint fk_director_films_director
foreign key (id_director) references director(id_director);

alter table
	director_films
add constraint fk_director_films_film
foreign key (id_film) references film(id_film);
/**
Descripcción tabla: actor

tabla que almacena  todos los actores que se encuentra en la aplicación
los actores cuentan con  el id y el nombre 


De acuerdo a la entidad debe tener minimo  
	- id 
    - Name
 */

create table actor(
	id_actor integer auto_increment,
    name_actor varchar(400),
    primary key(id_actor)
)Engine=InnoDB;
/**
Descripcción tabla: actor_films

debido a que la relación entre actor y pelicula es una relación de muchos a muchos, se establece una tercera tabla que cuenta con 
el id del actor y el id de la pelicula
De acuerdo a la entidad debe tener minimo  
	No Aplica
 */

create table actor_films(
	id_actor_films integer auto_increment,
    id_actor integer,
    id_film integer,
    primary key(id_actor_films)
)Engine=InnoDB;
 
alter table
	actor_films
add constraint fk_actor_films_actor
foreign key (id_actor) references actor(id_actor);

alter table
	actor_films
add constraint fk_actor_films_film
foreign key (id_film) references film(id_film);

/**
Descripcción tabla: category

tabla que almacena  todos las categorias que se encuentra en la aplicación
las categorias cuentan con  el id y el nombre 
De acuerdo a la entidad debe tener minimo  
	- id 
    - name
 */

create table category(
	id_category integer auto_increment,
    name_category varchar(400),
    primary key(id_category)
)Engine=InnoDB;
/**
Descripcción tabla: category_films


debido a que la relación entre categoria y pelicula es una relación de muchos a muchos, se establece una tercera tabla que cuenta con 
el id de la categoria y el id de la pelicula

De acuerdo a la entidad debe tener minimo  
	No Aplica
 */

create table category_films(
	id_category_films integer auto_increment,
    id_category integer,
    id_film integer,
    primary key(id_category_films)
    )Engine=InnoDB;

alter table
	category_films
add constraint fk_category_films_category
foreign key (id_category) references category(id_category);

alter table
	category_films
add constraint fk_category_films_film
foreign key (id_film) references film(id_film);

/**
Descripcción tabla: offer

tabla que almacena la información de las ofertas que han sido publicados por los cinemas
ademas de la información suministrada en el documento se cuenta con: 
points: el resultado entre add_points y sub_points (se mantienen estas 2 columnas por requerimiento)
id_cinema que relaciona el cine que publico la oferta
total_offers las ofertas iniciales que se pueden adquirir
current_offers cuantas ofertas quedan 
state_offer el estado de la oferta es un entero 
	1- oferta activa
    0- oferta inactiva
    

	id_cinema( que realiza la oferta o promoción)
De acuerdo a la entidad debe tener minimo  
	- id 
    - description
    - deadline
    - addPoints  (suposición cuanto puntos agrega el usar esta promoción)
    - subPoints  (si hay add points y sub points seria mejor una diferencia de estos dos) 
 */

create table offer(
	id_offer integer auto_increment,
	description_offer varchar(200),
    deadline_offer date,
    points integer,
    add_points integer default 0,
    sub_points integer default 0,
    id_cinema integer ,
    total_offers integer default -1,
    current_offers integer default -1,
    state_offer integer,
	primary key(id_offer)
)Engine=InnoDB;

alter table 
	offer
add constraint fk_offer_cinema 
foreign key(id_cinema) references cinema(id_cinema);

/**
Descripcción tabla: offers_subscribers

(antiguo nombre - offers_subscribers_history )
la tabla almacena la "información" de las transacción que se realizaron entre las ofertas y los suscriptores. 
basicamente guarda la información de la oferta  y que suscriptor obtuvo la oferta. 

(para evitar crear la tabla de offer_request  se va a manejar un estado de la tabla) 
--- la tabla offer_request iba a almacenar las peticiones que realizaran los suscriptores para obtener las ofertas
estado de offers_subscribers 
	-1 petición por parte del usuario
    -2 oferta aplicada 
    -3 oferta reclamada
    -4 oferta rechazada
De acuerdo a la entidad debe tener minimo  
	No Aplica
 */
 
create table offers_subscribers(
	id_offers_subscribers integer auto_increment,
    id_offer integer,
    id_subscriber integer,
    state_offers_subscribers integer,    
    primary key(id_offers_subscribers)
)Engine=InnoDB;
/**
Descripcción tabla: available_films

guarda la información de que cinemas tiene marcada la pelicula como disponible en sus salas. 
para esto se guarda el id de la pelicula junto con el id del cinema para referenciar.
para establecer si la pelicula aún sigue o no disponible existirá un estado en la tabla 
estado available_films
	1- disponible.
    2- No disponible.
    3- Pronto disponible.
ademas de una información adicional. 
De acuerdo a la entidad debe tener minimo  
	No Aplica
 */

create table available_films(
	id_available_films integer auto_increment,
    id_film integer,
    id_cinema integer,
    state_available_films integer,
    description_available_films integer,
	primary key(id_available_films)
)Engine=InnoDB;


alter table 
	available_films
add constraint fk_available_films_film
foreign key (id_film) references film (id_film);

alter table 
	available_films
add constraint fk_available_films_cinema
foreign key (id_cinema) references cinema(id_cinema);
