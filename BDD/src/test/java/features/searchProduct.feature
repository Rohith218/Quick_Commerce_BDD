Feature: Search and place order for vegetables

Scenario:Search Experience for both Home page and offers page

Given Verify User is on GreenKart page "https://rahulshettyacademy.com/seleniumPractise/#/"
When search for shortname "tom" on homepage and extract actualname
Then user search same shortname "tom" in offerspage and verify both are same
And validate whether product name in landing page is same as offers page
