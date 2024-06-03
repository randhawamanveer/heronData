# heronData

Algorithm to find recurring transactions from a list of Transactions:

create a point system that gives each transaction points based on the likelyness of it being a recurreing charge
- upto 2 points for name similarity (can be a decimal too)
- 0 or 1 points for matching amount
- between 0 and 1 based on how much the current treansaction changes the average cadence of transaction periods.

Create a map of String -> list of transactions. They key's here will be the transaction description (or a substring of the description) and the following list will be all the associated recurring transactions

iterate over transactions list
  take keySet of map and look for key that is most similar to current transaction description

  based on similarity of the two string award points to new transactions

  if similar key exists:
    find last transaction appended to associated list in the map for that key
    if current transtions AMOUNT == last transaction amount:
      award another point to the transactions

    iterate over the list of transactions of map[similarKey] and find average days between all transactions 

    if (list has < 3 items or new transactions is within 2-3 days):
      award another point

    if new transaction has > 2 points
      add to list
    

  else:
    create new entry in map


iterate map and combine transaction lists that have a size > 2

return new combined transactions list

algorithem for finding similar string:
- similiar to on of these: https://stackoverflow.com/questions/955110/similarity-string-comparison-in-java
- would have to remove dates in decription otherwise we might start categorizing transactions by months
- to get points multiply % similarity by 2
- 

downsides of approach:
- pretty slow and space consuming
-  
