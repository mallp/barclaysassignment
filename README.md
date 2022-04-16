# barclaysassignment

uri h2 :  http://localhost:8081/h2-ui/
insert query : insert into trades (TRADE_ID,BOOK_ID,COUNTER_PARTY_ID,CREATED_DATE,EXPIRED,MATURITY_DATE,VERSION) values ('T1','B1','CP-1','2014-04-14','N','2023-05-20',1), ('T2','B1','CP-2','2014-04-14','N','2023-05-21',2), ('T2','B1','CP-1','2015-03-14','N','2016-05-21',1), ('T3','B2','CP-3','2020-04-14','N','2014-05-20',3);
post uri : http://localhost:8081/trades/update
request body:
{
        "tradesPK": {
            "version": 1,
            "trade_Id": "T4"
        },
        "counter_Party_Id": "CP-1",
        "book_id": "B1",
        "maturity_Date": "2023-04-15",
        "created_Date": "2014-04-14",
        "expired": "N"
    }
 response:
 [
    {
        "tradesPK": {
            "version": 1,
            "trade_Id": "T2"
        },
        "counter_Party_Id": "CP-1",
        "book_id": "B1",
        "maturity_Date": "2016-05-21",
        "created_Date": "2015-03-14",
        "expired": "Y"
    },
    {
        "tradesPK": {
            "version": 3,
            "trade_Id": "T3"
        },
        "counter_Party_Id": "CP-3",
        "book_id": "B2",
        "maturity_Date": "2014-05-20",
        "created_Date": "2020-04-14",
        "expired": "Y"
    },
    {
        "tradesPK": {
            "version": 1,
            "trade_Id": "T4"
        },
        "counter_Party_Id": "CP-1",
        "book_id": "B1",
        "maturity_Date": "2023-04-15",
        "created_Date": "2014-04-14",
        "expired": "N"
    }
]
get uri: http://localhost:8081/trades/get
response:
[
    {
        "tradesPK": {
            "version": 1,
            "trade_Id": "T1"
        },
        "counter_Party_Id": "CP-1",
        "book_id": "B1",
        "maturity_Date": "2023-05-20",
        "created_Date": "2014-04-14",
        "expired": "N"
    },
    {
        "tradesPK": {
            "version": 2,
            "trade_Id": "T2"
        },
        "counter_Party_Id": "CP-2",
        "book_id": "B1",
        "maturity_Date": "2023-05-21",
        "created_Date": "2014-04-14",
        "expired": "N"
    },
    {
        "tradesPK": {
            "version": 1,
            "trade_Id": "T2"
        },
        "counter_Party_Id": "CP-1",
        "book_id": "B1",
        "maturity_Date": "2016-05-21",
        "created_Date": "2015-03-14",
        "expired": "Y"
    },
    {
        "tradesPK": {
            "version": 3,
            "trade_Id": "T3"
        },
        "counter_Party_Id": "CP-3",
        "book_id": "B2",
        "maturity_Date": "2014-05-20",
        "created_Date": "2020-04-14",
        "expired": "Y"
    },
    {
        "tradesPK": {
            "version": 1,
            "trade_Id": "T4"
        },
        "counter_Party_Id": "CP-1",
        "book_id": "B1",
        "maturity_Date": "2023-04-15",
        "created_Date": "2014-04-14",
        "expired": "N"
    }
]
