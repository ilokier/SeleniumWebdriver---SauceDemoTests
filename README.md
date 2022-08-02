# SeleniumWebdriver-SauceDemoTests

Description:
tested site URL: https://www.saucedemo.com/

In my Maven Project I am using JAVA + Selenium + TestNg. Configuration is in config.yaml file.

TESTS:

1. CartTest:
   Log in with proper credentials
   Add random item to the cart
   Check if the item is in the cart
   Remove item from cart
   Check if cart is empty

2. CheckoutTest:
   Log in with proper credentials
   Add 5 random products to the cart
   Go to cart
   Check if the cart contains proper items
   Go to checkout
   Fill data form
   Proceed to checkout with success

3. NegativeLoginTest:
   Log in with all bad credentials (provided on the main page of the app)
   Check if the proper error message occurs

4. PositiveLoginTest
   Log in with all good credentials (provided on the main page of the app)
   Check if succeed
   Log out
