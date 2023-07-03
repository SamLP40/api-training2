package fr.fms.tests;

import fr.fms.service.ImplTrainingService;
import fr.fms.web.TrainingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = TrainingController.class)
public class TrainingControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private ImplTrainingService implTrainingService;

    @Test
    public void testGetTraining() throws Exception {
        mockMvc.perform(get( "/api/trainings"))
                .andExpect(status().isOk);
    }

}
