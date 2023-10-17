package com.tedy.stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.json.JSONObject;
// import org.json.JSONObject;

import org.junit.jupiter.api.Test;


public class MyStepdefs {
    @When("User melakukan testGetListUsers")

    @Test
    public void testGetListUsers() {
        RestAssured.given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo(6))
                .assertThat().body("page", Matchers.equalTo(2));
    }

    public void test404() {
        RestAssured.given()
                .when()
                .get("https://reqres.in/api/nonexistent")
                .then()
                .log().all()
                .assertThat().statusCode(404)
                .assertThat().body("page", Matchers.equalTo(21));
    }







    @Then("User menjalankan test post")

        @Test
        public void testPostPositiveCase() {
            JSONObject validData = new JSONObject();
            validData.put("name", "Tedy");
            validData.put("job", "QA");

            RestAssured.given()
                    .header("Content-type", "application/json")
                    .header("Accept", "application/json")
                    .body(validData.toString())
                    .when()
                    .post("https://reqres.in/api/users/2")
                    .then()
                    .log().all()
                    .assertThat().statusCode(201)
                    .assertThat().body("name", Matchers.equalTo("Tedy"));
        }
    @Then("User menjalankan test put")

    @Test
    public void testPutPositiveCase() {
        JSONObject validData = new JSONObject();
        validData.put("name", "Tedyy");
        validData.put("job", "QAA");

        RestAssured.given()
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(validData.toString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", Matchers.equalTo("Tedyy"));
    }

    @Then("User menjalankan test delete")
    @Test
    public void testDeletePositiveCase() {
        RestAssured.given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(204);
        //  .assertThat().body("id", Matchers.equalTo());
    }
    }

