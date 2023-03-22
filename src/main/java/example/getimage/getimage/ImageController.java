package example.getimage.getimage;

import java.io.IOException;
import java.net.URL;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @GetMapping("/image.jpg")
    public ResponseEntity<InputStreamResource> getImage(@RequestParam(name = "guid") String guid) throws IOException {
        URL image = this.getClass().getResource("/generic.jpg");
        MediaType mimeType = MediaType.IMAGE_PNG;
        if(image.getPath().substring(image.getPath().lastIndexOf(".")+1).equalsIgnoreCase("jpg")) {
            mimeType = MediaType.IMAGE_JPEG;
        }

        return ResponseEntity.ok()
            .contentType(mimeType)
            .body(new InputStreamResource(image.openStream()));
    }

}