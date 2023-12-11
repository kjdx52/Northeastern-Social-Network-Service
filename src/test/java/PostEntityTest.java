import static org.junit.jupiter.api.Assertions.*;

import com.Group11.NortheasternSocialNetwork.entity.PostEntity;
import org.junit.jupiter.api.Test;

class PostEntityTest {

    // Test for the no-args constructor
    @Test
    void testNoArgsConstructor() {
        // Given
        PostEntity postEntity = new PostEntity();

        // Then
        assertNotNull(postEntity); // Ensure that the object is not null
    }

    // Test for the all-args constructor
    @Test
    void testAllArgsConstructor() {
        // Given
        PostEntity postEntity = new PostEntity("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "profile.jpg", "2023-01-01");

        // Then
        assertNotNull(postEntity); // Ensure that the object is not null
        // Verify that fields are set correctly
        assertEquals("1", postEntity.getId());
        assertEquals("Test post", postEntity.getPost());
        assertEquals("John Doe", postEntity.getName());
        assertEquals("john@example.com", postEntity.getEmail());
        assertEquals("image.jpg", postEntity.getImage());
        assertEquals("profile.jpg", postEntity.getProfilePic());
        assertEquals("2023-01-01", postEntity.getTimeStamp());
    }

    // Test for the Lombok builder
    @Test
    void testBuilder() {
        // Given
        PostEntity postEntity = PostEntity.builder()
                .id("2")
                .post("Another post")
                .name("Jane Doe")
                .email("jane@example.com")
                .image("image2.jpg")
                .profilePic("profile2.jpg")
                .timeStamp("2023-02-01")
                .build();

        // Then
        assertNotNull(postEntity); // Ensure that the object is not null
        // Verify that fields are set correctly
        assertEquals("2", postEntity.getId());
        assertEquals("Another post", postEntity.getPost());
        assertEquals("Jane Doe", postEntity.getName());
        assertEquals("jane@example.com", postEntity.getEmail());
        assertEquals("image2.jpg", postEntity.getImage());
        assertEquals("profile2.jpg", postEntity.getProfilePic());
        assertEquals("2023-02-01", postEntity.getTimeStamp());
    }

    // Test for the equals and hashCode methods
    @Test
    void testEqualsAndHashCode() {
        // Given
        PostEntity postEntity1 = new PostEntity("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "profile.jpg", "2023-01-01");

        PostEntity postEntity2 = new PostEntity("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "profile.jpg", "2023-01-01");

        // Then
        assertEquals(postEntity1, postEntity2); // Ensure that objects are considered equal
        assertEquals(postEntity1.hashCode(), postEntity2.hashCode()); // Ensure that hash codes are equal
    }

    // Test for the toString method
    @Test
    void testToString() {
        // Given
        PostEntity postEntity = new PostEntity("1", "Test post", "John Doe", "john@example.com",
                "image.jpg", "profile.jpg", "2023-01-01");

        // Then
        // Verify that the generated string matches the expected format
        String expectedToString = "PostEntity(id=1, post=Test post, name=John Doe, " +
                "email=john@example.com, image=image.jpg, profilePic=profile.jpg, timeStamp=2023-01-01)";
        assertEquals(expectedToString, postEntity.toString());
    }
}
