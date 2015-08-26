-- SQL Query 1
SELECT ORD.ORDER_NUMBER, IT.ITEM_NAME FROM ORDERS ORD, ORDER_ITEMS ORD_I, ITEMS IT WHERE ORD.ITEM_LIST_ID = ORD_I.ITEM_LIST_ID AND ORD_I.ITEM_KEY = IT.ITEM_KEY AND IT.ITEM_NAME LIKE '%JAZZY%';

-- SQL Query 2
SELECT OP.TOTAL_PRICE FROM ORDERS ORD, ORDER_PRICE OP WHERE ORD.ORDER_NUMBER = OP.ORDER_NUMBER AND OP.TOTAL_PRICE > 1000.0;