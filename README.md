# CS-180-Project-4


## How to Compile and Run:

To compile our project, ensure you have all necessary files: Market.java, User.java, Customer.java, Seller.java, Products.java, Store.java, StoreList.txt, UsersList.txt, and _______ (any other ones needed?). Then, navigate to the Market class and run that file. It contains the main method that will run the program. You should see a welcome message printed to the console. The program will give you all prompts through console printing, simply input to the program using that and you will be able to test all methods and functionality. 


## Submission Details

Alexander Neff - Submitted Report on Brightspace. 
Aaron Banks - Submitted Vocareum workspace.


## Class Descriptions: 

### Market

The Market class' main functionality has to do with its main method. This serves as the main method for the entire program. The main method controls how the user interfaces with the program through the console. It first directs the User to either log in or create an account. The Market class includes methods to validate that the input email is valid and that, if the user claims they have an existing account, that the email/password combination they input matches a pair within the .txt files of user information. After signing in, it presents the user with a menu of options. This allows them to choose to view/edit their account (name, email, password, or delete their account) whether they are a Seller or Customer. However, beyond this point, if a User is and instance of a Seller, their menu functionality is passed to the Seller and Store classes through methods called in the Market class. If the user is an instance of a Customer, they are handled within the Market class. The Customer can choose to view the Farmer's Market Menu, which is where many of the Option three - Market requirements are implemented. The Customer can view all available products, search for products by keyword, sort them by quantity or price, view their purchase history, or quit. This is also where the Shopping cart selection functionality is coded - this Farmer's Market Menu allows the user to choose to view their shopping cart. If the Customer selects “View market listings” then the Market class allows them to choose which product they would like to purchase now or add to their cart. It should be noted that all functionality of the Shopping cart, although it is called within the Market class main method, is contained within the Customer class.

The Market class does not extend and is not extended by any other class, but it does call methods from the Seller, Customer, and Products classes.

The Market class was tested __________________


### User

The User class serves as a superclass to the Customer and Seller classes. This was to eliminate the repetition of code between the two subclasses, because both Sellers and Customers must have names, emails, and passwords within our implementation. The User class contains all of this information for any instance of a Customer or Seller.

The User class is not directly tested, but because the Market class contains instances of its two subclasses, Seller and Customer, and the functionality of the program relies on its correct function, it was indirectly tested through our test cases run on the Market, Seller, and Customer classes. 



### Seller

The Seller class


### Customer

The Customer class


### Products

The Products class


### Store

The Store class

