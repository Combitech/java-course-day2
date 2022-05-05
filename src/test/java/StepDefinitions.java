import com.combitech.images.resources.ImageResourceImpl;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.errors.*;
import org.junit.jupiter.api.Assertions;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.mockito.Mockito.*;


public class StepDefinitions {

    private ImageResourceImpl imageResource;

    private Response response;

    @Before
    public void setup() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient minioClient = mock(MinioClient.class);
        imageResource = new ImageResourceImpl(minioClient, "images");
        when(minioClient.putObject(any())).thenReturn(new ObjectWriteResponse(null, null, null, "1",null, null));

    }

    @After
    public void tearDown(){
        response = null;
    }

    @When("I upload an image for user with id {long}")
    public void uploadLogo(long id){
        response = imageResource.uploadImage(new byte[10], id);
    }

    @Then("I should get a status {int}")
    public void iShouldGetStatusCode(int status){
        Assertions.assertEquals(status, response.getStatus());
    }
}
