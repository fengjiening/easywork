package org.fengjiening;

import lombok.Data;
import org.fengjiening.word.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengjiening on 2020/9/3.
 */

@Data
@Word(fileName = "temp",trmpFile= "c://1.docx")
public class DocTemp {

    @Values
    private HashMap<String,Object> values;

}
