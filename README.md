# Indix-MonsterData

  Problem Statement: 
  Design and Implement an API
Please ask the organisers for dataset in a thumb drive

In this challenge you will implement an API to search and lookup products along with offers.

What is an offer?

A product in an e-commerce store can be sold by more than one seller with same or different prices. Each seller is considered as an offer for that product.

The input will be provided in the form of csv files containing following fields:

pid	title	upcs	categoryld	storeld	seller	timestamp	price
67b817b7d43370130115d9743d72aaff	Workout Music - CD	00735509413029	99999	61	Best Buy	1413577316924	14.99
9a6f6eea3b10e9850e95fde99bc1a5dd	Konzilien-Lexikon	09781293429235	20438	3085			
25ed1eec630d4547e39f8dd7e73cdb2c	Hat with ribbon		24272	2597		1473462904719	2.99
These csv files has to be consumed from a shared folder and this folder should be monitored for new csv files (ie) new files might come in any time. When a new csv file is added, its product data should be consumed and merged with the existing one. Merge operation should be done with respect to the following conditions

Each product is identified using "pid" (product id) and all merge operations are for records with same "pid"
Merge should replace all non-empty fields of the existing product with the values from latest product record
Price is always based on the latest "Timestamp"
API should return a JSON response containing all fields from the csv for following queries.
GET /upc/<input upc>
GET /pid/<input pid>
GET /category/<input category>
GET /search?q=<search tokens>&minPrice=<lower limit>&maxPrice=<upper limit> (example /search?q=iphone%206s&minPrice=500&maxPrice=950)
  FileWatcher - Watch out for any file that is coming in a shared directory and it will initiate an event via which CSV files will be parsed chunk by chunk.
  API Layer - It has REST end points to be consumed
  More to follow.
  
