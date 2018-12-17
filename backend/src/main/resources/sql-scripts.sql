insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (1, '/static/img/acura.jpg', 512, 384, 'https://www.acura.com', 'English');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (2, '/static/img/alfa-romeo.jpg', 600, 450, 'https://www.alfaromeo.de', 'Germany');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (3, '/static/img/aston_martin.jpg', 800, 500, 'https://global.astonmartin.com/en-gb', 'English');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (4, '/static/img/audi.jpg', 600, 400, 'https://www.audi.ru/ru/web/ru.html', 'Russian');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (5, '/static/img/bentley.jpg', 600, 400, 'https://www.bentleymotors.com/ru/ru.html', 'Russian');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (6, 'https://avatars.mds.yandex.net/get-pdb/49816/2b57852b-5c84-4e22-bdc9-7461855f34fc/s1200?webp=false', 600, 361, 'https://www.bmw.ru/ru/index.html', 'Russian');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (7, 'http://www.avto-ultra.com/uploaded/files/wallpapers/Chevrolet/Cruze/prvw/Chevrolet-Cruze-wallpaper-11x1280x1024.jpg', 575, 342, 'https://www.chevrolet.de', 'Germany');

insert into users values ('Danya', '$2a$10$7YDSJT6rsDN6Yc1CacLejetQCeFo8VH7sGMJfNE57gSUAbW5LmOwe');
insert into role values (1, 'ADMIN');
insert into user_role values ('Danya',1);