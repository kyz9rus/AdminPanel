delete from banner;
alter SEQUENCE SEQ_BANNER RESTART WITH 1;

insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (SEQ_BANNER.nextval, '/static/img/acura.jpg', 512, 384, 'https://www.acura.com', 'English');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (SEQ_BANNER.nextval, '/static/img/alfa-romeo.jpg', 600, 450, 'https://www.alfaromeo.de', 'Germany');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (SEQ_BANNER.nextval, '/static/img/aston_martin.jpg', 800, 500, 'https://global.astonmartin.com/en-gb', 'English');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (SEQ_BANNER.nextval, '/static/img/audi.jpg', 600, 400, 'https://www.audi.ru/ru/web/ru.html', 'Russian');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (SEQ_BANNER.nextval, '/static/img/bentley.jpg', 600, 400, 'https://www.bentleymotors.com/ru/ru.html', 'Russian');
insert into banner(banner_id, imgsrc, width, height, targeturl, langid) values (SEQ_BANNER.nextval, 'https://avatars.mds.yandex.net/get-pdb/49816/2b57852b-5c84-4e22-bdc9-7461855f34fc/s1200?webp=false', 600, 361, 'https://www.bmw.ru/ru/index.html', 'Russian');