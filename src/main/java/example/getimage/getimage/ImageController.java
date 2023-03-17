package example.getimage.getimage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @GetMapping("/image.jpg")
    public ResponseEntity<InputStreamResource> getImage(@RequestParam(name = "guid") String guid) throws FileNotFoundException {
        File image = new File("./generic.jpg");
        MediaType mimeType = MediaType.IMAGE_PNG;
        if(image.getName().substring(image.getName().lastIndexOf(".")+1).equalsIgnoreCase("jpg")) {
            mimeType = MediaType.IMAGE_JPEG;
        }

        return ResponseEntity.ok()
            .contentType(mimeType)
            .body(new InputStreamResource(new FileInputStream(image)));
    }

}