import com.Group11.NortheasternSocialNetwork.controller.PostController;
import com.Group11.NortheasternSocialNetwork.model.Post;
import com.Group11.NortheasternSocialNetwork.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @BeforeEach
    void setUp() {
        // Initialize mock objects and mockMvc before each test
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    public void testAddPost() throws Exception {
        // Mocking postService behavior for addPost method
        when(postService.addPost(any(Post.class))).thenReturn(getMockPost());

        // Performing the POST request and verifying the response
        mockMvc.perform(post("/api/v1/post")
                        .param("post", "Test Post")
                        .param("email", "test@example.com")
                        .param("name", "Test User")
                        .param("file", "test-file.txt")
                        .param("profilePic", "test-pic.jpg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.post").value("Test Post"))
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.name").value("Test User"))
                .andExpect(jsonPath("$.file").value("test-file.txt"))
                .andExpect(jsonPath("$.profilePic").value("test-pic.jpg"));
    }

    @Test
    public void testGetPost() throws Exception {
        // Mocking postService behavior for getPost method
        when(postService.getPost()).thenReturn(Arrays.asList(getMockPost(), getMockPost()));

        // Performing the GET request and verifying the response
        mockMvc.perform(get("/api/v1/post"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].post").value("Test Post"))
                .andExpect(jsonPath("$[0].email").value("test@example.com"))
                .andExpect(jsonPath("$[0].name").value("Test User"))
                .andExpect(jsonPath("$[0].file").value("test-file.txt"))
                .andExpect(jsonPath("$[0].profilePic").value("test-pic.jpg"))
                .andExpect(jsonPath("$[1].post").value("Test Post"))
                .andExpect(jsonPath("$[1].email").value("test@example.com"))
                .andExpect(jsonPath("$[1].name").value("Test User"))
                .andExpect(jsonPath("$[1].file").value("test-file.txt"))
                .andExpect(jsonPath("$[1].profilePic").value("test-pic.jpg"));
    }

    private Post getMockPost() {
        // Helper method to create a mock Post object for testing
        return Post.builder()
                .post("Test Post")
                .email("test@example.com")
                .name("Test User")
                .file("test-file.txt")
                .profilePic("test-pic.jpg")
                .timeStamp(new Date().toString())
                .build();
    }
}
