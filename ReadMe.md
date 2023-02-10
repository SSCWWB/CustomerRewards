# Read Me First


There are 2 branches of this code.

dev branch is to run on local host .please check out this branch to run on localhost
Run it locally, please first install mysql databse and then excute sql command from File : / CustomerRewards/src/main/resources/schema/db.sql

Use maven to build the app

Test endpoint :

Get rewards for a single customer of recent 3 months period 
http://localhost:8080/customerRewardPoints/customerId/ {customer_id}

customer id should be from 1 to 5

Get rewards for all customers of recent 3 months period
 http://localhost:8080/customerRewardPoints/all

main branch is to run on google cloud app engine, you don’t need to build locally and Just Access : 
https://regal-yew-377211.uc.r.appspot.com/ customerRewardPoints/customerId/ {customer_id}
https://regal-yew-377211.uc.r.appspot.com/ customerRewardPoints/all

The mysql databse on google cloud has the same data as run locally.
