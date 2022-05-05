import com.combitech.images.resources.ImageResourceImpl;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.errors.*;
import org.junit.jupiter.api.Assertions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class StepDefinitions {

    private ImageResourceImpl imageResource;

    private Response response;

    private List<WebApplicationException> exceptionList = new ArrayList<>();

    @Before
    public void setup() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient minioClient = mock(MinioClient.class);
        imageResource = new ImageResourceImpl(minioClient, "images");
        when(minioClient.putObject(any())).thenReturn(new ObjectWriteResponse(null, null, null, "1",null, null));
        doNothing().when(minioClient).removeObject(any());
        GetObjectArgs args1 = GetObjectArgs.builder().bucket("images").object("1").build();
        when(minioClient.getObject(args1)).thenReturn(new GetObjectResponse(null,null,null,"1", new ByteArrayInputStream(new byte[10])));
        GetObjectArgs args2 = GetObjectArgs.builder().bucket("images").object("2").build();
        when(minioClient.getObject(args2)).thenThrow(mock(ErrorResponseException.class));


    }

    @After
    public void tearDown(){
        response = null;
    }

    @When("I upload an image for user with id {long}")
    public void uploadImage(long id){
        response = imageResource.uploadImage(new byte[10], id);
    }

    @When("I delete an image for user with id {long}")
    public void deleteImage(long id){
        response = imageResource.deleteImage(id);
    }

    @When("I get an image for user with id {long}")
    public void getImageExists(long id){
        try{
            response = imageResource.getImage(id);
        }catch (WebApplicationException e){
            exceptionList.add(e);
        }

    }

    @Then("I should get a WebApplicationException with status code {int}")
    public void shouldGetError(int status){
        Assertions.assertEquals(1, exceptionList.size());
        Assertions.assertEquals(status, exceptionList.get(0).getResponse().getStatus());
    }

    @Then("I should get a status {int}")
    public void iShouldGetStatusCode(int status){
        Assertions.assertEquals(status, response.getStatus());
    }
}
