package org.fengjiening;

import lombok.Data;
import org.fengjiening.word.annotation.*;

import java.util.Map;

/**
 * Created by fengjiening on 2020/9/3.
 */

@Data
@Word(fileName = "hah")
public class Doc {
    @Title
    @Font(bold = true)
    private String title;
    @SubTitle
    @Font(bold = true)
    private String subTitle;
    @Paragraph
    private String paragraph;
    @Values
    private Map<String,Object> values;

}
