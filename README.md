# barclaysassignment
uri for h2 database view : http://localhost:8081/h2-ui/
#Select query

SELECT * FROM TRADES ;

#query to insert data

insert into trades (TRADE_ID,BOOK_ID,COUNTER_PARTY_ID,CREATED_DATE,EXPIRED,MATURITY_DATE,VERSION)
values ('T1','B1','CP-1','2022-04-14','N','2023-05-20',1), 
('T2','B1','CP-2','2022-04-14','N','2023-05-21',2),
('T2','B1','CP-1','2015-03-14','N','2023-05-21',1),
('T3','B2','CP-3','2022-04-14','Y','2014-05-20',3);
