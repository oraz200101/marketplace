drop table if exists bucket_products;
drop table if exists bucket_seq;
drop table if exists buckets;
drop table if exists categories;
drop table if exists category_seq;
drop table if exists order_details;
drop table if exists order_details_seq;
drop table if exists order_seq;
drop table if exists orders;
drop table if exists orders_details;
drop table if exists product_seq;
drop table if exists products;
drop table if exists products_categories;
drop table if exists products_shops;
drop table if exists shop_seq;
drop table if exists shops;
drop table if exists user_seq;
drop table if exists users;
create table users
(
    id        bigint not null,
    email     varchar(255),
    name      varchar(255),
    password  varchar(255),
    phone     varchar(255),
    role      varchar(255),
    bucket_id bigint,
    shop_id bigint,
    primary key (id)

);

create table bucket_products
(
    bucket_id  bigint not null,
    product_id bigint not null
);
create table bucket_seq
(
    next_val bigint
);
insert into bucket_seq
values (1);
create table buckets
(
    id      bigint not null,
    user_id bigint,
    primary key (id)
);
create table categories
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
);
create table category_seq
(
    next_val bigint
);
insert into category_seq
values (1);
create table order_details
(
    id         bigint not null,
    amount     decimal(19, 2),
    price decimal (19,2),
    order_id   bigint,
    product_id bigint,
    primary key (id)
);
create table order_details_seq
(
    next_val bigint
);
insert into order_details_seq
values (1);
create table order_seq
(
    next_val bigint
);
insert into order_seq values (1);
create table orders
(
    id           bigint not null,
    address      varchar(255),
    created      datetime(6),
    order_status varchar(255),
    sum          decimal(19, 2),
    updated      datetime(6),
    user_id      bigint,
    primary key (id)
);
create table orders_details
(   order_id   bigint not null,
    details_id bigint not null


);
create table product_seq
(
    next_val bigint
);
insert into product_seq
values (1);
create table products
(
    id          bigint   not null,
    description varchar(255),
    name        varchar(255),
    price       double precision not null,
    primary key (id)
);
create table products_categories
(
    product_id  bigint not null,
    category_id bigint not null

);
create table products_shops
(
    product_id bigint not null,
    shop_id    bigint not null

);
create table shop_seq
(
    next_val bigint
);
insert into shop_seq
values (1);
create table shops
(
    id          bigint not null,
    description varchar(255),
    name        varchar(255),
    phone       varchar(255),
    user_id     bigint,
    primary key (id)

);
create table user_seq
(
    next_val bigint
);
insert into user_seq
values (2);

 alter table bucket_products
    add constraint bucket_fk1 FOREIGN KEY (bucket_id) references buckets (id),
    add constraint product_fk foreign key (product_id) references products (id);
alter table buckets
    add constraint user_fk foreign key (user_id) references users (id);
alter table orders
    add constraint user_fk1 foreign key (user_id) references users (id);
alter table orders_details
    add constraint order_fk foreign key (order_id) references orders (id),
    add constraint details unique (details_id),
    add constraint details_fk foreign key (details_id) references order_details (id);
alter table products_categories
    add constraint category_fk FOREIGN KEY (category_id) references categories (id),
    add constraint product_fk1 foreign key (product_id) references products (id);
alter table products_shops
    add constraint shop_fk FOREIGN KEY (shop_id) references shops (id),
    add constraint product_fk2 foreign key (product_id)references products (id);
alter table shops
    add constraint user_fk2 foreign key (user_id) references users(id);
alter table users
    add constraint bucket_fk foreign key (bucket_id) references buckets(id);
alter table users
    add constraint shop_fk2 foreign key (shop_id) references shops(id);