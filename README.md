# SeleniumWebdriver-SauceDemoTests

Description:
tested site URL: https://www.saucedemo.com/

In my Maven Project I am using JAVA + Selenium + TestNg. Configuration is in config.yaml file.

TESTS:

CartTest:

1. Log in with proper credentials
2. Add random item to the cart
3. Check if the item is in the cart
4. Remove item from cart
5. Check if cart is empty

CheckoutTest:

1. Log in with proper credentials
2. Add 5 random products to the cart
3. Go to cart
4. Check if the cart contains proper items
5. Go to checkout
6. Fill data form
7. Proceed to checkout with success

NegativeLoginTest:

1. Log in with all bad credentials (provided on the main page of the app)
2. Check if the proper error message occurs

PositiveLoginTest

1. Log in with all good credentials (provided on the main page of the app)
2. Check if succeed
3. Log out
