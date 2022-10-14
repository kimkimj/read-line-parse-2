package com.lion.parser;

import com.lion.Parser;
import com.lion.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {

    private String getSubdivision(String name) {
        String[] subdibisions = {"소아과", "피부과", "성형외과", "정형외과", "산부인과", "관절", "안과", "가정의학과", "비뇨기과", "치과", "내과", "외과"};

        for (String subdivision : subdibisions) {
            if (name.contains(subdivision)) {
                return subdivision;
            }
        }
        return "";
    }

    @Override
    public Hospital parse(String str) {
        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");

        String name = splitted[10];
        String subdivision = getSubdivision(name);

        return new Hospital(splitted[0], splitted[1], splitted[2],
                Integer.parseInt(splitted[6]), name, subdivision);
    }
}