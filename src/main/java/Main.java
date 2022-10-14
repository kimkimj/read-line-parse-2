

import com.lion.domain.Hospital;
import com.lion.parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        WriteFile<Hospital> hospitalFileController = new WriteFile<>(new HospitalParser());
        String filename = "\"C:\\Users\\Miji\\Desktop\\hospitals.csv";
        List<Hospital> hospitals = hospitalFileController.readLines(filename);

        System.out.println(hospitals.size());
        List<String> lines = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            lines.add(hospital.getSqlInsertQuery());
        }
        String sqlFilename = "hospital_insert.sql";
        hospitalFileController.createANewFile(sqlFilename);
        hospitalFileController.writeLines(lines, sqlFilename);

    }
}