package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class SpitterControllerTest {

    @Test
    public void showRegistration() throws Exception {
        SpitterController spitterController = new SpitterController(null);
        MockMvc mockMvc = standaloneSetup(spitterController).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository =
                mock(SpitterRepository.class);
        Spitter unsaved =
                new Spitter("Jack", "Bauer", "jbauer", "24hours");
        Spitter saved =
                new Spitter(24L, "Jack", "Bauer", "jbauer", "24hours");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController spitterController = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();
        mockMvc.perform(post("/spitter/register")
                        .param("firstName", "Jack")
                        .param("lastName", "Bauer")
                        .param("username", "jbauer")
                        .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}