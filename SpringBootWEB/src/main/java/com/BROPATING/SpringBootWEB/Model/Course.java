package com.BROPATING.SpringBootWEB.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String courseCode;
    private String title;
    private int credits;
}
