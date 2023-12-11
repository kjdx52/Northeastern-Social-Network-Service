// Importing necessary classes for JUnit testing
import static org.junit.jupiter.api.Assertions.*;
import com.Group11.NortheasternSocialNetwork.model.Post;
import org.junit.jupiter.api.Test;

// JUnit test class for the Post class
class PostTest {

    // Test for the no-argument constructor of the Post class
    @Test
    void testNoArgsConstructor() {
        // Creating a Post object using the no-argument constructor
        Post post = new Post();

        // Asserting that the Post object is not null
        assertNotNull(post);
    }

    // Test for the all-argument constructor of the Post class
    @Test
    void testAllArgsConstructor() {
        // Creating a Post object using the all-argument constructor
        Post post = new Post("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "file.txt", "profile.jpg", "2023-01-01", "image1.jpg");

        // Asserting that the Post object is not null
        assertNotNull(post);

        // Asserting that the attributes of the Post object are correctly set
        assertEquals("1", post.getId());
        assertEquals("Test post", post.getPost());
        assertEquals("John Doe", post.getName());
        assertEquals("john@example.com", post.getEmail());
        assertEquals("image.jpg", post.getImage());
        assertEquals("file.txt", post.getFile());
        assertEquals("profile.jpg", post.getProfilePic());
        assertEquals("2023-01-01", post.getTimeStamp());
        assertEquals("image1.jpg", post.getImageName());
    }

    // Test for the builder pattern of the Post class
    @Test
    void testBuilder() {
        // Creating a Post object using the builder pattern
        Post post = Post.builder()
                .id("2")
                .post("Another post")
                .name("Jane Doe")
                .email("jane@example.com")
                .image("image2.jpg")
                .file("document.pdf")
                .profilePic("profile2.jpg")
                .timeStamp("2023-02-01")
                .imageName("image2")
                .build();

        // Asserting that the Post object is not null
        assertNotNull(post);

        // Asserting that the attributes of the Post object are correctly set
        assertEquals("2", post.getId());
        assertEquals("Another post", post.getPost());
        assertEquals("Jane Doe", post.getName());
        assertEquals("jane@example.com", post.getEmail());
        assertEquals("image2.jpg", post.getImage());
        assertEquals("document.pdf", post.getFile());
        assertEquals("profile2.jpg", post.getProfilePic());
        assertEquals("2023-02-01", post.getTimeStamp());
        assertEquals("image2", post.getImageName());
    }

    // Test for the equals and hashCode methods of the Post class
    @Test
    void testEqualsAndHashCode() {
        // Creating two Post objects with the same attributes
        Post post1 = new Post("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "file.txt", "profile.jpg", "2023-01-01", "image1.jpg");

        Post post2 = new Post("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "file.txt", "profile.jpg", "2023-01-01", "image1.jpg");

        // Asserting that the two Post objects are equal
        assertEquals(post1, post2);

        // Asserting that the hash codes of the two Post objects are equal
        assertEquals(post1.hashCode(), post2.hashCode());
    }

    // Test for the toString method of the Post class
    @Test
    void testToString() {
        // Creating a Post object with specific attributes
        Post post = new Post("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "file.txt", "profile.jpg", "2023-01-01", "image1.jpg");

        // Defining the expected string representation of the Post object
        String expectedToString = "Post(id=1, post=Test post, name=John Doe, " +
                "email=john@example.com, image=image.jpg, file=file.txt, profilePic=profile.jpg, " +
                "timeStamp=2023-01-01, imageName=image1.jpg)";

        // Asserting that the toString method produces the expected string
        assertEquals(expectedToString, post.toString());
    }
}
