package io.swagger.api;

import io.swagger.model.RefData;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T23:55:43.430Z")

@Controller
public class ConditionsApiController implements ConditionsApi {



    public ResponseEntity<List<RefData>> getWeatherOptions() {
        // do some magic!
        return new ResponseEntity<List<RefData>>(HttpStatus.OK);
    }

}
