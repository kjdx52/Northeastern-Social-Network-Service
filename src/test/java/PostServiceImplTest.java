import com.Group11.NortheasternSocialNetwork.entity.PostEntity;
import com.Group11.NortheasternSocialNetwork.model.Post;
import com.Group11.NortheasternSocialNetwork.repository.PostEntityRepository;
import com.Group11.NortheasternSocialNetwork.service.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// JUnit test class for PostServiceImpl
class PostServiceImplTest {

    @Mock
    private PostEntityRepository postEntityRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddPost() throws Exception {
        // Given
        // Create a test Post
        Post post = new Post();
        post.setEmail("test@example.com");
        post.setName("Test User");
        post.setPost("Test post");

        // Create a corresponding PostEntity and set its properties
        PostEntity postEntity = new PostEntity();
        BeanUtils.copyProperties(post, postEntity);
        postEntity.setId("1");

        // Mock the behavior of the repository's save method
        when(postEntityRepository.save(any(PostEntity.class))).thenReturn(postEntity);

        // When
        // Call the addPost method of the service
        Post resultPost = postService.addPost(post);

        // Then
        // Verify that the service method returns the expected result
        assertEquals("1", resultPost.getId());
        assertEquals(post.getEmail(), resultPost.getEmail());
        assertEquals(post.getName(), resultPost.getName());
        assertEquals(post.getPost(), resultPost.getPost());
        // Verify that the repository's save method was called once
        verify(postEntityRepository, times(1)).save(any(PostEntity.class));
    }

    @Test
    void testGetPost() {
        // Given
        // Create two test PostEntities
        PostEntity postEntity1 = new PostEntity();
        postEntity1.setId("1");
        postEntity1.setEmail("test1@example.com");
        postEntity1.setName("Test User 1");
        postEntity1.setPost("Test post 1");

        PostEntity postEntity2 = new PostEntity();
        postEntity2.setId("2");
        postEntity2.setEmail("test2@example.com");
        postEntity2.setName("Test User 2");
        postEntity2.setPost("Test post 2");

        // Mock the behavior of the repository's findAll method
        when(postEntityRepository.findAll()).thenReturn(Arrays.asList(postEntity1, postEntity2));

        // When
        // Call the getPost method of the service
        List<Post> posts = postService.getPost();

        // Then
        // Verify that the service method returns the expected list of Post objects
        assertEquals(2, posts.size());
        assertEquals("1", posts.get(0).getId());
        assertEquals("test1@example.com", posts.get(0).getEmail());
        assertEquals("Test User 1", posts.get(0).getName());
        assertEquals("Test post 1", posts.get(0).getPost());
        assertEquals("2", posts.get(1).getId());
        assertEquals("test2@example.com", posts.get(1).getEmail());
        assertEquals("Test User 2", posts.get(1).getName());
        assertEquals("Test post 2", posts.get(1).getPost());
        // Verify that the repository's findAll method was called once
        verify(postEntityRepository, times(1)).findAll();
    }
}
