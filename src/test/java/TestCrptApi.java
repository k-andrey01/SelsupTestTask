import org.example.CrptApi;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TestCrptApi {

    @Test
    public void testCreateDocument() {
        CrptApi api = new CrptApi(TimeUnit.SECONDS, 10);

        CrptApi.Document document = new CrptApi.Document("123", "created", "type", "ownerInn", "participantInn",
                "producerInn", "2023-10-31", "productionType", "2023-10-31");
        CrptApi.Product product = new CrptApi.Product("ownerInn", "producerInn", "tnvedCode", "uitCode");

        document.addProduct(product);
        document.setReg_number("123");
        CrptApi.CustomResponse customResponse = api.createDocument(document, CrptApi.Product.ProductGroup.CLOTHES);

        Assert.assertNotEquals(Optional.ofNullable(customResponse.getStatusCode()), 200);
    }
}
