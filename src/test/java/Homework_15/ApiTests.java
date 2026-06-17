package Homework_15;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ApiTests {

    public static class Post {
        public long id;
        public String title;
        public String body;
        public int userId;
}
    @Test
    public void getTest(){
        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");
    Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void postTest(){
        Post requestPost = new Post();
        requestPost.title = "Test title";
        requestPost.body = "Test body";
        requestPost.userId = 1;

        Response response = given()
                .contentType("application/JSON")
                .body(requestPost)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");

        Assert.assertEquals(response.getStatusCode(), 201);

        Post responsePost = response.as(Post.class);

        Assert.assertEquals(responsePost.title, requestPost.title);

    }
}


