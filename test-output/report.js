$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./features/Customers.feature");
formatter.feature({
  "line": 1,
  "name": "Customers",
  "description": "",
  "id": "customers",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 20,
  "name": "Search Customer by EMailID",
  "description": "",
  "id": "customers;search-customer-by-emailid",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@Test2"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "User Launch Chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "User Opens URL \"http://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "User enters Email as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "Click on Login",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "User click on customers Menu",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Click on customers Menu Item",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Enter cutomer Email",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "Click on search button",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "User should found Email in the Search table",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_Launch_Chrome_browser()"
});
formatter.result({
  "duration": 2166588800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://admin-demo.nopcommerce.com/login",
      "offset": 16
    }
  ],
  "location": "Steps.user_Opens_URL(String)"
});
formatter.result({
  "duration": 1844976800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "admin@yourstore.com",
      "offset": 22
    },
    {
      "val": "admin",
      "offset": 60
    }
  ],
  "location": "Steps.user_enters_Email_as_and_Password_as(String,String)"
});
formatter.result({
  "duration": 387123500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Login()"
});
formatter.result({
  "duration": 7042864800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_click_on_customers_Menu()"
});
formatter.result({
  "duration": 3013588700,
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinitions.Steps.user_click_on_customers_Menu(Steps.java:105)\r\n\tat ✽.When User click on customers Menu(./features/Customers.feature:25)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Steps.click_on_customers_Menu_Item()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.enter_cutomer_Email()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.click_on_search_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.user_should_found_Email_in_the_Search_table()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "status": "skipped"
});
});