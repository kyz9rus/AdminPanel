create table admin(
  login text primary key,
  password text not null
);

create table lang(
  id serial primary key,
  name text not null
);

create type name_actions as enum('ADD', 'EDIT', 'DELETE');

create table action(
  id_banner int references banner(id),
  name_admin text references admin(login),
  name_action name_actions,
  time_action timestamp
);

create table banner(
  id serial primary key,
  imgSrc text not null,
  width int not null,
  height int not null,
  targetUrl text not null,
  langId int references lang(id)
);