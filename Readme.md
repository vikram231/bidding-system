# Bidding System Architecture
The Bidding System
This bidding system enables the users to place the bid for running auctions.
An Auction have following attributes:
1. Item Code - for which auction is running
2. Minimum Base Price - This is starting bidding amount, no user can place the bid
lesser than this defined price
3. Step Rate - minimum amount difference b/w two consecutive bids. For example, if a
user placed the bid of 1000 /- INR then the next acceptable bid will be a minimum of
1000 + Step Rate. If the step rate is 250 /- INR then the next acceptable bid should
be >= 1250.
4. Status -
a. RUNNING: Only running auctions are the candidates of placing the bid
b. OVER: Once auction is over then no user can place the bid on the
corresponding item
5. User Bids - All user bids should be recorded whether it was accepted or rejected.

# Fetch API -
localhost:8080/auction?status=OVER - gives list of auctions that are over
localhost:8080/auction?status=RUNNING - gives running auctions list
localhost:8080/auction (default will be RUNNING)

# POST API -
localhost:8080/auction/kohinoor234/bid  (kohinoor234 is itemCode)
with payload like - 
{
	"bidAmount" : 100000,
	"userName" : "vik"
}
