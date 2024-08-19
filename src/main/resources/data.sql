insert into SIMPLE_TOGGLE_INFO (TOGGLE_ID, DESCRIPTION, USE_YN)
values ('SIMPLE-TOGGLE-ONE', '사용중인 심플 토글입니다.', 'Y'),
       ('SIMPLE-TOGGLE-TWO', '비사용중인 심플 토글입니다.', 'N');

insert into SIMPLE_DATE_TOGGLE_INFO (TOGGLE_ID, DESCRIPTION, START_DATE, END_DATE, USE_YN)
values ('TOGGLE-ONE', '유효기간이 지났지만 사용여부는 Y인 토글', '2024-01-01 00:00:00', '2024-01-01 23:59:59', 'Y'),
       ('TOGGLE-TWO', '유효기간이 지나고 사용하지 않는 토글', '2024-01-01 00:00:00', '2024-01-01 23:59:59', 'N'),
       ('TOGGLE-THREE', '유효기간에 해당하면서 사용 중인 토글', '2024-08-18 00:00:00', '2024-08-18 23:59:59', 'Y'),
       ('TOGGLE-FOUR', '유효기간이지만 사용하지 않는 토글', '2024-08-18 00:00:00', '2024-08-18 23:59:59', 'N');

insert into SIMPLE_CACHE_TOGGLE_INFO (TOGGLE_ID, DESCRIPTION, USE_YN)
values ('SIMPLE-CACHE-TOGGLE', '심플 토글입니다.', 'Y');
