package com.lion;

import com.lion.domain.Hospital;
import com.lion.parser.HospitalParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospitalParserTest {

    @Test
    @DisplayName("Testing PARSER")
    void hospitalParsing(){
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse("eee");
        String sql = "INSERT INTO `likelion-db`.`seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n" +
                "(\"A1120837\",\n" +
                "\"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\",\n" +
                "\"서울특별시 금천구\",\n" +
                "\"C\",\n" +
                "2,\n" +
                "\"가산기대찬의원\",\n" +
                "\"\");";
        Assertions.assertEquals(sql, hospital.getSqlInsertQuery());
    }

   }