package com.staxrt.tutorial;
 
import java.util.List;
import java.util.Map;
 
import org.junit.Assert;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class StepDefinitions {
 private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
 private static final String USERNAME = "Test User";
 private static final String FIRSTNAME = "Test";
 private static final String LASTNAME = "User";
 private static final String EMAIL = "testuser@gmail.com";
 private static final String ADMIN = "Admin";
 private static final String PASSWORD = "Test@123";
 private static final String BASE_URL = "http://localhost:8081";
 
 private static String token;
 private static Response response;
 private static String jsonString;
 private static String bookId;
 
 
//  @Given("I am an authorized user")
//  public void iAmAnAuthorizedUser() {
 
//  RestAssured.baseURI = BASE_URL;
//  RequestSpecification request = RestAssured.given();
 
//  request.header("Content-Type", "application/json");
//  response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
//  .post("/Account/v1/GenerateToken");
 
//  String jsonString = response.asString();
//  token = JsonPath.from(jsonString).get("token");
 
//  }
 
//  @Given("A list of books are available")
//  public void listOfBooksAreAvailable() {
//  RestAssured.baseURI = BASE_URL;
//  RequestSpecification request = RestAssured.given();
//  response = request.get("/BookStore/v1/Books");
 
//  jsonString = response.asString();
//  List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
//  Assert.assertTrue(books.size() > 0);
 
//  bookId = books.get(0).get("isbn");    
//  }


 @When("User sends data")
 public void addUser() {
 RestAssured.baseURI = BASE_URL;
 RequestSpecification request = RestAssured.given();
 request.header("Content-Type", "application/json");
 
 response = request.body("{ \"username\": \"" + USERNAME + "\", " +
 "\"password\": \"" + PASSWORD + "\", " +
 "\"firstName\": \"" + FIRSTNAME + "\", " +
 "\"lastName\": \"" + LASTNAME + "\", " +
 "\"email\": \"" + EMAIL + "\", " +
 "\"createdBy\": \"" + ADMIN + "\", " +
 "\"updatedBy\": \"" + ADMIN + "\"}")
 .post("/api/v1/users");
 }
 
 @Then("The server should handle it and return a success status")
 public void userAdded() {
 Assert.assertNotNull(response.getBody());
 }
 
 @When("User requests data")
 public void showUsers() {
 RestAssured.baseURI = BASE_URL;
 RequestSpecification request = RestAssured.given();
 
  request.header("Content-Type", "application/json");
 
 response = request.get("/api/v1/users");
 }
 
 @Then("All users are returned")
 public void usersFetched() {
  Assert.assertNotNull(response.getBody());
 }
}